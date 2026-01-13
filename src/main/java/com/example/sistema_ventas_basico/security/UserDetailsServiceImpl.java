package com.example.sistema_ventas_basico.security;

import com.example.sistema_ventas_basico.model.Usuario;
import com.example.sistema_ventas_basico.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Implementación de UserDetailsService exigida por Spring Security.
 * Sirve para cargar los detalles del usuario desde la base de datos durante la
 * autenticación.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscamos el usuario en nuestra base de datos
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con username: " + username));

        // Mapeamos el rol de la base de datos a una autoridad de Spring Security
        // Es importante que el rol empiece con "ROLE_" si usamos hasRole()
        List<SimpleGrantedAuthority> authorities = Collections
                .singletonList(new SimpleGrantedAuthority(usuario.getRol()));

        // Retornamos un objeto User con sus respectivos permisos (authorities)
        return new User(usuario.getUsername(), usuario.getPassword(), authorities);
    }
}
