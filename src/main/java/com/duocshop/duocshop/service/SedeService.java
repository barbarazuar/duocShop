package com.duocshop.duocshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duocshop.duocshop.model.Sede;
import com.duocshop.duocshop.repository.SedeRepository;

@Service
public class SedeService {

    @Autowired
    private SedeRepository sedeRepository;

    public List<Sede> obtenerSedes() {
        return sedeRepository.findAll();
    }   

    public Sede guardarSede(Sede sede) {
        return sedeRepository.save(sede);
    }

    public Sede actualizarSede(Sede sede) {
        return sedeRepository.save(sede);
    }

    public void eliminarSede(Integer id) {
        sedeRepository.deleteById(id);
    }   
}
