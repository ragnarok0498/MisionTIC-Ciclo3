package com.grupo56.equipo1.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo56.equipo1.proyecto.model.RegistroUserDTO;
import com.grupo56.equipo1.proyecto.model.Usuario;
import com.grupo56.equipo1.proyecto.repository.UserRepository;

@Service
public class UsuarioServiceImpl implements UsuariosService {

     @Autowired
     private UserRepository userRepository;

    @Override
    public Usuario guardarUser(RegistroUserDTO registroDTO){
        Usuario usuario = new Usuario(registroDTO.getNombre(), registroDTO.getApellido(), 
        registroDTO.getUsername(),registroDTO.getCorreo(), registroDTO.getClave());

        return userRepository.save(usuario);
    }
    
}
