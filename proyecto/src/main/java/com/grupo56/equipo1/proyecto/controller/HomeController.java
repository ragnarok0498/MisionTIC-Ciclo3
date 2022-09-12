package com.grupo56.equipo1.proyecto.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {

    @RequestMapping("/")
	public String welcomepage() {
		return "index";
	}
    
}
