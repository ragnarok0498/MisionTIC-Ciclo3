package com.grupo56.equipo1.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.grupo56.equipo1.proyecto.model.Post;
import com.grupo56.equipo1.proyecto.repository.PostRepository;





@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    //Listamos todos los posts
    @Override
    public List<Post> listarPosts() {
    
        return postRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    //Listamos todos los posts
    @Override
    public List<Post> listarPostsInactive() {
    
        return postRepository.findByEstadoLessThanEqualOrderByIdDesc("0");
    }
    





    
    @Override
    public Post guardarPost(Post post) {
        return postRepository.save(post);
    }
    
}
