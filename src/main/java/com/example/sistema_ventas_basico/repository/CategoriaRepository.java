package com.example.sistema_ventas_basico.repository;

import com.example.sistema_ventas_basico.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria , Long> {
}
