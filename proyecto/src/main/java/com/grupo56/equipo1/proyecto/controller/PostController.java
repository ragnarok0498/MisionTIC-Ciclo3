package com.grupo56.equipo1.proyecto.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.grupo56.equipo1.proyecto.model.Post;
import com.grupo56.equipo1.proyecto.service.PostService;

@Controller
public class PostController {

    
    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public String listarPosts(Model modelo){
        modelo.addAttribute("posts", postService.listarPosts());
        modelo.addAttribute("postsi", postService.listarPostsInactive());
        return "forms/control_entradas";
    }



    @GetMapping("/posts/newpost")
    public String crearPost(Model modelo){

        Post post = new Post();
        modelo.addAttribute("post", post);
        return "forms/publicar_entrada";
    }


    //Creamos nuevo post
    @PostMapping("/posts/newpost")
    public String guardarPost(@RequestParam(name = "foto", required = false) MultipartFile foto, @ModelAttribute("post") Post post, RedirectAttributes flash){
       
        if(!foto.isEmpty()){
            String ruta = "D:/Programacion/Proyecto_Ciclo_3/MisionTIC-UTP-Grupo-56/proyecto/src/main/resources/imagenes/";

            try {
                Path rutaAbsoluta = Paths.get(ruta +"//"+ foto.getOriginalFilename());
                Files.write(rutaAbsoluta, foto.getBytes());
                post.setImagen(foto.getOriginalFilename());
               

            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        postService.guardarPost(post);
        flash.addFlashAttribute("success", "Publicación guardada con exito");
        return "redirect:/posts/newpost";
    } 
    
}

