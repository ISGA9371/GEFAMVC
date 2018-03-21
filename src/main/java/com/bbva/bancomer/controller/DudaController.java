package com.bbva.bancomer.controller;

import com.bbva.bancomer.business.model.Requerimiento;
import com.bbva.bancomer.business.model.Level;
import com.bbva.bancomer.business.service.RequerimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Controller
@RequestMapping("/duda")
public class DudaController {

    private static final String ALTA_DUDA_VISTA = "fabrica/AltaDeDuda";
    private static final String BUSQUEDA_DUDA_VISTA = "fabrica/BusquedaDeDudas";

    private RequerimientoService requerimientoService;

    private static final Logger log = Logger.getLogger(DudaController.class.getName());


    @GetMapping("/altaDuda")
    public ModelAndView altaDudaIni() {

        ModelAndView modelReq = new ModelAndView(ALTA_DUDA_VISTA);
        modelReq.addObject("level", new Level());

        return modelReq;
    }

    @PostMapping("/guardaDuda")
    public String guardaRequerimiento(@ModelAttribute("requerimiento") Requerimiento requerimiento) {
        requerimientoService.agregaRequerimiento(requerimiento);
        System.out.print("LLega");
        return "redirect:/requerimiento/ModificaRequerimiento";

    }

    @GetMapping("/{id}")
    public String buscaRequerimiento(Model model, @PathVariable Integer id) {

        log.info("ID " + id);

        Requerimiento requerimiento = requerimientoService.buscaRequerimiento(id);

        model.addAttribute("req", requerimiento);

        return BUSQUEDA_DUDA_VISTA;
    }

    @Autowired
    public void setRequerimientoService(RequerimientoService requerimientoService) {
        this.requerimientoService = requerimientoService;
    }




}
