package com.example.sistema_ventas_basico.mapper;

import com.example.sistema_ventas_basico.dto.CategoriaDTO;
import com.example.sistema_ventas_basico.model.Categoria;

public class CategoriaMapper {

    // Entity → DTO
    public static CategoriaDTO toDTO(Categoria categoria) {

        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(categoria.getId());
        dto.setNombre(categoria.getNombre());

        return dto;
    }

    // DTO -> Entity

    public static Categoria toEntity(CategoriaDTO dto){
        Categoria categoria = new Categoria();
        categoria.setId(dto.getId());
        categoria.setNombre(dto.getNombre());

        return categoria;
    }
}
