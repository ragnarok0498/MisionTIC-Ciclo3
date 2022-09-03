package com.grupo56.equipo1.proyecto.interfaces;

import com.grupo56.equipo1.proyecto.model.Comentario;
import org.springframework.data.repository.CrudRepository;

public interface IComentario extends CrudRepository<Comentario, Integer> {

}
