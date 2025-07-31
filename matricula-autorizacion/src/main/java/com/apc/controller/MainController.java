package com.apc.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    
    @RequestMapping("/login")
    public ModelAndView login(@RequestParam(value = "error", required = false) String error, Principal principal) {
        if(error != null) {
            return new ModelAndView("login", "msgError", "Usuario o contraseña incorrectos");
        }else{
            if(principal != null) {
                return new ModelAndView("redirect:/");
            } else {
                return new ModelAndView("login");
            }
        }
    }
}
