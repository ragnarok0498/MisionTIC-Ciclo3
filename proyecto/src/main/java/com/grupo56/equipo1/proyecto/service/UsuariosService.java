package com.grupo56.equipo1.proyecto.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.grupo56.equipo1.proyecto.model.RegistroUserDTO;
import com.grupo56.equipo1.proyecto.model.Usuario;

public interface UsuariosService extends UserDetailsService {

    public Usuario guardarUser(RegistroUserDTO registroDTO);

}

/**
 
@Autowired
    private UserRepository repo;

    public Usuario login(String username, String clave){
        Usuario user = repo.findUsernameAndPassword(username, clave);
        return user;
    }
 */