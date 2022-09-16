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

    @Override
    public List<Comment> listarComments(){
        return commentRepository.findAll();
    }

    @Override
    public Comment guardarComment(Comment comment){
        return commentRepository.save(comment);
    }
}
