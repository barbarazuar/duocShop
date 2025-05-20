package com.duocshop.duocshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duocshop.duocshop.model.CategoriaProducto;
import com.duocshop.duocshop.repository.CategoriaProductoRepository;

@Service
public class CategoriaProductoService {

    @Autowired
    private CategoriaProductoRepository categoriaProductoRepository;

    public List<CategoriaProducto> obtenerCategoriaProductos() {
        return categoriaProductoRepository.findAll();
    }

    public CategoriaProducto guardarCategoriaProducto(CategoriaProducto categoriaProducto) {
        return categoriaProductoRepository.save(categoriaProducto);
    }

    public CategoriaProducto actualizarCategoriaProducto(CategoriaProducto categoriaProducto) {
        return categoriaProductoRepository.save(categoriaProducto);
    }

    public void eliminarCategoriaProducto(Integer id) {
        categoriaProductoRepository.deleteById(id);
    }
    
}
