package com.sistemaventasropa.ventas.service;

import com.sistemaventasropa.clientes.entity.Cliente;
import com.sistemaventasropa.clientes.repository.ClienteRepository;
import com.sistemaventasropa.exception.ResourceNotFoundException;
import com.sistemaventasropa.usuarios.entity.Usuario;
import com.sistemaventasropa.usuarios.repository.UsuarioRepository;
import com.sistemaventasropa.ventas.dto.VentaRequest;
import com.sistemaventasropa.ventas.dto.VentaResponse;
import com.sistemaventasropa.ventas.entity.EstadoVenta;
import com.sistemaventasropa.ventas.entity.Venta;
import com.sistemaventasropa.ventas.repository.VentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {

    private final VentaRepository ventaRepository;
    private final ClienteRepository clienteRepository;
    private final UsuarioRepository usuarioRepository;

    public VentaService(
            VentaRepository ventaRepository,
            ClienteRepository clienteRepository,
            UsuarioRepository usuarioRepository
    ) {
        this.ventaRepository = ventaRepository;
        this.clienteRepository = clienteRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<VentaResponse> listar() {
        return ventaRepository.findAll().stream().map(this::toResponse).toList();
    }

    public VentaResponse crear(VentaRequest request) {
        Cliente cliente = request.clienteId() == null
                ? null
                : clienteRepository.findById(request.clienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
        Usuario usuario = usuarioRepository.findById(request.usuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        Venta venta = Venta.builder()
                .cliente(cliente)
                .usuario(usuario)
                .total(request.total())
                .estado(EstadoVenta.REGISTRADA)
                .build();
        return toResponse(ventaRepository.save(venta));
    }

    private VentaResponse toResponse(Venta venta) {
        Long clienteId = venta.getCliente() == null ? null : venta.getCliente().getId();
        return new VentaResponse(
                venta.getId(),
                clienteId,
                venta.getUsuario().getId(),
                venta.getTotal(),
                venta.getEstado(),
                venta.getCreadoEn()
        );
    }
}
