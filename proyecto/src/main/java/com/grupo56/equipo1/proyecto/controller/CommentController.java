package com.grupo56.equipo1.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.grupo56.equipo1.proyecto.model.Comment;
import com.grupo56.equipo1.proyecto.service.CommentService;

@Controller
public class CommentController{
   
    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public String listarComments(Model modelo){
        modelo.addAttribute("comments", commentService.listarAllComments());
        modelo.addAttribute("commentsi",commentService.listarCommentInactive());

        return "forms/control_comentarios";
    }

    @GetMapping("/comments/newcomment")
    public String crearComment(Model modelo){

        Comment comment = new Comment();
        modelo.addAttribute("comment", comment);
        return "forms/entrada";
    }

    @PostMapping("/comments/newcomment")
    public String guardarComment(@ModelAttribute("comment") Comment comment){
        commentService.guardarComment(comment);
        return "redirect:/comments//newcomment";
    }
//Eliminamos comment
    
    @GetMapping("/comments/{id}")
    public String eliminarComment(@PathVariable Long id ){
        commentService.eliminarComment(id);

        return "redirect:/comments";
}
    /*@GetMapping("/")
    public String listarCommentsIndex(Model modelo){
        modelo.addAttribute("comments", commentService.listarAllComments());
        return "index"; 

    
    }*/
    /* 
    @GetMapping("/entrada/{id}")
    public String listarCommentsEntrada(@PathVariable Long id, Model model){
        model.addAttribute("comment", commentService.obtenerCommentId(id));
        return "forms/entrada";
    }
    */

    //Activamos comentario
    @GetMapping("/comments/active/{id}")
    public String actualizarEstadoComment(@PathVariable Long id, @ModelAttribute("comment")Comment comment, Model model){
    
        Comment commentExiste = (Comment) commentService.obtenerCommentId(id);
        commentExiste.setEstado("1");

        commentService.actualizarEstadoComment(commentExiste);
        return "redirect:/comments";
    }

}