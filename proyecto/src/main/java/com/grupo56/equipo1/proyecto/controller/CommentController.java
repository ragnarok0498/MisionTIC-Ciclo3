package com.grupo56.equipo1.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.grupo56.equipo1.proyecto.model.Comment;
import com.grupo56.equipo1.proyecto.service.CommentService;

@Controller
public class CommentController{
   
    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public String listarComments(Model modelo){
        modelo.addAttribute("comment", commentService.listarComments());
        return "forms/control_comentarios";
    }

    @GetMapping("/comments/newcomment")
    public String crearComment(Model modelo){

        Comment comment = new Comment();
        modelo.addAttribute("comment", comment);
        return "forms/control_comentarios";
    }

    @PostMapping("/comments")
    public String guardarComment(@ModelAttribute("comment") Comment comment){
        commentService.guardarComment(comment);
        return "redirect:/comments";
    }


}