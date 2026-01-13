package com.example.sistema_ventas_basico.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VentaDTO {
    private Long clienteId;
    private List<DetalleVentaDTO> detalles;
}
