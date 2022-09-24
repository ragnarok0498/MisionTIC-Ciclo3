package com.grupo56.equipo1.proyecto;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ImagenConfiguration implements WebMvcConfigurer{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        WebMvcConfigurer.super.addResourceHandlers(registry);

        registry.addResourceHandler("/imagenes/**").addResourceLocations("file:/D:/Programacion/Proyecto_Ciclo_3/MisionTIC-UTP-Grupo-56/proyecto/src/main/resources/imagenes");
    }
}
