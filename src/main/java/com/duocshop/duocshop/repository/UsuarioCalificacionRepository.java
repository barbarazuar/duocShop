package com.duocshop.duocshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duocshop.duocshop.model.UsuarioCalificacion;

@Repository
public interface UsuarioCalificacionRepository extends JpaRepository<UsuarioCalificacion, Integer> {
    

}
