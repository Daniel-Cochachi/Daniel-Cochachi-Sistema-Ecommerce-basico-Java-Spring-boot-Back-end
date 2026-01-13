package com.example.sistema_ventas_basico.repository;

import com.example.sistema_ventas_basico.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * Repositorio para la entidad Usuario.
 * Nos permite buscar usuarios en la base de datos por su nombre de usuario.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Método para encontrar un usuario por su nombre (necesario para el login)
    Optional<Usuario> findByUsername(String username);
}
