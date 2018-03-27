package com.mx.bbva.controller;

import com.mx.bbva.business.entity.Component;
import com.mx.bbva.business.entity.Requirement;
import com.mx.bbva.business.entity.Typology;
import com.mx.bbva.business.service.ComponentService;
import com.mx.bbva.business.service.RequirementService;
import com.mx.bbva.business.service.TypologyService;
import com.mx.bbva.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

import static com.mx.bbva.util.ViewsURLs.*;

@Controller
@RequestMapping(value = "/components")
public class ComponentController {
    private static final Logger LOG = Logger.getLogger(ComponentController.class.getName());

    private ComponentService componentService;
    private TypologyService typologyService;
    //private typologyService levelTypeService;
    private RequirementService requirementService;

    @RequestMapping(value = "/alta", method = RequestMethod.GET)
    public String initCreate(Model model, @RequestParam("requirementId")String requirementId) {


       /* ModelAndView modelReq = new ModelAndView(Constants.ALTA_COMPONENTE);
       /* modelReq.addObject("nivelesCmb", componentService.findAllLevels());
        modelReq.addObject("areasCmb", areaService.findAllAreas());
        modelReq.addObject("tecnologiasCmb", technologyService.findAllTechnologies());*/
        /*List<Typology> lstTypology = new ArrayList<Typology>();
        for (int i = 1; i <= 4; i++) {
            Typology testTypology = new Typology();
            testTypology.setTypologyId(i);
            testTypology.setTypologyProductId("ID_" + i);
            lstTypology.add(testTypology);
        }*/
        // modelReq.addObject("tipologiaNewCmb", typologyService.findAllNew());
        //modelReq.addObject("tipologiaModCmb", typologyService.findAllMod());
        int requirementIdInt = -1;
        try{
            requirementIdInt = Integer.parseInt(requirementId);
        } catch (Exception e){
            requirementIdInt = -1;
        }
        LOG.info("id: " + requirementIdInt);
        if(-1!= requirementIdInt){
            //model.addAttribute("requerimientoData", requirementService.findRequirementForComponent(requirementIdInt));
        } else {
            model.addAttribute("requerimientoData", new Requirement());
        }
        model.addAttribute("componente", new Component());

        return Constants.ALTA_COMPONENTE;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createComponent(Model model) {
        // TODO Validate user

        LOG.info("Creating new component");
        model.addAttribute("component", new Component());
        //TODO Add catalogs
        return URL_FACTORY + NEW_COMPONENT;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveComponent(@ModelAttribute("componente") Component component) {
        // TODO Validate user

        // LOG.info("Saving new component... " + component.getComponentName());
        componentService.saveComponent(component);

        return URL_FACTORY + EDIT_COMPONENT;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String findAllComponents(Model model) {
        // TODO Validate user

        List<Component> components = componentService.findAllComponents();
        model.addAttribute("components", components);

        return URL_FACTORY + SEARCH_COMPONENTS;
    }

    @RequestMapping(path = "/{componentId}", method = RequestMethod.GET)
    public String editComponent(Model model, @PathVariable(value = "componentId") Integer componentId) {
        // TODO Validate user
        LOG.info("Updating component, ID: " + componentId);
        if (null != componentId) {
            Component component = componentService.findComponent(componentId);
            model.addAttribute("component", component);
        } else {
            model.addAttribute("component", new Component());
        }
        return URL_FACTORY + EDIT_COMPONENT;
    }

    @ModelAttribute("tipologiaNewCmb")
    public List<Typology> populateNewTypologies() {
        return this.typologyService.findByComponent("0");
    }

    @ModelAttribute("tipologiaModCmb")
    public List<Typology> populateModTypologies() {
        return this.typologyService.findByComponent("1");
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

}
