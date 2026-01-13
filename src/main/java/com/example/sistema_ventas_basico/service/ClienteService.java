package com.example.sistema_ventas_basico.service;


import com.example.sistema_ventas_basico.dto.ClienteDTO;
import com.example.sistema_ventas_basico.exception.ResourceNotFoundException;
import com.example.sistema_ventas_basico.mapper.ClienteMapper;
import com.example.sistema_ventas_basico.model.Cliente;
import com.example.sistema_ventas_basico.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService implements IClienteService{

    private final ClienteRepository clienteRepository;

    @Override
    public ClienteDTO crear(ClienteDTO dto) {

        if (clienteRepository.existsByDni(dto.getDni())){
            throw new ResourceNotFoundException("El Dni Ya existe");
        }

        Cliente cliente = ClienteMapper.toEntity(dto);

        Cliente guardado = clienteRepository.save(cliente);

        return ClienteMapper.toDTO(guardado);
    }

    @Override
    public List<ClienteDTO> listar() {
        return clienteRepository.findAll().stream()
                .map(ClienteMapper::toDTO)
                .toList();
    }

    @Override
    public ClienteDTO buscarPorId(Long id) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Cliente no encontrado"));

        return ClienteMapper.toDTO(cliente);
    }


    @Override
    public ClienteDTO actualizar(Long id, ClienteDTO dto) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Cliente no encontrado"));

        // Validar DNI solo si cambia
        if (!cliente.getDni().equals(dto.getDni())
                && clienteRepository.existsByDni(dto.getDni())) {
            throw new ResourceNotFoundException("El DNI ya está en uso");
        }

        cliente.setNombre(dto.getNombre());
        cliente.setApellido(dto.getApellido());
        cliente.setDni(dto.getDni());
        cliente.setEmail(dto.getEmail());

        Cliente actualizado = clienteRepository.save(cliente);

        return ClienteMapper.toDTO(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente no existe");
        }

        clienteRepository.deleteById(id);
    }
}
