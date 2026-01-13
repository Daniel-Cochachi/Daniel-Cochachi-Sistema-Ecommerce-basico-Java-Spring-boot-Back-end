package com.example.sistema_ventas_basico.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VentaResponseDTO {
    private Long id;
    private String cliente;
    private LocalDateTime fecha;
    private double total;
    private List<DetalleVentaResponseDTO> detalles;
}
