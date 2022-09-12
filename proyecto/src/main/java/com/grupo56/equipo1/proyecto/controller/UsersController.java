/*package com.grupo56.equipo1.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupo56.equipo1.proyecto.model.Usuario;
import com.grupo56.equipo1.proyecto.service.UsuariosService;
//@SpringBootApplication

@Controller
@RequestMapping("/newuser")
public class UsersController {

    @Autowired
    @Qualifier("usuariosservice")
    private UsuariosService usuariosService;

    @GetMapping("/newuser")
    public String NewUser(Model model){

        model.addAttribute("usuarios", new Usuario());
        return "newuser";
    }

    //Se agrega usuarios s
    @PostMapping("/adduser")
    public String addUser(@ModelAttribute(name="usuarios") Usuario usuario){

        usuariosService.addUsuario(usuario);
        return "login";
    }
    
}
*/
