package com.sistemaventasropa.usuarios.dto;

import com.sistemaventasropa.usuarios.entity.Rol;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioRequest(
        @NotBlank String nombre,
        @Email @NotBlank String email,
        @NotBlank String password,
        @NotNull Rol rol,
        Boolean activo
) {
}
