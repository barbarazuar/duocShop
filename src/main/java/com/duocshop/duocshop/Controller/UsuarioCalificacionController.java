package com.duocshop.duocshop.Controller;

import java.util.List;
import java.util.Map;

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

import com.duocshop.duocshop.model.UsuarioCalificacion;
import com.duocshop.duocshop.service.UsuarioCalificacionService;

@RestController
@RequestMapping("/api/v1/usuario-calificacion")

public class UsuarioCalificacionController {

    @Autowired
    private UsuarioCalificacionService usuarioCalificacionService;

    @GetMapping 
    public ResponseEntity<List<UsuarioCalificacion>> listar() {
        List<UsuarioCalificacion> usuarioCalificaciones = usuarioCalificacionService.obtenerUsuarioCalificaciones();
        if (usuarioCalificaciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarioCalificaciones);
    }

    @PostMapping
    public ResponseEntity<UsuarioCalificacion> guardar(@RequestBody UsuarioCalificacion usuarioCalificacion) {
        UsuarioCalificacion nuevaUsuarioCalificacion = usuarioCalificacionService.guardarUsuarioCalificacion(usuarioCalificacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaUsuarioCalificacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioCalificacion> actualizar(@PathVariable Integer id, @RequestBody UsuarioCalificacion usuarioCalificacion) {
        try {
            usuarioCalificacionService.guardarUsuarioCalificacion(usuarioCalificacion);
            return ResponseEntity.ok(usuarioCalificacion);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UsuarioCalificacion> patchUsuarioCalificacion(@PathVariable Integer id, @RequestBody UsuarioCalificacion usuarioCalificacion) {
        try {
            UsuarioCalificacion updatedUsuarioCalificacion = usuarioCalificacionService.actualizarUsuarioCalificacion(usuarioCalificacion);
            return ResponseEntity.ok(updatedUsuarioCalificacion);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            usuarioCalificacionService.eliminarUsuarioCalificacion(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/resumen")
    public ResponseEntity<List<Map<String, Object>>> resumen() {
        List<Map<String, Object>> resumen = usuarioCalificacionService.obtenerUsuarioCalificacion();
        if (resumen.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resumen);
    }
}
