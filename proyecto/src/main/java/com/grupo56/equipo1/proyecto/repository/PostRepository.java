package com.grupo56.equipo1.proyecto.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo56.equipo1.proyecto.model.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

    public List<Post> findByEstadoLessThanEqualOrderByIdDesc(String estado);

    public List<Post> findByEstadoEqualsOrderByIdDesc(String estado);

}
