package com.example.demo.controller;

import com.example.demo.dao.entity.ArticuloEntity;
import com.example.demo.service.ArticuloService;
import com.example.demo.service.CategoriaService;
import java.util.ArrayList;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping("/articulo")
    public ModelAndView sisArticulo(Authentication auth) {
        Pageable page = null;
        page = PageRequest.of(0, 7);
        ArrayList<Integer> countArt = new ArrayList<>();

        for (int i = 1; i < (articuloService.obtenerLista().size() / 7) + 2; i++) {
            countArt.add(i);
        }

        ModelAndView mv = new ModelAndView("articulo", "art", new ArticuloEntity());
        mv.addObject("lisArt", articuloService.obtenerLista(page));
        mv.addObject("lisCat", categoriaService.obtenerListaOrdenNombre());
        mv.addObject("couArt", countArt);
        String nameUser = auth.getName();
        mv.addObject("user", nameUser);
        return mv;
    }

    @RequestMapping("/articuloInsertar")
    public ModelAndView insArticulo(@Valid @ModelAttribute("art") ArticuloEntity arti, BindingResult br, Authentication auth) {
        ModelAndView mv = new ModelAndView();
        if (br.hasErrors()) {
            Pageable page = null;
            page = PageRequest.of(0, 7);
            ArrayList<Integer> countArt = new ArrayList<>();
            String nameUser = auth.getName();

            for (int i = 1; i < (articuloService.obtenerLista().size() / 7) + 2; i++) {
                countArt.add(i);
            }

            mv = new ModelAndView("articulo");
            mv.addObject("art", new ArticuloEntity());
            mv.addObject("lisArt", articuloService.obtenerLista(page));
            mv.addObject("lisCat", categoriaService.obtenerListaOrdenNombre());
            mv.addObject("couArt", countArt);
            mv.addObject("art", arti);
            mv.addObject("user", nameUser);
            return mv;

        } else {
            mv = new ModelAndView("articuloConfirma");
            articuloService.insertar(arti);
            log.info("se inserto el articulo" + arti.getNombre());
            mv.addObject("art", arti);
        }
        return mv;
    }

    @RequestMapping("/articuloSgtPag")
    public ModelAndView sgtPagArticulo(@RequestParam("pag") int pag, Authentication auth) {
        Pageable page = null;
        page = PageRequest.of(pag - 1, 7);
        ArrayList<Integer> countArt = new ArrayList<>();

        for (int i = 1; i < (articuloService.obtenerLista().size() / 7) + 2; i++) {
            countArt.add(i);
        }

        ModelAndView mv = new ModelAndView("articulo", "art", new ArticuloEntity());
        mv.addObject("lisArt", articuloService.obtenerLista(page));
        mv.addObject("lisCat", categoriaService.obtenerListaOrdenNombre());
        mv.addObject("couArt", countArt);
        String nameUser = auth.getName();
        mv.addObject("user", nameUser);
        return mv;
    }

}
