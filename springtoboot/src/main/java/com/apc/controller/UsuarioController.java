/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apc.controller;

import com.apc.entity.UsuarioEntity;
import com.apc.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/")
    public String mostrarLogin() {
        return "login";
    }

    @RequestMapping("mantenimientoUsuarios")
    public ModelAndView mantenimientoUsuarios() {
        return new ModelAndView("mantenimientoUsuarios", "listaUsuarios", this.usuarioService.listarUsuarios());
    }

    @RequestMapping("nuevoUsuario")
    public ModelAndView agregarUsuario() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("frmUsuario");
        mv.addObject("nuevoUsuario", new UsuarioEntity());
        mv.addObject("accion", "INSERTAR");
        return mv;
    }

    @RequestMapping("actualizarUsuario")
    public ModelAndView actualizarUsuario(Integer idUsuario) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("frmUsuario");
        mv.addObject("nuevoUsuario", this.usuarioService.obtenerUsuarioPorId(idUsuario));
        mv.addObject("accion", "ACTUALIZAR");
        return mv;
    }

    //utilizado para el insertar y actualizar
    @RequestMapping("guardarUsuario")
    public ModelAndView guardarUsuario( @RequestParam("archivo") MultipartFile archivo, @Valid @ModelAttribute("nuevoUsuario") UsuarioEntity usuario,
            BindingResult result, String accion) {
        ModelAndView mv = new ModelAndView();
        try {
            if (result.hasErrors()) {
                mv.setViewName("frmUsuario");
                mv.addObject("accion", accion);
                mv.addObject("usuario", usuario);
                mv.addObject("msgError", "Error al guardar el usuario");
            } else {
                if(!archivo.isEmpty()){
                    usuario.setFoto(archivo.getBytes());
                }
                if (usuario.getIdUsuario() == null) //insertando
                {
                    this.usuarioService.insertarUsuario(usuario);
                } else {
                    this.usuarioService.actualizarUsuario(usuario);
                }
                mv.setViewName("redirect:mantenimientoUsuarios?mensaje=Usuario guardado con éxito");
            }
        } catch (Exception e) {
            mv.setViewName("frmUsuario");
            mv.addObject("usuario", usuario);
            mv.addObject("msgError", "Error al guardar el usuario");
            mv.addObject("accion", accion);
        }
        return mv;
    }

    @RequestMapping("eliminarUsuario")
    public ModelAndView eliminarUsuario(Integer idUsuario) {
        ModelAndView mv = new ModelAndView();
        try {
            this.usuarioService.eliminarUsuario(idUsuario);
            mv.setViewName("redirect:mantenimientoUsuarios?mensaje=Usuario eliminado con éxito");
        } catch (Exception e) {
            mv.setViewName("redirect:mantenimientoUsuarios?mensajeError=Error al eliminar el usuario");
        }
        return mv;
    }

    @RequestMapping("actionLogin")
    public ModelAndView actionLogin(UsuarioEntity usuario) {
        usuario = this.usuarioService.validarUsuario(usuario);
        ModelAndView mv = new ModelAndView();
        if (usuario != null) {
            mv.setViewName("paginaPrincipal");
            mv.addObject("usuario", usuario);
        } else {
            mv.setViewName("login");
            mv.addObject("mensajeError", "Usuario y/o contraseña incorrecto");
        }
        return mv;
    }
}
