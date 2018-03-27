package com.mx.bbva.controller;

import com.mx.bbva.business.entity.ProgramIncrement;
import com.mx.bbva.business.entity.Technology;
import com.mx.bbva.business.service.ProgramIncrementService;
import com.mx.bbva.business.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/program-increment")
public class ProgramIncrementController {
    private ProgramIncrementService programIncrementTypeService;
    private TechnologyService technologyService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllProgramIncrements(Model model) {
        List<ProgramIncrement> piTypes = programIncrementTypeService.findAll();
        model.addAttribute("piTypes", piTypes);
        return "SOME_URL";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createProgramIncrement(Model model) {
        model.addAttribute("ProgramIncrement", new ProgramIncrement());
        return "SOME_URL";
    }

    @RequestMapping(path = "/{programIncrementTypeId}", method = RequestMethod.GET)
    public String editProgramIncrement(Model model, @PathVariable(value = "programIncrementTypeId") Integer programIncrementTypeId) {
        if (null != programIncrementTypeId) {
            ProgramIncrement programIncrement = programIncrementTypeService.findOne(programIncrementTypeId);
            model.addAttribute("ProgramIncrement", programIncrement);
        } else {
            model.addAttribute("ProgramIncrement", new ProgramIncrement());
        }
        return "SOME_URL";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveComponent(@ModelAttribute("ProgramIncrement") ProgramIncrement programIncrement) {
        programIncrementTypeService.saveOne(programIncrement);
        return "SOME_URL";
    }

    @ModelAttribute("technologies")
    public List<Technology> populateTechnologies() {
        return this.technologyService.findAllTechnologies();
    }

    @Autowired
    public void setProgramIncrementService(ProgramIncrementService programIncrementTypeService) {
        this.programIncrementTypeService = programIncrementTypeService;
    }

    @Autowired
    public void setTechnologyService(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }
}
