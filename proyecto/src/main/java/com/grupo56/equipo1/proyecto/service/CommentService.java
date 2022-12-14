package com.grupo56.equipo1.proyecto.service;

import java.util.List;
import com.grupo56.equipo1.proyecto.model.Comment;

public interface CommentService {
    //Metodo para listar los comentarios
    public List<Comment> listarAllComments();

    //Metodo para crear comentarios
    public Comment guardarComment(Comment comment);

    //Metodo para listar comentarios inactivos
    public List<Comment> listarCommentInactive();

    public void eliminarComment(Long id);

    public Comment obtenerCommentId(Long id);

    public Comment actualizarEstadoComment(Comment comment);

    public Comment actualizarIEstadoComment(Comment comment);
}
