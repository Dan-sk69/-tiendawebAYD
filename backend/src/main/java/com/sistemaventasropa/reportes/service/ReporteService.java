package com.sistemaventasropa.reportes.service;

import com.sistemaventasropa.reportes.dto.ResumenVentasResponse;
import com.sistemaventasropa.ventas.entity.EstadoVenta;
import com.sistemaventasropa.ventas.repository.VentaRepository;
import org.springframework.stereotype.Service;

@Service
public class ReporteService {

    private final VentaRepository ventaRepository;

    public ReporteService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    public ResumenVentasResponse resumenVentas() {
        return new ResumenVentasResponse(
                ventaRepository.countByEstado(EstadoVenta.REGISTRADA),
                ventaRepository.countByEstado(EstadoVenta.PAGADA),
                ventaRepository.countByEstado(EstadoVenta.ANULADA),
                ventaRepository.sumarTotalVentas()
        );
    }
}
