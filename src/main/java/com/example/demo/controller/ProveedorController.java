package com.example.demo.controller;

import com.example.demo.dao.entity.ProveedorEntity;
import com.example.demo.service.ProveedorService;
import java.util.ArrayList;
import javax.validation.Valid;
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
public class ProveedorController {

    @Autowired
    private ProveedorService ProveedorService;

    @RequestMapping("proveedor")
    public ModelAndView formProveedor(Authentication auth) {
        ModelAndView mv = new ModelAndView("proveedor");

        Pageable page = null;
        page = PageRequest.of(0, 7);
        String nombre = auth.getName();
        ArrayList<Integer> lista = new ArrayList<>();

        for (int i = 1; i < (ProveedorService.getLista().size() / 7) + 2; i++) {
            lista.add(i);
        }

        mv.addObject("prov", new ProveedorEntity());
        mv.addObject("user", nombre);
        mv.addObject("couProv", lista);
        mv.addObject("lisProv", ProveedorService.getLista(page));
        return mv;
    }

    @RequestMapping("proveedorInsertar")
    public ModelAndView insProveedor(@Valid @ModelAttribute("prov") ProveedorEntity prove, BindingResult rp, Authentication auth) {
        ModelAndView mv = new ModelAndView();
        if (rp.hasErrors()) {
            mv = new ModelAndView("proveedor");

            Pageable page = null;
            page = PageRequest.of(0, 7);
            String nombre = auth.getName();
            ArrayList<Integer> lista = new ArrayList<>();

            for (int i = 1; i < (ProveedorService.getLista().size() / 7) + 2; i++) {
                lista.add(i);
            }

            mv.addObject("user", nombre);
            mv.addObject("couProv", lista);
            mv.addObject("prov", prove);
            mv.addObject("lisProv", ProveedorService.getLista(page));

        } else {
            mv = new ModelAndView("proveedorConfirma");
            prove.setEstado("A");
            ProveedorService.insertar(prove);
            mv.addObject("prov", prove);
        }
        return mv;
    }

    @RequestMapping("/proveedorSgtPag")
    public ModelAndView sgtPagProveedor(@RequestParam("pag") int pag, Authentication auth) {
        Pageable page = null;
        page = PageRequest.of(pag - 1, 7);
        ArrayList<Integer> lista = new ArrayList<>();
        String nombre = auth.getName();

        for (int i = 1; i < (ProveedorService.getLista().size() / 7) + 2; i++) {
            lista.add(i);
        }

        ModelAndView mv = new ModelAndView("proveedor", "prov", new ProveedorEntity());
        mv.addObject("prov", new ProveedorEntity());
        mv.addObject("user", nombre);
        mv.addObject("couProv", lista);
        mv.addObject("lisProv", ProveedorService.getLista(page));
        return mv;
    }
}
