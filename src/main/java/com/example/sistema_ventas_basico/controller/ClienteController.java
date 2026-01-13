package com.example.sistema_ventas_basico.controller;


import com.example.sistema_ventas_basico.dto.ClienteDTO;
import com.example.sistema_ventas_basico.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public List<ClienteDTO> listar(){
        return clienteService.listar();
    }
    @GetMapping("/{id}")
    public ClienteDTO buscar(@Valid @PathVariable Long id){
        return clienteService.buscarPorId(id);
    }

    @PostMapping
    public ClienteDTO crear(@Valid @RequestBody ClienteDTO dto){
        return clienteService.crear(dto);
    }

    @PutMapping("/{id}")
    public ClienteDTO update(@Valid @PathVariable Long id,@RequestBody ClienteDTO dto){
        return clienteService.actualizar(id,dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@Valid @PathVariable Long id){
        clienteService.eliminar(id);
    }
}
