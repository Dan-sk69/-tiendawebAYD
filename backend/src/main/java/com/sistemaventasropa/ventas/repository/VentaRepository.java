package com.sistemaventasropa.ventas.repository;

import com.sistemaventasropa.ventas.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface VentaRepository extends JpaRepository<Venta, Long> {

    long countByEstado(com.sistemaventasropa.ventas.entity.EstadoVenta estado);

    @Query("select coalesce(sum(v.total), 0) from Venta v")
    BigDecimal sumarTotalVentas();
}
