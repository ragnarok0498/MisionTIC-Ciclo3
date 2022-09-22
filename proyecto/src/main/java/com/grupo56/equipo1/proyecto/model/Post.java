package com.grupo56.equipo1.proyecto.model;
import javax.persistence.Entity;

//import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Table(name = "publicaciones")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_publicacion;


    @Column(name = "titulo")
    private String titulo;

    @Column(name = "resumen")
    private String resumen;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado", nullable = true)
    private String estado;

    @Column(name = "id_admin")
    private String idAdmin;

    
    public Post(String titulo, String resumen, String descripcion, String estado, String idAdmin) {
        this.titulo = titulo;
        this.resumen = resumen;
        this.descripcion = descripcion;
        this.estado = estado;
        this.idAdmin = idAdmin;
    }

    public Post() {
    }

    public Post(long id_publicacion, String titulo, String resumen, String descripcion, String estado,
            String idAdmin) {
        this.id_publicacion = id_publicacion;
        this.titulo = titulo;
        this.resumen = resumen;
        this.descripcion = descripcion;
        this.estado = estado;
        this.idAdmin = idAdmin;
    }

    public long getId_publicacion() {
        return id_publicacion;
    }

    public void setId_publicacion(long id_publicacion) {
        this.id_publicacion = id_publicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }


}