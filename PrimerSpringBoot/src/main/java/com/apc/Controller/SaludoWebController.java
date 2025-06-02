package com.apc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.apc.Entity.SaludoEntity;
import com.apc.Service.SaludoService;

@Controller
public class SaludoWebController {
    @Autowired
    private SaludoService saludoService;

    @RequestMapping("principal")
    public ModelAndView saludo(SaludoEntity saludoEntity){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("principal");
        mv.addObject("saludo", saludoService.saludo(saludoEntity));
        return mv;
    }
}
