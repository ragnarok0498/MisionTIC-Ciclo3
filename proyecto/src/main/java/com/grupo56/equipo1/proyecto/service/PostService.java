package com.grupo56.equipo1.proyecto.service;

import java.util.List;

import com.grupo56.equipo1.proyecto.model.Post;

public interface PostService {

    //Metodo para listar los posts
    public List<Post> listarPosts();

    //Metodo para crear post
    public Post guardarPost(Post post);
    
}
