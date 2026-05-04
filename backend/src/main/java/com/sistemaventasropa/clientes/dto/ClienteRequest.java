package com.sistemaventasropa.clientes.dto;

import jakarta.validation.constraints.NotBlank;

public record ClienteRequest(
        @NotBlank String nombre,
        String documento,
        String telefono,
        String email,
        String direccion
) {
}
