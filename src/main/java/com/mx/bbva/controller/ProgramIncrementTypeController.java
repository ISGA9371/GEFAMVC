package com.mx.bbva.controller;

import com.mx.bbva.business.entity.ProgramIncrementType;
import com.mx.bbva.business.entity.Technology;
import com.mx.bbva.business.service.ProgramIncrementTypeService;
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
@RequestMapping(value = "/program-increment-types")
public class ProgramIncrementTypeController {
    private ProgramIncrementTypeService programIncrementTypeService;
    private TechnologyService technologyService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllProgramIncrementTypes(Model model) {
        List<ProgramIncrementType> piTypes = programIncrementTypeService.findAll();
        model.addAttribute("piTypes", piTypes);
        return "SOME_URL";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createProgramIncrementType(Model model) {
        model.addAttribute("ProgramIncrementType", new ProgramIncrementType());
        return "SOME_URL";
    }

    @RequestMapping(path = "/{programIncrementTypeId}", method = RequestMethod.GET)
    public String editProgramIncrementType(Model model, @PathVariable(value = "programIncrementTypeId") Integer programIncrementTypeId) {
        if (null != programIncrementTypeId) {
            ProgramIncrementType programIncrementType = programIncrementTypeService.findOne(programIncrementTypeId);
            model.addAttribute("ProgramIncrementType", programIncrementType);
        } else {
            model.addAttribute("ProgramIncrementType", new ProgramIncrementType());
        }
        return "SOME_URL";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveComponent(@ModelAttribute("ProgramIncrementType") ProgramIncrementType programIncrementType) {
        programIncrementTypeService.saveOne(programIncrementType);
        return "SOME_URL";
    }

    @ModelAttribute("technologies")
    public List<Technology> populateTechnologies() {
        return this.technologyService.findAllTechnologies();
    }

    @Autowired
    public void setProgramIncrementTypeService(ProgramIncrementTypeService programIncrementTypeService) {
        this.programIncrementTypeService = programIncrementTypeService;
    }

    @Autowired
    public void setTechnologyService(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }
}
