package com.apc.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/perfil")
    public ModelAndView perfil(@AuthenticationPrincipal OAuth2User user) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("perfil");
        mv.addObject("nombre", user.getAttribute("name"));
        mv.addObject("email", user.getAttribute("email"));
        mv.addObject("foto", user.getAttribute("picture"));
        return mv;
    }
}
