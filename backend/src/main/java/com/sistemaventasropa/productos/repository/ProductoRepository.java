package com.sistemaventasropa.productos.repository;

import com.sistemaventasropa.productos.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
