package com.grupo56.equipo1.proyecto.model;

import javax.persistence.*;

@Entity
@Table(name = "publicacion")
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo; //fdfd
    private String resumen;
    private String detalles;
    private String filtro; // fisica quimica  mecanica
    private int estado; // 1 = activo → 0 = inactivo

    public Publicacion (){

    }

    public Publicacion(int id, String titulo, String resumen, String detalles, String filtro, int estado) {
        this.id = id;
        this.titulo = titulo;
        this.resumen = resumen;
        this.detalles = detalles;
        this.filtro = filtro;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
