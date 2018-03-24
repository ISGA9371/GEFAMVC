package com.mx.bbva.controller;

import com.mx.bbva.business.model.Level;
import com.mx.bbva.business.model.Requirement;
import com.mx.bbva.business.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Controller
@RequestMapping("/duda")
public class DoubtController {

    private static final String ALTA_DUDA_VISTA = "fabrica/AltaDeDuda";
    private static final String BUSQUEDA_DUDA_VISTA = "fabrica/BusquedaDeDudas";

    private RequirementService requirementService;

    private static final Logger log = Logger.getLogger(DoubtController.class.getName());


    @GetMapping("/altaDuda")
    public ModelAndView altaDudaIni() {

        ModelAndView modelReq = new ModelAndView(ALTA_DUDA_VISTA);
        modelReq.addObject("level", new Level());

        return modelReq;
    }

    @PostMapping("/guardaDuda")
    public String guardaRequerimiento(@ModelAttribute("requerimiento") Requirement requirement) {
        requirementService.saveRequirement(requirement);
        System.out.print("LLega");
        return "redirect:/requerimiento/ModificaRequerimiento";

    }

    @GetMapping("/{id}")
    public String buscaRequerimiento(Model model, @PathVariable Integer id) {

        log.info("ID " + id);

        Requirement requirement = requirementService.findOneRequirement(id);

        model.addAttribute("req", requirement);

        return BUSQUEDA_DUDA_VISTA;
    }

    @Autowired
    public void setRequirementService(RequirementService requirementService) {
        this.requirementService = requirementService;
    }


}
