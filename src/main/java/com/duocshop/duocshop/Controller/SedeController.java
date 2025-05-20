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

import com.duocshop.duocshop.model.Sede;
import com.duocshop.duocshop.service.SedeService;

@RestController
@RequestMapping("/api/v1/sede")

public class SedeController {

    @Autowired
    private SedeService sedeService;

    @GetMapping
    public ResponseEntity<List<Sede>> listar() {
        List<Sede> sedes = sedeService.obtenerSedes();
        if (sedes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(sedes);
    }

    @PostMapping
    public ResponseEntity<Sede> guardar(@RequestBody Sede sede) {
        Sede nuevaSede = sedeService.guardarSede(sede);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaSede);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sede> actualizar(@PathVariable Integer id,@RequestBody Sede sede) {
        try {
            sedeService.guardarSede(sede);
            return ResponseEntity.ok(sede);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<Sede> patchSede(Integer id, Sede sede) {
        try {
            Sede updatedSede = sedeService.actualizarSede(sede);
            return ResponseEntity.ok(updatedSede);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            sedeService.eliminarSede(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
