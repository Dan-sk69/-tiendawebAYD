package com.sistemaventasropa.reportes.controller;

import com.sistemaventasropa.reportes.dto.ResumenVentasResponse;
import com.sistemaventasropa.reportes.service.ReporteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    private final ReporteService reporteService;

    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @GetMapping("/ventas")
    public ResumenVentasResponse resumenVentas() {
        return reporteService.resumenVentas();
    }
}
