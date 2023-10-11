/*
package com.example.demo.controller;

import com.example.demo.dao.entity.OrdenCompraDetEntity;
import com.example.demo.dao.entity.OrdenCompraEntity;
import com.example.demo.service.OrdenCompraDetService;
import com.example.demo.service.OrdenCompraService;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
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
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class OrdenCompraController {

    @Autowired
    private OrdenCompraService ordenCompraService;

    @Autowired
    private OrdenCompraDetService ordenCompraDetService;

    @RequestMapping("ordenPago")
    public ModelAndView formOrdenPago(Authentication auth) {
        String nameUser = auth.getName();
        Pageable page = null;
        page = PageRequest.of(0, 7);
        ArrayList<Integer> countOrd = new ArrayList<>();
        for (int i = 1; i < (ordenCompraService.getLista().size() / 7) + 2; i++) {
            countOrd.add(i);
        }

        ModelAndView mv = new ModelAndView("ordenPago", "ord", new OrdenCompraEntity());
        mv.addObject("lisOrd", ordenCompraService.getLista(page));
        mv.addObject("couOrd", countOrd);
        mv.addObject("user", nameUser);
        return mv;
    }

    @RequestMapping("ordenCompraInsertar")
    @Transactional
    public ModelAndView insCategoria(@Valid @ModelAttribute("ord") OrdenCompraEntity orden, HttpServletRequest hsr, BindingResult rp, Authentication auth) {
        ModelAndView mv = new ModelAndView();

        OrdenCompraDetEntity det1 = new OrdenCompraDetEntity();
        OrdenCompraDetEntity det2 = new OrdenCompraDetEntity();

        det1.setId(orden.getId());
        det1.setArticulo(Integer.valueOf(hsr.getParameter("articulo1")));
        det1.setCategoria(Integer.valueOf(hsr.getParameter("categoria1")));

        det2.setId(orden.getId());
        det2.setArticulo(Integer.valueOf(hsr.getParameter("articulo2")));
        det2.setCategoria(Integer.valueOf(hsr.getParameter("categoria2")));

        ordenCompraService.insertar(orden);
        ordenCompraDetService.insertar(det1);
        ordenCompraDetService.insertar(det2);

        return mv;
    }
}
*/
