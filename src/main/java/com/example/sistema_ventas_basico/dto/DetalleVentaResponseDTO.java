package com.example.sistema_ventas_basico.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetalleVentaResponseDTO {

    private String producto;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;
}
