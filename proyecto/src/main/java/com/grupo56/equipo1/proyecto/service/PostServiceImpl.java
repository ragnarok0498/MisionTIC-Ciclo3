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
    
        return postRepository.findByEstadoEqualsOrderByIdDesc("1");


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

    @Override
    public Post obtenerPostId(Long id) {

        return postRepository.findById(id).get();
    }

    @Override
    public Post actualizarPost(Post post) {

        return postRepository.save(post);
    }

    @Override
    public void eliminaPost(Long id) {

        postRepository.deleteById(id);
    }


    @Override
    public Post actualizarEstadoPost(Post post) {

        return postRepository.save(post);
    }

    @Override
    public Post actualizarIEstadoPost(Post post) {

        return postRepository.save(post);
    }

    
    
}
