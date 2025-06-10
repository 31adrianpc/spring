package com.apc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.apc.entity.UsuarioEntity;
import com.apc.service.UsuarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


@Controller
@SessionAttributes("usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/")
    public String login(){
        return "login";
    }

    @RequestMapping("paginaPrincipal")
    public String paginaPrincipal(){
        return "paginaPrincipal";
    }

    @RequestMapping("actionLogin")
    public ModelAndView actionLogin(UsuarioEntity usuario){
        ModelAndView modelAndView = new ModelAndView();
        UsuarioEntity usuarioValidado = usuarioService.validarUsuario(usuario.getUser(), usuario.getPassword());
        if(usuarioValidado!=null){
            modelAndView.addObject("usuario", usuarioValidado);
            modelAndView.setViewName("paginaPrincipal");
        }else{
            modelAndView.addObject("mensajeError", "Usuario o contraseña incorrectos");
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }
}
