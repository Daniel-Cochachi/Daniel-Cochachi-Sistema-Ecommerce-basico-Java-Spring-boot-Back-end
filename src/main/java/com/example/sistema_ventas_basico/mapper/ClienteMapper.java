package com.example.sistema_ventas_basico.mapper;

import com.example.sistema_ventas_basico.dto.ClienteDTO;
import com.example.sistema_ventas_basico.model.Cliente;

public class ClienteMapper {

    // Entity → DTO

    public static ClienteDTO toDTO(Cliente cliente){

        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNombre(cliente.getNombre());
        dto.setApellido(cliente.getApellido());
        dto.setDni(cliente.getDni());
        dto.setEmail(cliente.getEmail());

        return dto;
    }

    // DTO -> Entity

    public static Cliente toEntity(ClienteDTO dto){

        Cliente cliente = new Cliente();
        cliente.setId(dto.getId());
        cliente.setNombre(dto.getNombre());
        cliente.setApellido(dto.getApellido());
        cliente.setDni(dto.getDni());
        cliente.setEmail(dto.getEmail());

        return cliente;
    }
}
