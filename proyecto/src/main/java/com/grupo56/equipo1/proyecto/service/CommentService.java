package com.grupo56.equipo1.proyecto.service;

import java.util.List;
import com.grupo56.equipo1.proyecto.model.Comment;

public interface CommentService {

    public List<Comment> listarComments();

    public Comment guardarComment(Comment comment);
    
}
