package com.example.demo.controller;

import com.example.demo.dao.entity.CategoriaEntity;
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
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping("categoria")
    public ModelAndView formCategoria(Authentication auth) {
        String nameUser = auth.getName();
        Pageable page = null;
        page = PageRequest.of(0, 7);
        ArrayList<Integer> countCat = new ArrayList<>();
        for (int i = 1; i < (categoriaService.obtenerLista().size() / 7) + 2; i++) {
            countCat.add(i);
        }

        ModelAndView mv = new ModelAndView("categoria", "cat", new CategoriaEntity());
        mv.addObject("lisCat", categoriaService.obtenerLista(page));
        mv.addObject("couCat", countCat);
        mv.addObject("user", nameUser);
        return mv;
    }

    @RequestMapping("categoriaInsertar")
    public ModelAndView insCategoria(@Valid @ModelAttribute("cat") CategoriaEntity categ, BindingResult rp, Authentication auth) {
        ModelAndView mv = new ModelAndView();
        if (rp.hasErrors()) {
            mv = new ModelAndView("categoria");
            String nameUser = auth.getName();
            ArrayList<Integer> countCat = new ArrayList<>();
            Pageable page = null;
            page = PageRequest.of(0, 7);

            for (int i = 1; i < (categoriaService.obtenerLista().size() / 7) + 2; i++) {
                countCat.add(i);
            }

            mv.addObject("lisCat", categoriaService.obtenerLista(page));
            mv.addObject("cat", categ);
            mv.addObject("user", nameUser);
            mv.addObject("couCat", countCat);
        } else {
            mv = new ModelAndView("categoriaConfirma");
            categoriaService.insertar(categ);
            log.info("se inserto la categoria" + categ.getNombre());
            mv.addObject("cat", categ);
        }
        return mv;
    }

    @RequestMapping("categoriaConfirma")
    public ModelAndView catConfirma() {
        ModelAndView mv = new ModelAndView("categoriaConfirma");
        return mv;
    }

    @RequestMapping("/categoriaSgtPag")
    public ModelAndView sgtPagArticulo(@RequestParam("pag") int pag, Authentication auth) {
        Pageable page = null;
        page = PageRequest.of(pag - 1, 7);
        ArrayList<Integer> countArt = new ArrayList<>();

        for (int i = 1; i < (categoriaService.obtenerLista().size() / 7) + 2; i++) {
            countArt.add(i);
        }

        ModelAndView mv = new ModelAndView("categoria", "cat", new CategoriaEntity());
        mv.addObject("lisCat", categoriaService.obtenerLista(page));
        mv.addObject("couCat", countArt);
        String nameUser = auth.getName();
        mv.addObject("user", nameUser);
        return mv;
    }
}
