package com.sistemaventasropa.usuarios.dto;

import com.sistemaventasropa.usuarios.entity.Rol;

public record UsuarioResponse(
        Long id,
        String nombre,
        String email,
        Rol rol,
        Boolean activo
) {
}
