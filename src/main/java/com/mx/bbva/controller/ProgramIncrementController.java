package com.mx.bbva.controller;

import com.mx.bbva.business.entity.ProgramIncrement;
import com.mx.bbva.business.entity.Technology;
import com.mx.bbva.business.entity.Workplace;
import com.mx.bbva.business.service.ProgramIncrementService;
import com.mx.bbva.business.service.TechnologyService;
import com.mx.bbva.business.service.WorkplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/program-increments")
public class ProgramIncrementController {
    private static final Logger LOG = Logger.getLogger(ProgramIncrementController.class.getName());

    private ProgramIncrementService programIncrementService;
    private TechnologyService technologyService;
    private WorkplaceService workplaceService;

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
    public String saveProgramIncrement(@ModelAttribute("programIncrement") ProgramIncrement programIncrement,
                                       BindingResult result) {
        LOG.info("Saving one PI...");
        if (result.hasErrors()) {
            return "fabrica/testlist";
        }
        programIncrementService.saveOne(programIncrement);
        LOG.info("Success... PI Saved");
        return "redirect:/program-increments";
    }

    @ModelAttribute("technologies")
    public List<Technology> populateTechnologies() {
        return this.technologyService.findAllTechnologies();
    }

    @ModelAttribute("workplaces")
    public List<Workplace> populateWorkplaces() {
        return this.workplaceService.findAllWorkplaces();
    }


    @Autowired
    public void setProgramIncrementService(ProgramIncrementService programIncrementService) {
        this.programIncrementService = programIncrementService;
    }

    @Autowired
    public void setTechnologyService(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @Autowired
    public void setWorkplaceService(WorkplaceService workplaceService) {
        this.workplaceService = workplaceService;
    }
}
