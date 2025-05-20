package com.duocshop.duocshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duocshop.duocshop.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
