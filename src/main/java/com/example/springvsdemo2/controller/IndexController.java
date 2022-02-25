package com.example.springvsdemo2.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.springvsdemo2.model.Usuario;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class IndexController {
    @Value("${texto.indexcontroller.index.titulo}")
    private String textoIndex;

    @Value("${texto.indexcontroller.perfil.titulo}")
    private String textoPerfil;

    @Value("${texto.indexcontroller.listar.titulo}")
    private String textoListar;

    @GetMapping({ "/", "", "index" })
    public String help(Model model) {
        System.out.println("test");
        String[] messages = { "a", "b" };
        model.addAttribute("messages", messages);
        model.addAttribute("titulo", textoIndex);
        return "index";
    }

    @GetMapping("/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Andres");
        usuario.setApellido("Apellido");
        usuario.setEmail("andres@corre.com");

        model.addAttribute("usuario", usuario);
        // model.addAttribute("titulo", "Perfil del usuario: " + usuario.getNombre());
        model.addAttribute("titulo", textoPerfil);

        return "perfil";
    }

    // @GetMapping("/")
    // public ModelAndView help2(ModelAndView mv){
    // mv.addObject("titulo", "Hola Spring con ModelView");
    // mv.setViewName("index");
    // return mv;
    // }

    @GetMapping("/listar")
    public String listar(Model model) {

        model.addAttribute("titulo", textoListar);

        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        usuarios.add(new Usuario("Andres", "Guzman", "anres@correo.com"));
        usuarios.add(new Usuario("John", "Doe", "john@correo.com"));
        usuarios.add(new Usuario("Jane", "Doe", "jane@correo.com"));
        return usuarios;
    }
}
