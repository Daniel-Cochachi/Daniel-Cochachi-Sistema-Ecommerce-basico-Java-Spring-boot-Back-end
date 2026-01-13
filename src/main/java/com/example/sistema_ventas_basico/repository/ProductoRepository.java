package com.example.sistema_ventas_basico.repository;

import com.example.sistema_ventas_basico.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Long> {
}
