package com.example.sistema_ventas_basico.controller;

import com.example.sistema_ventas_basico.dto.VentaDTO;
import com.example.sistema_ventas_basico.dto.VentaResponseDTO;
import com.example.sistema_ventas_basico.service.VentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
@RequiredArgsConstructor
public class VentaController {

    private final VentaService ventaService;

    @GetMapping
    public List<VentaResponseDTO> listar() {
        return ventaService.listarVentas();
    }

    @GetMapping("/{id}")
    public VentaResponseDTO buscar(@PathVariable Long id) {
        return ventaService.buscarPorId(id);
    }

    @PostMapping
    public VentaDTO registrar( @RequestBody VentaDTO dto) {
        return ventaService.registrarVenta(dto);
    }
}
