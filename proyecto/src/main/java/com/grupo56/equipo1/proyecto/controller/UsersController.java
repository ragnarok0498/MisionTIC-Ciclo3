package com.grupo56.equipo1.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.grupo56.equipo1.proyecto.model.RegistroUserDTO;
import com.grupo56.equipo1.proyecto.service.UsuariosService;
//@SpringBootApplication

@Controller
public class UsersController {

    @Autowired
    private UsuariosService usuariosService;

    @ModelAttribute("usuario")
    public RegistroUserDTO retornarNuevoUsuarioRegistroUserDTO(){
        return new RegistroUserDTO();
    }

    @GetMapping("/newuser")
    public String mostrarFormulario(){
        return "forms/registro_usuario";
    }

    @PostMapping("/newuser")
    public String registrarUsuario(@ModelAttribute("usuario") RegistroUserDTO registroDTO){
        usuariosService.guardarUser(registroDTO);
        return "redirect:/newuser?exito";
    }
    
}
/*package
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
 */
