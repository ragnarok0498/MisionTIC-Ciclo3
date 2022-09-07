package com.grupo56.equipo1.proyecto.controller;

import com.grupo56.equipo1.proyecto.model.Publicacion;
import com.grupo56.equipo1.proyecto.serviceInterfaces.IPublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class Controlador {

    @Autowired //interface de publicacionService
    private IPublicacionService service;

    //Metodo que tenga parametro model, que tenga un retorno en este caso index.html
   @GetMapping("/listar")
    public String listar(Model model){
        List<Publicacion>publicacion = service.listar(); //este metodo tiene un valor de retorno de tipo lista
        model.addAttribute("publicacion", publicacion); //enviar toda la lista o el objeto al formulario
        return "panel";
    }
}
