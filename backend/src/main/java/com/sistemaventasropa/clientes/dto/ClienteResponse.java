package com.sistemaventasropa.clientes.dto;

public record ClienteResponse(
        Long id,
        String nombre,
        String documento,
        String telefono,
        String email,
        String direccion
) {
}
