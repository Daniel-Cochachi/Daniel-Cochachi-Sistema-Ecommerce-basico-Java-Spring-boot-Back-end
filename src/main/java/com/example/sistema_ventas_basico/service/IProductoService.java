package com.example.sistema_ventas_basico.service;

import com.example.sistema_ventas_basico.dto.ProductoDTO;

import java.util.List;

public interface IProductoService {

    ProductoDTO crear(ProductoDTO dto);

    List<ProductoDTO> listar();

    ProductoDTO buscarPorId(Long id);

    ProductoDTO actualizar(Long id, ProductoDTO dto);

    void eliminar(Long id);
}
