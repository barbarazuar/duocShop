package com.duocshop.duocshop.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.duocshop.duocshop.model.Calificacion;
import com.duocshop.duocshop.service.CalificacionService;

@RestController
@RequestMapping("/api/v1/calificacion")

public class CalificacionController {

    @Autowired
    private CalificacionService calificacionService;

    @GetMapping
    public ResponseEntity<List<Calificacion>> listar() {
        List<Calificacion> calificaciones = calificacionService.obtenerCalificaciones();
        if (calificaciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(calificaciones);
    }

    @PostMapping
    public ResponseEntity<Calificacion> guardar(@RequestBody Calificacion calificacion) {
        Calificacion nuevaCalificacion = calificacionService.guardarCalificacion(calificacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCalificacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Calificacion> actualizar(@PathVariable Integer id, @RequestBody Calificacion calificacion) {
        try{
            calificacionService.guardarCalificacion(calificacion);
            return ResponseEntity.ok(calificacion);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try{
            calificacionService.eliminarCalificacion(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
