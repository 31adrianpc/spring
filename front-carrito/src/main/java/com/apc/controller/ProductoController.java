package com.apc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.apc.service.ProductoService;

@Controller
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("listaProductos", productoService.listarProductos());
        return mv;
    }
}
