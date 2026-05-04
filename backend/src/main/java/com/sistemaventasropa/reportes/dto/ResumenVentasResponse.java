package com.sistemaventasropa.reportes.dto;

import java.math.BigDecimal;

public record ResumenVentasResponse(
        long ventasRegistradas,
        long ventasPagadas,
        long ventasAnuladas,
        BigDecimal totalVendido
) {
}
