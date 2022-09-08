package com.grupo56.equipo1.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grupo56.equipo1.proyecto.model.Credenciales;

@Controller
public class LoginController {

   @GetMapping("/")
    public String RedirectLogin(){

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String Login(Model model,
        @RequestParam(name="error", required=false) final String error,
        @RequestParam(name="logout", required=false) final String logout){
            model.addAttribute("error", error);
            model.addAttribute("logout", logout);
            model.addAttribute("credenciales", new Credenciales());
            
        return "login";
    }

    @PostMapping("/check")
    public String Check(@ModelAttribute(name="credenciales") Credenciales credenciales){

        if(credenciales.getEmail().equals("pablogiress@gmail.com") && credenciales.getPassword().equals("234")){
            return "panel";
        }else{
            return "redirect:/login?error";
        }
        
    }
    
}
