package com.sistemaventasropa.productos.dto;

import java.math.BigDecimal;

public record ProductoResponse(
        Long id,
        String nombre,
        String descripcion,
        String categoria,
        String talla,
        String color,
        BigDecimal precio,
        Integer stock,
        Boolean activo
) {
}
