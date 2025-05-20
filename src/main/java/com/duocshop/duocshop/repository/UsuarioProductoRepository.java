package com.duocshop.duocshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duocshop.duocshop.model.UsuarioProducto;

@Repository
public interface UsuarioProductoRepository extends JpaRepository<UsuarioProducto, Integer> {
    
}
