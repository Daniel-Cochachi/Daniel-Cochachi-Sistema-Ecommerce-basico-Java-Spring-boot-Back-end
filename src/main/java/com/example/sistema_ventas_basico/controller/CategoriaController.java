package com.example.sistema_ventas_basico.controller;

import com.example.sistema_ventas_basico.dto.CategoriaDTO;
import com.example.sistema_ventas_basico.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public List<CategoriaDTO> listar(){
        return categoriaService.listar();
    }
    @GetMapping("/{id}")
    public CategoriaDTO buscar(@Valid @PathVariable Long id){
        return categoriaService.buscarPorId(id);
    }

    @PostMapping
    public CategoriaDTO crear(@Valid @RequestBody CategoriaDTO dto){
        return categoriaService.crear(dto);
    }

    @PutMapping("/{id}")
    public CategoriaDTO update(@Valid @PathVariable Long id,@RequestBody CategoriaDTO dto){
        return categoriaService.actualizar(id,dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@Valid @PathVariable Long id){
        categoriaService.eliminar(id);
    }
}
