package com.grupo56.equipo1.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.grupo56.equipo1.proyecto.model.Post;
import com.grupo56.equipo1.proyecto.service.PostService;

@Controller
public class PostController {

    
    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public String listarPosts(Model modelo){
        modelo.addAttribute("posts", postService.listarPosts());
        return "forms/control_entradas";
    }

    @GetMapping("/posts/newpost")
    public String crearPost(Model modelo){

        Post post = new Post();
        modelo.addAttribute("post", post);
        return "forms/publicar_entrada";
    }


    @PostMapping("/posts/newpost")
    public String guardarPost(@ModelAttribute("post") Post post){
        postService.guardarPost(post);
        return "redirect:/posts/newpost";
    } 
    
}

