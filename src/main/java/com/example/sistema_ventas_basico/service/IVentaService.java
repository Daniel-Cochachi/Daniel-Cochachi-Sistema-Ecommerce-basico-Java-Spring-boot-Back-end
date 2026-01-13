package com.example.sistema_ventas_basico.service;

import com.example.sistema_ventas_basico.dto.VentaDTO;
import com.example.sistema_ventas_basico.dto.VentaResponseDTO;

import java.util.List;

public interface IVentaService {

    VentaDTO registrarVenta(VentaDTO dto);

    List<VentaResponseDTO> listarVentas();

    VentaResponseDTO buscarPorId(Long id);
}
