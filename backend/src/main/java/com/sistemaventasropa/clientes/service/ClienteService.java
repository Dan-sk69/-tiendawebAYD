package com.sistemaventasropa.clientes.service;

import com.sistemaventasropa.clientes.dto.ClienteRequest;
import com.sistemaventasropa.clientes.dto.ClienteResponse;
import com.sistemaventasropa.clientes.entity.Cliente;
import com.sistemaventasropa.clientes.repository.ClienteRepository;
import com.sistemaventasropa.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteResponse> listar() {
        return clienteRepository.findAll().stream().map(this::toResponse).toList();
    }

    public ClienteResponse obtenerPorId(Long id) {
        return clienteRepository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
    }

    public ClienteResponse crear(ClienteRequest request) {
        Cliente cliente = Cliente.builder()
                .nombre(request.nombre())
                .documento(request.documento())
                .telefono(request.telefono())
                .email(request.email())
                .direccion(request.direccion())
                .build();
        return toResponse(clienteRepository.save(cliente));
    }

    public ClienteResponse actualizar(Long id, ClienteRequest request) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));

        cliente.setNombre(request.nombre());
        cliente.setDocumento(request.documento());
        cliente.setTelefono(request.telefono());
        cliente.setEmail(request.email());
        cliente.setDireccion(request.direccion());

        return toResponse(clienteRepository.save(cliente));
    }

    public void eliminar(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente no encontrado");
        }
        clienteRepository.deleteById(id);
    }

    private ClienteResponse toResponse(Cliente cliente) {
        return new ClienteResponse(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getDocumento(),
                cliente.getTelefono(),
                cliente.getEmail(),
                cliente.getDireccion()
        );
    }
}
