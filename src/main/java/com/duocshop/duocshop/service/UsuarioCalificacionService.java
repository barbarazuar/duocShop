package com.duocshop.duocshop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<Map<String, Object>> obtenerUsuarioCalificacion() {
        List<Object[]> resultados = usuarioCalificacionRepository.findUsuarioCalificacion();
        List<Map<String, Object>> lista = new ArrayList<>();

        for (Object[] fila : resultados) {
            Map<String, Object> datos = new HashMap<>();
            datos.put("usuarioCalificacion", fila[0]);
            datos.put("nombreUsuario", fila[1]);
            datos.put("calificacionUsuario", fila[2]);
            lista.add(datos);
        }

        return lista;
    }
}
