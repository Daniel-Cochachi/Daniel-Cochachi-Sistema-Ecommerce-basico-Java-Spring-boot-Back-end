package com.example.sistema_ventas_basico.service;

import com.example.sistema_ventas_basico.dto.CategoriaDTO;

import java.util.List;

public interface ICategoriaService {

    CategoriaDTO crear(CategoriaDTO dto);

    List<CategoriaDTO> listar();

    CategoriaDTO buscarPorId(Long id);

    CategoriaDTO actualizar(Long id, CategoriaDTO dto);

    void eliminar(Long id);
}
