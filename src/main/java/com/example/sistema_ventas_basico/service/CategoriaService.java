package com.example.sistema_ventas_basico.service;

import com.example.sistema_ventas_basico.dto.CategoriaDTO;
import com.example.sistema_ventas_basico.exception.ResourceNotFoundException;
import com.example.sistema_ventas_basico.mapper.CategoriaMapper;
import com.example.sistema_ventas_basico.model.Categoria;
import com.example.sistema_ventas_basico.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService implements ICategoriaService{

    private final CategoriaRepository categoriaRepository;

    @Override
    public CategoriaDTO crear(CategoriaDTO dto) {

        Categoria categoria = CategoriaMapper.toEntity(dto);

        Categoria guardada = categoriaRepository.save(categoria);

        return  CategoriaMapper.toDTO(guardada);

    }

    @Override
    public List<CategoriaDTO> listar() {
        return categoriaRepository.findAll().stream()
                .map(CategoriaMapper::toDTO)
                .toList();
    }

    @Override
    public CategoriaDTO buscarPorId(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Categoria no encontrada"));
        return CategoriaMapper.toDTO(categoria);
    }

    @Override
    public CategoriaDTO actualizar(Long id, CategoriaDTO dto) {
        Categoria existente = categoriaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Categoria no encontrada"));

        // SOLO se actualizan campos
        existente.setNombre(dto.getNombre());

        Categoria actualizada = categoriaRepository.save(existente);

        return CategoriaMapper.toDTO(actualizada);
    }

    @Override
    public void eliminar(Long id) {
        if (!categoriaRepository.existsById(id))
            throw new ResourceNotFoundException("Categoria no existe");

        categoriaRepository.deleteById(id);
    }
}
