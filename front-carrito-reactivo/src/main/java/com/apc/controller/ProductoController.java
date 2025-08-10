package com.apc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.apc.service.CategoriaService;
import com.apc.service.ProductoService;

@Controller
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("listaProductos", productoService.listarProductos().collectList().block());
        mv.addObject("listaCategorias", categoriaService.listarCategorias().collectList().block());
        return mv;
    }
}
