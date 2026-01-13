package com.example.sistema_ventas_basico.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductoDTO {
    private Long id;

    @NotBlank(message = "El nombre del producto es obligatorio")
    @Size(min = 3, max = 200, message = "Debe tener entre 3 y 200 caracteres")
    private String nombre;


    private double precio;

    // Relación representada correctamente
    private Long categoriaId;
    private String categoriaNombre;
}
