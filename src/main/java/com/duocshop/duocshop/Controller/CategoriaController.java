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

import com.duocshop.duocshop.model.Categoria;
import com.duocshop.duocshop.service.CategoriaService;

@RestController
@RequestMapping("/api/v1/categoria")

public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> listar(){
       List<Categoria> categorias = categoriaService.obtenerCategorias();
       if (categorias.isEmpty()) {
           return ResponseEntity.noContent().build();
       }  
        return ResponseEntity.ok(categorias);  
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizar(@PathVariable Integer id, @RequestBody Categoria categoria) {
        try{
            categoriaService.guardarCategoria(categoria);
            return ResponseEntity.ok(categoria);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }   

    @PostMapping
    public ResponseEntity<Categoria> guardar(@RequestBody Categoria categoria) {
        Categoria nuevaCategoria = categoriaService.guardarCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCategoria);
    }   

    @PatchMapping("/{id}")
    public ResponseEntity<Categoria> patchCategoria(@PathVariable Integer id, @RequestBody Categoria categoria) {
        try{
            Categoria updatedCategoria = categoriaService.actualizarCategoria(categoria);
            return ResponseEntity.ok(updatedCategoria);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try{
            categoriaService.eliminarCategoria(id);
            return ResponseEntity.noContent().build();
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }    
}
