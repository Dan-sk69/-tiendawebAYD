package com.sistemaventasropa.auth.dto;

public record AuthResponse(
        String token,
        String tokenType
) {
}
