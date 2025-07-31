package com.apc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.apc.service.UsuarioService;

@Controller
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("paginaPrincipal");
        return mv;
    }

    @RequestMapping("/paginaPrincipal")
    public ModelAndView paginaPrincipal() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("paginaPrincipal");
        return mv;
    }

    @RequestMapping("/admin/mantenimientoUsuarios")
    public ModelAndView mantenimientoUsuarios() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("listaUsuarios", usuarioService.listarUsuarios());
        mv.setViewName("/admin/mantenimientoUsuarios");
        return mv;
    }
}
