package com.grupo56.equipo1.proyecto.model;

import javax.persistence.*;

@Entity
@Table(name = "administrador")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nombre")
    private String name;

    @Column(name ="apellido")
    private String apellido;

    @Column(name="username")
    private String username;

    @Column(name="correo")
    private String email;

    @Column(name = "password")
    private String password;

    public Usuario(String name, String apellido, String username, String email, String password) {
        this.name = name;
        this.apellido = apellido;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Usuario() {
    }

    public Usuario(int id, String name, String apellido, String username, String email, String password) {
        this.id = id;
        this.name = name;
        this.apellido = apellido;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
}
