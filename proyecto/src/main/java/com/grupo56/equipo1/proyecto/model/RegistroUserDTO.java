package com.grupo56.equipo1.proyecto.model;

public class RegistroUserDTO {
   
    private Long id;
    private String nombre;
    private String apellido;
    private String username;
    private String email;
    private String clave;

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }

    
    public RegistroUserDTO(Long id, String nombre, String apellido, String username, String email, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.email = email;
        this.clave = clave;
    }

    public RegistroUserDTO(String nombre, String apellido, String username, String email, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.email = email;
        this.clave = clave;
    }

    public RegistroUserDTO(String email) {
        this.email = email;
    }

    public RegistroUserDTO() {
    }

}
