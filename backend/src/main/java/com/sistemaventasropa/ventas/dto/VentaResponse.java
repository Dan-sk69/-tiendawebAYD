package com.sistemaventasropa.ventas.dto;

import com.sistemaventasropa.ventas.entity.EstadoVenta;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record VentaResponse(
        Long id,
        Long clienteId,
        Long usuarioId,
        BigDecimal total,
        EstadoVenta estado,
        LocalDateTime creadoEn
) {
}
