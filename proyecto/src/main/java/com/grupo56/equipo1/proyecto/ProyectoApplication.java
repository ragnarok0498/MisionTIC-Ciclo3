package com.grupo56.equipo1.proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.grupo56.equipo1.proyecto.repository")

public class ProyectoApplication{

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
		
	}
}
