package com.grupo56.equipo1.proyecto.service;


import com.grupo56.equipo1.proyecto.model.RegistroUserDTO;
import com.grupo56.equipo1.proyecto.model.Usuario;

public interface UsuariosService  {

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