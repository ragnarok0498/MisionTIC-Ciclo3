package com.grupo56.equipo1.proyecto.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grupo56.equipo1.proyecto.model.Comment;
import com.grupo56.equipo1.proyecto.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    //Listamos todos los comentarios
    @Override
    public List<Comment> listarAllComments(){
        return commentRepository.findByEstadoEqualsOrderByIdDesc("1");
    }
    //Listamos todos los comentario Inactivos
    @Override
    public List<Comment>listarCommentInactive() {
        
        return commentRepository.findByEstadoLessThanEqualOrderByIdDesc("0");
    }
    
    @Override
    public Comment guardarComment(Comment comment){
        return commentRepository.save(comment);
    }

        
    @Override
    public Object obtenerCommentId(Long id) {
        
        return commentRepository.findById(id).get();
    }
    @Override
    public void eliminarComment(Long id) {
        commentRepository.deleteById(id);
        
    }
    @Override
    public Comment actualizarEstadoComment(Comment comment) {
        return commentRepository.save(comment);
        
    }
}
