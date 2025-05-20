package com.duocshop.duocshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duocshop.duocshop.model.UsuarioProducto;
import com.duocshop.duocshop.repository.UsuarioProductoRepository;

@Service
public class UsuarioProductoService {

    @Autowired
    private UsuarioProductoRepository usuarioProductoRepository;

    public List<UsuarioProducto> obtenerUsuarioProductos() {
        return usuarioProductoRepository.findAll();
    }
    public UsuarioProducto guardarUsuarioProducto(UsuarioProducto usuarioProducto) {
        return usuarioProductoRepository.save(usuarioProducto);
    }
    public UsuarioProducto actualizarUsuarioProducto(UsuarioProducto usuarioProducto) {
        return usuarioProductoRepository.save(usuarioProducto);
    }
    public void eliminarUsuarioProducto(Integer id) {
        usuarioProductoRepository.deleteById(id);
    }
    
}
