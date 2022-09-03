package com.grupo56.equipo1.proyecto.service;

import com.grupo56.equipo1.proyecto.serviceInterfaces.IPublicacionService;
import com.grupo56.equipo1.proyecto.interfaces.IPublicacion;
import com.grupo56.equipo1.proyecto.model.Publicacion;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PublicacionService implements IPublicacionService {

    @Autowired
    private IPublicacion data;

    @Override
    public List<Publicacion> listar(){
        return (List<Publicacion>)data.findAll();
    }

    @Override
    public Optional<Publicacion> listarId(int id){
        return null;
    }

    @Override
    public int save(Publicacion p){
        return 0;
    }

    @Override
    public void delete(int id){

    }
}
