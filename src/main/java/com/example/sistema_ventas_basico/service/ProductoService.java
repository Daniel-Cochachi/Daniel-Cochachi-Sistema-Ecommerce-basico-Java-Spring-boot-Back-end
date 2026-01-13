package com.example.sistema_ventas_basico.service;

import com.example.sistema_ventas_basico.dto.ProductoDTO;
import com.example.sistema_ventas_basico.exception.ResourceNotFoundException;
import com.example.sistema_ventas_basico.mapper.ProductoMapper;
import com.example.sistema_ventas_basico.model.Categoria;
import com.example.sistema_ventas_basico.model.Producto;
import com.example.sistema_ventas_basico.repository.CategoriaRepository;
import com.example.sistema_ventas_basico.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService implements IProductoService{

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    @Override
    public ProductoDTO crear(ProductoDTO dto) {

        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(()-> new ResourceNotFoundException("Categoria no existe"));

        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setCategoria(categoria);

        Producto guardado = productoRepository.save(producto);

        return ProductoMapper.toDTO(guardado);

    }

    @Override
    public List<ProductoDTO> listar() {
        return productoRepository.findAll().stream()
                .map(ProductoMapper::toDTO)
                .toList();
    }

    @Override
    public ProductoDTO buscarPorId(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Producto no encontrado"));

        return ProductoMapper.toDTO(producto);
    }

    @Override
    public ProductoDTO actualizar(Long id, ProductoDTO dto) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Producto no encontrado"));

        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(()-> new ResourceNotFoundException("Categoria no existe"));

        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setCategoria(categoria);

        Producto actualizado = productoRepository.save(producto);

        return ProductoMapper.toDTO(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Producto no existe");
        }

        productoRepository.deleteById(id);
    }
}
