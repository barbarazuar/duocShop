package com.duocshop.duocshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duocshop.duocshop.model.Calificacion;
import com.duocshop.duocshop.repository.CalificacionRepository;

@Service
public class CalificacionService {

    @Autowired
    private CalificacionRepository calificacionRepository;
    


    public List<Calificacion> obtenerCalificaciones() {
        return calificacionRepository.findAll();
    }

    public Calificacion guardarCalificacion(Calificacion calificacion) {
        return calificacionRepository.save(calificacion);
    }

    public Calificacion actualizarCalificacion(Calificacion calificacion) {
        return calificacionRepository.save(calificacion);
    }

    public void eliminarCalificacion(Integer id) {
        calificacionRepository.deleteById(id);
    }
}    