package com.apc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.apc.entity.UsuarioEntity;
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
        mv.addObject("usuarioBean", new UsuarioEntity());
        mv.setViewName("/admin/mantenimientoUsuarios");
        return mv;
    }

    @RequestMapping("/admin/eliminarUsuario")
    public ModelAndView eliminarUsuario(Integer idUsuario) {
        ModelAndView mv = new ModelAndView();
        try {
            usuarioService.eliminarUsuario(idUsuario);
            mv.addObject("msgExito", "Usuario eliminado correctamente.");
            mv.addObject("usuarioBean", new UsuarioEntity());
        } catch (Exception e) {
            mv.addObject("msgError", "Error al eliminar el usuario");
        }
        mv.addObject("listaUsuarios", usuarioService.listarUsuarios());
        mv.setViewName("/admin/mantenimientoUsuarios");
        return mv;
    }

    @RequestMapping("/admin/actualizarUsuario")
    public ModelAndView actualizarUsuario(Integer idUsuario) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("listaUsuarios", usuarioService.listarUsuarios());
        mv.addObject("usuarioBean", usuarioService.obtenerUsuario(idUsuario));
        mv.addObject("operacion", "Actualizar");
        mv.setViewName("/admin/mantenimientoUsuarios");
        return mv;
    }

    @RequestMapping("/admin/grabarUsuario")
    public ModelAndView grabarUsuario(@ModelAttribute("usuarioBean") UsuarioEntity usuario) {
        ModelAndView mv = new ModelAndView();
        if(usuario.getIdUsuario() == null) {
            try {
                usuario.setEstado(1);
                usuarioService.registrarUsuario(usuario);
                mv.addObject("msgExito", "Usuario registrado correctamente.");
            } catch (Exception e) {
                mv.addObject("msgError", "Error al registrar el usuario");
            }
        }else {
            try {
                UsuarioEntity usuarioTmp = usuarioService.obtenerUsuario(usuario.getIdUsuario());
                if (usuarioTmp.getFoto() != null) usuario.setFoto(usuarioTmp.getFoto());
                usuarioService.actualizarUsuario(usuario);
                mv.addObject("msgExito", "Usuario actualizado correctamente.");
            } catch (Exception e) {
                mv.addObject("msgError", "Error al actualizar el usuario");
            }
        }
        mv.addObject("usuarioBean", new UsuarioEntity());
        mv.addObject("listaUsuarios", usuarioService.listarUsuarios());
        mv.setViewName("/admin/mantenimientoUsuarios");
        return mv;
    }
}
