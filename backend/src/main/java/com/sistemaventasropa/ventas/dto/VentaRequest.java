package com.sistemaventasropa.ventas.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record VentaRequest(
        Long clienteId,
        @NotNull Long usuarioId,
        @NotNull @DecimalMin("0.01") BigDecimal total
) {
}
