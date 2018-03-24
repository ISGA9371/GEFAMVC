package com.mx.bbva.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public String home() {

        return "indexGefa";

    }

    @RequestMapping(value = "/buscar", method = RequestMethod.GET)
    public String datosPendientes(Model model, @RequestParam("nomVentana") String nomVentana, @RequestParam("seleccion") String seleccion) {

        if (seleccion.equals("F")) {

            return "fabrica/" + nomVentana;

        } else {

            return "presupuestos/" + nomVentana;
        }

    }

}
