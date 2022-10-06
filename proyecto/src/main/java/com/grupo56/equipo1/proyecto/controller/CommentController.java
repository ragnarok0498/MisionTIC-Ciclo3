package com.grupo56.equipo1.proyecto.controller;

import com.grupo56.equipo1.proyecto.model.Post;
import com.grupo56.equipo1.proyecto.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.grupo56.equipo1.proyecto.model.Comment;
import com.grupo56.equipo1.proyecto.service.CommentService;

@Controller
public class CommentController{
   
    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @GetMapping("/comments")
    public String listarComments(Model modelo){
        modelo.addAttribute("comments", commentService.listarAllComments());
        modelo.addAttribute("commentsi",commentService.listarCommentInactive());

        return "forms/control_comentarios";
    }

//Eliminamos comment
    
    @GetMapping("/comments/{id}")
    public String eliminarComment(@PathVariable Long id ){
        commentService.eliminarComment(id);

        return "redirect:/comments";
}
    //Activamos comentario
    @GetMapping("/comments/active/{id}")
    public String actualizarEstadoComment(@PathVariable Long id, @ModelAttribute("comment")Comment comment, Model model){
    
        Comment commentExiste = commentService.obtenerCommentId(id);
        commentExiste.setEstado("1");

        commentService.actualizarEstadoComment(commentExiste);
        return "redirect:/comments";
    }

    //Desactivamos comentario
    @GetMapping("/comments/inactive/{id}")
    public String actualizarIEstadoComment(@PathVariable Long id, @ModelAttribute("comment")Comment comment, Model model){

        Comment commentExiste = commentService.obtenerCommentId(id);
        commentExiste.setEstado("0");

        commentService.actualizarEstadoComment(commentExiste);
        return "redirect:/comments";
    }

    @PostMapping("/entrada/{id}/newcomment")
    public String guardarComment(@PathVariable Long id, @ModelAttribute("comment")Comment comment, Model model){

        Post postExiste = postService.obtenerPostId(id);
        model.addAttribute("comment", new Comment());
        commentService.guardarComment(comment);
        return "redirect:/entrada/{id}";
    }
}