package com.example.sistema_ventas_basico.service;

import com.example.sistema_ventas_basico.dto.ClienteDTO;

import java.util.List;

public interface IClienteService {
    ClienteDTO crear(ClienteDTO dto);

    List<ClienteDTO> listar();

    ClienteDTO buscarPorId(Long id);

    ClienteDTO actualizar(Long id, ClienteDTO dto);

    void eliminar(Long id);
}
