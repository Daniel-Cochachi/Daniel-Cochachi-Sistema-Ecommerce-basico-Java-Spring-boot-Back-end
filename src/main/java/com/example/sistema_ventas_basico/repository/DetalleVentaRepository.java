package com.example.sistema_ventas_basico.repository;

import com.example.sistema_ventas_basico.model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta,Long> {
}
