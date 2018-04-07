package com.mx.bbva.controller;

import com.mx.bbva.business.dto.ComponentSearchDTO;
import com.mx.bbva.business.entity.*;
import com.mx.bbva.business.service.*;
import com.mx.bbva.util.query.QueryGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

import static com.mx.bbva.util.ViewsURLs.*;

@Controller
@RequestMapping(value = "/components")
public class ComponentController {
    private static final Logger LOG = Logger.getLogger(ComponentController.class.getName());

    private ComponentService componentService;
    private TypologyService typologyService;
    private RequirementService requirementService;
    private LevelService levelService;
    private StatusService statusService;
    private CompanyService companyService;

    /**
     * TODO: EVERY CONTROLLER NEEDS TO HAVE A CUSTOM SEARCH METHOD
     */

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createComponent(Model model, @RequestParam Integer requirementId) {
        // TODO Validate user
        LOG.info("Creating new component");
        Requirement requirement = requirementService.findOneRequirement(requirementId);
        model.addAttribute("requirementData", requirement);
        model.addAttribute("component", new Component());
        //TODO Add catalogs
        return URL_FACTORY + NEW_COMPONENT;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveComponent(@ModelAttribute("component") Component component, Model model) {
        // TODO Validate user
        LOG.info("Saving new component... " + component.getComponentName());
        componentService.saveComponent(component);
        Component savedComponent = componentService.findComponent(component.getComponentId());
        model.addAttribute("component", savedComponent);
        return URL_FACTORY + EDIT_COMPONENT;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String findAllComponents(Model model) {
        // TODO Validate user
        List<Component> components = componentService.findAllComponents();
        model.addAttribute("components", components);

        return URL_FACTORY + SEARCH_COMPONENTS;
    }

    @RequestMapping(value = "/{componentId}", method = RequestMethod.GET)
    public String editComponent(Model model, @PathVariable(value = "componentId") Integer componentId) {
        // TODO Validate user
        LOG.info("Updating component, ID: " + componentId);
        if (null != componentId) {
            Component component = componentService.findComponent(componentId);
            if (null != component.getRequirement()) {
                Requirement requirement = component.getRequirement();
                List<Level> superiorLevels = levelService
                        .findSuperiorLevelsByLevelType(requirement.getLevel().getLevelType());
                model.addAttribute("superiorLevels", superiorLevels);
            }
            model.addAttribute("component", component);
        } else {
            model.addAttribute("component", new Component());
        }
        return URL_FACTORY + EDIT_COMPONENT;
    }

    @RequestMapping(value = "/filters", method = RequestMethod.GET)
    public String filtersForComponents(Model model) {
        model.addAttribute("filters", new ComponentSearchDTO());
        return URL_FACTORY + SEARCH_COMPONENTS;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Component> searchForComponents(@ModelAttribute("filters") ComponentSearchDTO filters) {
        // TODO Work in progress
        String query = new QueryGenerator().generate(filters, "Component");
        return componentService.findByCustomQuery(query);
    }

    //TODO Use Enums
    @ModelAttribute("tipologiaNewCmb")
    public List<Typology> populateNewTypologies() {
        return this.typologyService.findByComponent(false);
    }

    @ModelAttribute("tipologiaModCmb")
    public List<Typology> populateModTypologies() {
        return this.typologyService.findByComponent(true);
    }

    // LevelTypeId 1 - Direccion
    @ModelAttribute("principals")
    public List<Level> populatePrincipals() {
        return this.levelService.findByLevelType(new LevelType(1));
    }

    // LevelTypeId 2 - Sub-Direccion
    @ModelAttribute("subPrincipals")
    public List<Level> populateSubPrincipals() {
        return this.levelService.findByLevelType(new LevelType(2));
    }

    @ModelAttribute("typingStatus")
    public List<Status> populateTypingStatus() {
        return this.statusService.findStatusByType(new StatusType(3));
    }

    @ModelAttribute("componentStatus")
    public List<Status> populateComponentStatus() {
        return this.statusService.findStatusByType(new StatusType(8));
    }

    @ModelAttribute("companies")
    public List<Company> populateCompanies() {
        return this.companyService.findAllCompaniesForDropDownList();
    }

    @Autowired
    public void setComponentService(ComponentService componentService) {
        this.componentService = componentService;
    }

    @Autowired
    public void setTypologyService(TypologyService typologyService) {
        this.typologyService = typologyService;
    }

    @Autowired
    public void setRequirementService(RequirementService requirementService) {
        this.requirementService = requirementService;
    }

    @Autowired
    public void setStatusService(StatusService statusService) {
        this.statusService = statusService;
    }

    @Autowired
    public void setLevelService(LevelService levelService) {
        this.levelService = levelService;
    }

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }
}
