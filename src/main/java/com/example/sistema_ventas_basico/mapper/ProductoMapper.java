package com.example.sistema_ventas_basico.mapper;

import com.example.sistema_ventas_basico.dto.ProductoDTO;
import com.example.sistema_ventas_basico.model.Producto;

public class ProductoMapper {

    //Entity -> DTO

    public static ProductoDTO toDTO(Producto producto){

        ProductoDTO dto = new ProductoDTO();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setPrecio(producto.getPrecio());

        dto.setCategoriaId(producto.getCategoria().getId());
        dto.setCategoriaNombre(producto.getCategoria().getNombre());

        return dto;
    }
}
