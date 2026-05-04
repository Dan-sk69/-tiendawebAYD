package com.sistemaventasropa.clientes.repository;

import com.sistemaventasropa.clientes.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
