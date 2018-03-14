package com.bbva.bancomer.controller;


import com.bbva.bancomer.business.model.Requerimiento;
import com.bbva.bancomer.business.service.RequerimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.runtime.Log;

import java.util.logging.Logger;

@Controller
@RequestMapping("/requerimiento")
public class RequerimientoController {

    private static final String REQUERIMIENTO_VISTA = "fabrica/AltaDeRequerimiento";
    private static final String MODIFICA_REQ_VISTA = "fabrica/ModificarRequerimiento";

    private RequerimientoService requerimientoService;

    private static final Logger log = Logger.getLogger(RequerimientoController.class.getName());


    @GetMapping("/inicialRequerimiento")
    public ModelAndView entraRequerimiento(){

        ModelAndView modelReq = new ModelAndView(REQUERIMIENTO_VISTA);
        modelReq.addObject("requerimiento", new Requerimiento());

        return modelReq;
    }

    @PostMapping("/guardaReq")
    public String guardaRequerimiento(@ModelAttribute("requerimiento") Requerimiento requerimiento){
        requerimientoService.agregaRequerimiento(requerimiento);
        System.out.print("LLega");
        return "redirect:/requerimiento/ModificaRequerimiento";

    }

    @GetMapping("/{id}")
    public String buscaRequerimiento(Model model, @PathVariable Integer id ){

        log.info("ID "+id);

        Requerimiento requerimiento = requerimientoService.buscaRequerimiento(id);

        model.addAttribute("req",requerimiento);

        return MODIFICA_REQ_VISTA;
    }

    @Autowired
    public void setRequerimientoService(RequerimientoService requerimientoService){
        this.requerimientoService = requerimientoService;
    }

}
