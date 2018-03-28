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
@RequestMapping(value = "/program-increments")
public class ProgramIncrementController {
    private ProgramIncrementService programIncrementService;
    private TechnologyService technologyService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllProgramIncrements(Model model) {
        List<ProgramIncrement> programIncrements = programIncrementService.findAll();
        model.addAttribute("programIncrements", programIncrements);
        return "fabrica/testlist";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createProgramIncrement(Model model) {
        model.addAttribute("programIncrement", new ProgramIncrement());
        return "fabrica/testedit";
    }

    @RequestMapping(path = "/{programIncrementTypeId}", method = RequestMethod.GET)
    public String editProgramIncrement(Model model, @PathVariable(value = "programIncrementTypeId") Integer programIncrementTypeId) {
        if (null != programIncrementTypeId) {
            ProgramIncrement programIncrement = programIncrementService.findOne(programIncrementTypeId);
            model.addAttribute("programIncrement", programIncrement);
        } else {
            model.addAttribute("programIncrement", new ProgramIncrement());
        }
        return "fabrica/testedit";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveComponent(@ModelAttribute("programIncrement") ProgramIncrement programIncrement) {
        programIncrementService.saveOne(programIncrement);
        return "redirect:/program-increments";
    }

    @ModelAttribute("technologies")
    public List<Technology> populateTechnologies() {
        return this.technologyService.findAllTechnologies();
    }

    @Autowired
    public void setProgramIncrementService(ProgramIncrementService programIncrementService) {
        this.programIncrementService = programIncrementService;
    }

    @Autowired
    public void setTechnologyService(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }
}
