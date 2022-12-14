package com.grupo56.equipo1.proyecto.model;
import javax.persistence.Entity;

//import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Table(name = "publicaciones")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "titulo")
    private String titulo;

    @Column(name = "resumen")
    private String resumen;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private String estado = "0";

    @Column(name = "id_admin", nullable = true)
    private String idAdmin;

    @Column(name= "categoria", nullable = true)
    private String categoria;

    @Column(name = "imagen")
    private String imagen;

    public Post() {
    }

    public Post(String titulo, String resumen, String descripcion, String estado, String idAdmin, String categoria,
            String imagen) {
        this.titulo = titulo;
        this.resumen = resumen;
        this.descripcion = descripcion;
        this.estado = estado;
        this.idAdmin = idAdmin;
        this.categoria = categoria;
        this.imagen = imagen;
    }

    public Post(long id, String titulo, String resumen, String descripcion, String estado, String idAdmin,
            String categoria, String imagen) {
        this.id = id;
        this.titulo = titulo;
        this.resumen = resumen;
        this.descripcion = descripcion;
        this.estado = estado;
        this.idAdmin = idAdmin;
        this.categoria = categoria;
        this.imagen = imagen;
    }

    public long getId_publicacion() {
        return id;
    }

    public void setId_publicacion(long id) {
        this.id = id;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
 

}