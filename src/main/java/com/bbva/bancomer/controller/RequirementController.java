package com.bbva.bancomer.controller;


import com.bbva.bancomer.business.model.Level;
import com.bbva.bancomer.business.model.LevelType;
import com.bbva.bancomer.business.model.Requirement;
import com.bbva.bancomer.business.model.Technology;
import com.bbva.bancomer.business.service.*;
import com.bbva.bancomer.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/requerimiento")
public class RequirementController {
    private static final Logger log = Logger.getLogger(RequirementController.class.getName());

    private AreaService areaService;
    private RequirementService requirementService;
    private TechnologyService technologyService;
    private LevelService levelService;
    private LevelTypeService levelTypeService;

    private static final String REQUERIMIENTO_VISTA = "fabrica/AltaDeRequerimiento";
    private static final String MODIFICA_REQ_VISTA = "fabrica/ModificarRequerimiento";
    private static final String BUSCAR_REQ_VISTA = "fabrica/BusquedaDeRequerimientos";

    @GetMapping("/inicialRequerimiento")
    public ModelAndView entraRequerimiento() {

        ModelAndView modelReq = new ModelAndView(REQUERIMIENTO_VISTA);
        modelReq.addObject("nivelesCmb", levelService.findAllLevels());
        modelReq.addObject("areasCmb", areaService.findAllAreas());
        modelReq.addObject("tecnologiasCmb", technologyService.findAllTechnologies());
        modelReq.addObject("requerimiento", new Requirement());

        return modelReq;
    }

    @PostMapping("/guardaReq")
    public String guardaRequerimiento(@ModelAttribute("requerimiento") Requirement requirement) {
        requirementService.saveRequirement(requirement);
        System.out.print("LLega");
        return "redirect:/requerimiento/ModificaRequerimiento";

    }

    @GetMapping("/{id}")
    public String verRequerimiento(Model model, @PathVariable Integer id) {

        log.info("ID " + id);

        Requirement requirement = requirementService.findOneRequirement(id);

        model.addAttribute("req", requirement);

        return MODIFICA_REQ_VISTA;
    }

    @GetMapping("/buscar")
    public String buscar(Model model) {
        List<Technology> todas = technologyService.findAllTechnologies();

        LevelType direccionType = levelTypeService.findByLevelTypeName(Constants.TIPO_NIVEL_DIRECCION);

        List<Level> direcciones = levelService.findByLevelType(direccionType);

        for (Level l : direcciones) {
            log.info("TEC " + l.getLevelName());
        }

        model.addAttribute("tecnologias", todas);
        model.addAttribute("direcciones", direcciones);

        return BUSCAR_REQ_VISTA;
    }

    @Autowired
    public void setAreaService(AreaService areaService) {
        this.areaService = areaService;
    }

    @Autowired
    public void setRequirementService(RequirementService requirementService) {
        this.requirementService = requirementService;
    }

    @Autowired
    public void setTechnologyService(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @Autowired
    public void setLevelService(LevelService levelService) {
        this.levelService = levelService;
    }

    @Autowired
    public void setLevelTypeService(LevelTypeService levelTypeService) {
        this.levelTypeService = levelTypeService;
    }
}
