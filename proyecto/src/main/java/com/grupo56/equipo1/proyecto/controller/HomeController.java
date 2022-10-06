package com.grupo56.equipo1.proyecto.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {

    @RequestMapping(path = "/", produces = MediaType.TEXT_HTML_VALUE)
	public String welcomepage() {
		return "index";
	}
    
}
