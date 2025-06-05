package com.apc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.apc.entity.UsuarioEntity;
import com.apc.service.UsuarioService;


@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    @RequestMapping("/")
    public String login(){
        return "login";
    }

    @RequestMapping("actionLogin")
    public ModelAndView actionLogin(UsuarioEntity usuario) {
        ModelAndView mv = new ModelAndView();

        usuario = usuarioService.validarUsuario(usuario);
        if(usuario==null){
            mv.setViewName("login");
            mv.addObject("mensajeError", "Usuario y/o contraseñas incorrectos");
        }else{
            mv.setViewName("paginaPrincipal");
            mv.addObject("usuario", usuario);
        }
        
        return mv;
    }
    
    
}
