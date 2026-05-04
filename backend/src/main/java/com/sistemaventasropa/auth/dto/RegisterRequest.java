package com.sistemaventasropa.auth.dto;

import com.sistemaventasropa.usuarios.entity.Rol;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterRequest(
        @NotBlank String nombre,
        @Email @NotBlank String email,
        @NotBlank String password,
        Rol rol
) {
}
