package com.mx.bbva.controller;

import com.mx.bbva.business.entity.Component;
import com.mx.bbva.business.entity.Requirement;
import com.mx.bbva.business.entity.Typology;
import com.mx.bbva.business.service.ComponentService;
import com.mx.bbva.business.service.RequirementService;
import com.mx.bbva.business.service.TypologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
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

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createComponent(Model model, @RequestParam("requirementId") String requirementId) {

        int requirementIdInt = -1;
        try {
            requirementIdInt = Integer.parseInt(requirementId);
        } catch (Exception e) {
            requirementIdInt = -1;
        }
        //LOG.info("id: " + requirementIdInt);
        try {
            if (-1 != requirementIdInt) {
                model.addAttribute("requerimientoData", requirementService.findRequirementForComponent(requirementIdInt));
            } else {
                model.addAttribute("requerimientoData", new Requirement());
            }
            model.addAttribute("componente", new Component());
        } catch (Exception e) {
            LOG.info("ERROR AL RECUPERAR REQUERIMIENTO");
            LOG.log(Level.SEVERE, e.getMessage(), e);
            Requirement contingency = new Requirement();
            contingency.setRequirementName("ERROR AL RECUPERAR REQUERIMIENTO");
            contingency.setRequirementId(1);
            model.addAttribute("requerimientoData", contingency);
        }
        model.addAttribute("componente", new Component());
        return URL_FACTORY + NEW_COMPONENT;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveComponent(@RequestParam("componentName") String componentName, @RequestParam("componentVersion") String componentVersion,
                                @RequestParam("componentNewMod") String componentNewMod, @RequestParam("requirement") String requirement,
                                @RequestParam("typology") String typology, @RequestParam("componentDesignRealDeliverDate") String componentDesignRealDeliverDate,
                                @RequestParam("componentPreviewDeliverDate") String componentPreviewDeliverDate, @RequestParam("componentPossibleDeliverDate") String componentPossibleDeliverDate,
                                @RequestParam("componentRealDeliverDate") String componentRealDeliverDate) {

        // LOG.info("Saving new component... " + component.getComponentName())
        try {
            LOG.info("Nombre Componente: " + componentName);
            Component protoComponent = new Component();
            protoComponent.setComponentName(componentName);
            protoComponent.setComponentVersion(componentVersion);
            protoComponent.setComponentNewMod(componentNewMod);
            Requirement protoRequirement = null;
            int requirementIdInt = -1;
            try {
                requirementIdInt = Integer.parseInt(requirement);
            } catch (Exception e) {
                requirementIdInt = -1;
            }
            try {
                if (-1 != requirementIdInt) {
                    protoRequirement = requirementService.findRequirementForComponent(requirementIdInt);
                } else {
                    //protoRequirement = new Requirement();
                    protoRequirement.setRequirementId(1);
                }
            } catch (Exception e) {
                LOG.info("ERROR AL RECUPERAR REQUERIMIENTO");
                LOG.log(Level.SEVERE, e.getMessage(), e);
                //protoRequirement = new Requirement();
                protoRequirement.setRequirementId(1);
            }
            protoComponent.setRequirement(protoRequirement);
            Typology protoTypology = this.typologyService.findById(typology);
            protoComponent.setTypology(protoTypology);
            Date protoComponentDesignRealDeliverDate = new SimpleDateFormat("dd/MM/yyyy").parse(componentDesignRealDeliverDate);
            protoComponent.setComponentDesignRealDeliverDate(protoComponentDesignRealDeliverDate);
            Date protoComponentPreviewDeliverDate = new SimpleDateFormat("dd/MM/yyyy").parse(componentPreviewDeliverDate);
            protoComponent.setComponentPreviewDeliverDate(protoComponentPreviewDeliverDate);
            Date protoComponentPossibleDeliverDate = new SimpleDateFormat("dd/MM/yyyy").parse(componentPossibleDeliverDate);
            protoComponent.setComponentPossibleDeliverDate(protoComponentPossibleDeliverDate);
            Date protoComponentRealDeliverDate = new SimpleDateFormat("dd/MM/yyyy").parse(componentRealDeliverDate);
            protoComponent.setComponentRealDeliverDate(protoComponentRealDeliverDate);

        } catch (Exception e) {
            LOG.info("ERROR AL GUARDAR COMPONENTE");
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
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
