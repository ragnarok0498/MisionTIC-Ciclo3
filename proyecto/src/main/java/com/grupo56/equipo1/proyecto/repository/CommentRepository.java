package com.grupo56.equipo1.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo56.equipo1.proyecto.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
    
}
