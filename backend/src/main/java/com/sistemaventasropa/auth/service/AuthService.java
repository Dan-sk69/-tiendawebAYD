package com.sistemaventasropa.auth.service;

import com.sistemaventasropa.auth.dto.AuthResponse;
import com.sistemaventasropa.auth.dto.LoginRequest;
import com.sistemaventasropa.auth.dto.RegisterRequest;
import com.sistemaventasropa.exception.BusinessException;
import com.sistemaventasropa.security.JwtService;
import com.sistemaventasropa.usuarios.entity.Rol;
import com.sistemaventasropa.usuarios.entity.Usuario;
import com.sistemaventasropa.usuarios.repository.UsuarioRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;

    public AuthService(
            AuthenticationManager authenticationManager,
            JwtService jwtService,
            PasswordEncoder passwordEncoder,
            UsuarioRepository usuarioRepository
    ) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.usuarioRepository = usuarioRepository;
    }

    public AuthResponse registrar(RegisterRequest request) {
        if (usuarioRepository.existsByEmail(request.email())) {
            throw new BusinessException("El email ya esta registrado");
        }

        Usuario usuario = Usuario.builder()
                .nombre(request.nombre())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .rol(request.rol() == null ? Rol.VENDEDOR : request.rol())
                .activo(true)
                .build();

        usuarioRepository.save(usuario);
        return new AuthResponse(jwtService.generateToken(usuario), "Bearer");
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );
        Usuario usuario = usuarioRepository.findByEmail(request.email())
                .orElseThrow(() -> new BusinessException("Credenciales invalidas"));
        return new AuthResponse(jwtService.generateToken(usuario), "Bearer");
    }
}
