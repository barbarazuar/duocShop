package com.duocshop.duocshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duocshop.duocshop.model.UsuarioCalificacion;
import com.duocshop.duocshop.repository.UsuarioCalificacionRepository;

@Service
public class UsuarioCalificacionService {

    @Autowired
    private UsuarioCalificacionRepository usuarioCalificacionRepository;

    public List<UsuarioCalificacion> obtenerUsuarioCalificaciones() {
        return usuarioCalificacionRepository.findAll();
    }
    public UsuarioCalificacion guardarUsuarioCalificacion(UsuarioCalificacion usuarioCalificacion) {
        return usuarioCalificacionRepository.save(usuarioCalificacion);
    }
    public UsuarioCalificacion actualizarUsuarioCalificacion(UsuarioCalificacion usuarioCalificacion) {
        return usuarioCalificacionRepository.save(usuarioCalificacion);
    }
    public void eliminarUsuarioCalificacion(Integer id) {
        usuarioCalificacionRepository.deleteById(id);
    }
}
