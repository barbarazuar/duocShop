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

import com.duocshop.duocshop.model.UsuarioProducto;
import com.duocshop.duocshop.service.UsuarioProductoService;

@RestController
@RequestMapping("/api/v1/usuario-producto")

public class UsuarioProductoControler {

    @Autowired
    private UsuarioProductoService usuarioProductoService;

    @GetMapping
    public ResponseEntity<List<UsuarioProducto>> listar() {
        List<UsuarioProducto> usuarioProductos = usuarioProductoService.obtenerUsuarioProductos();
        if (usuarioProductos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarioProductos);
    }

    @PostMapping
    public ResponseEntity<UsuarioProducto> guardar(@RequestBody UsuarioProducto usuarioProducto) {
        UsuarioProducto nuevoUsuarioProducto = usuarioProductoService.guardarUsuarioProducto(usuarioProducto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuarioProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioProducto> actualizar(@PathVariable Integer id, @RequestBody UsuarioProducto usuarioProducto) {
        try {
            usuarioProductoService.guardarUsuarioProducto(usuarioProducto);
            return ResponseEntity.ok(usuarioProducto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UsuarioProducto> patchUsuarioProducto(@PathVariable Integer id, @RequestBody UsuarioProducto usuarioProducto) {
        try {
            UsuarioProducto updatedUsuarioProducto = usuarioProductoService.actualizarUsuarioProducto(usuarioProducto);
            return ResponseEntity.ok(updatedUsuarioProducto);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            usuarioProductoService.eliminarUsuarioProducto(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
