package com.apc.cliente_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.apc.cliente_rest.service.CursoService;

@Controller
public class CursoController {
    
    @Autowired
    private CursoService cursoService;

    public ModelAndView listarCursos(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mantenimientoCursos");
        mv.addObject("listaCursos", cursoService.listarCursos());
        return mv;
    }
}
