package com.grupo56.equipo1.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = userRepository.findByEmail(username);

        if(usuario == null){
            throw new UsernameNotFoundException("Usuario o password invalidados");
        }
        return new User(usuario.getCorreo(), usuario.getClave(), null);
    }

    
}
