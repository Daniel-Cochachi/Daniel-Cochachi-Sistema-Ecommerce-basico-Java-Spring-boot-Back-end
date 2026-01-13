package com.example.sistema_ventas_basico.controller;

import com.example.sistema_ventas_basico.dto.ProductoDTO;
import com.example.sistema_ventas_basico.service.ProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping
    public List<ProductoDTO> listar(){
        return productoService.listar();
    }

    @GetMapping("/{id}")
    public ProductoDTO buscarPorId(@Valid @PathVariable Long id){
        return productoService.buscarPorId(id);
    }

    @PostMapping
    public ProductoDTO crear(@Valid @RequestBody ProductoDTO dto){
        return productoService.crear(dto);
    }

    @PutMapping("/{id}")
    public ProductoDTO actualizar(@Valid @PathVariable Long id,@RequestBody ProductoDTO dto){
        return productoService.actualizar(id,dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@Valid @PathVariable Long id){
        productoService.eliminar(id);
    }
}
