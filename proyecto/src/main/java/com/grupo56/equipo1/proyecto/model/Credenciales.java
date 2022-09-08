package com.grupo56.equipo1.proyecto.model;

public class Credenciales {
    
    private String email;
    private String password;
    
    
    public Credenciales() {
    }

    public Credenciales(String email, String password) {
        this.email = email;
        this.password = password;
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
