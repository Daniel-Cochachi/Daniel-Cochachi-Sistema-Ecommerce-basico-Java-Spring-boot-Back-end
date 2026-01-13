package com.example.sistema_ventas_basico.repository;

import com.example.sistema_ventas_basico.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta,Long> {
}
