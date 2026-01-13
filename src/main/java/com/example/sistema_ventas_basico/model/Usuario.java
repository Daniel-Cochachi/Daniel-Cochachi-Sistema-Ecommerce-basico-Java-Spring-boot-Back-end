package com.example.sistema_ventas_basico.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad Usuario para manejar la autenticación en el sistema.
 * JWT requiere una entidad que represente al usuario para validar credenciales.
 */
@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // El nombre de usuario que se usará para el login
    @Column(unique = true, nullable = false)
    private String username;

    // La contraseña que se guardará encriptada (BCrypt)
    @Column(nullable = false)
    private String password;

    // El rol del usuario (ej: ROLE_USER, ROLE_ADMIN)
    private String rol;
}
