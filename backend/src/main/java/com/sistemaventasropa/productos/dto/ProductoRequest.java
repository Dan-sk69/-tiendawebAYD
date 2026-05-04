package com.sistemaventasropa.productos.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductoRequest(
        @NotBlank String nombre,
        String descripcion,
        @NotBlank String categoria,
        @NotBlank String talla,
        @NotBlank String color,
        @NotNull @DecimalMin("0.01") BigDecimal precio,
        @NotNull @Min(0) Integer stock
) {
}
