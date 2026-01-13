package com.example.sistema_ventas_basico.repository;

import com.example.sistema_ventas_basico.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    boolean existsByDni(String dni);
}
