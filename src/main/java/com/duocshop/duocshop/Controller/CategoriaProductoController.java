package com.duocshop.duocshop.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duocshop.duocshop.model.CategoriaProducto;
import com.duocshop.duocshop.service.CategoriaProductoService;

@RestController
@RequestMapping("/api/v1/categoria-producto")

public class CategoriaProductoController {

    @Autowired
    private CategoriaProductoService categoriaProductoService;

    @GetMapping
    public ResponseEntity<List<CategoriaProducto>> listar() {
        List<CategoriaProducto> categoriaProductos = categoriaProductoService.obtenerCategoriaProductos();
        if (categoriaProductos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categoriaProductos);
    }

    @PostMapping
    public ResponseEntity<CategoriaProducto> guardar(@RequestBody CategoriaProducto categoriaProducto) {
        CategoriaProducto nuevaCategoriaProducto = categoriaProductoService.guardarCategoriaProducto(categoriaProducto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCategoriaProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaProducto> actualizar(@PathVariable Integer id, @RequestBody CategoriaProducto categoriaProducto) {
        try {
            categoriaProductoService.guardarCategoriaProducto(categoriaProducto);
            return ResponseEntity.ok(categoriaProducto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CategoriaProducto> patchCategoriaProducto(@PathVariable Integer id, @RequestBody CategoriaProducto categoriaProducto) {
        try {
            CategoriaProducto updatedCategoriaProducto = categoriaProductoService.actualizarCategoriaProducto(categoriaProducto);
            return ResponseEntity.ok(updatedCategoriaProducto);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            categoriaProductoService.eliminarCategoriaProducto(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
