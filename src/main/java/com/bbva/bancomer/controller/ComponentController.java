package com.bbva.bancomer.controller;

import com.bbva.bancomer.business.model.Component;
import com.bbva.bancomer.business.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/components")
public class ComponentController {
    private static final Logger LOG = Logger.getLogger(ComponentController.class.getName());

    @Autowired
    private ComponentService componentService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createComponent(Model model) {
        // TODO Validate user

        LOG.info("Creating new component");
        model.addAttribute("component", new Component());
        //TODO Add catalogs

        return "/fabrica/ModificarComponente";
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public String saveComponent(Component component) {
        // TODO Validate user

        LOG.info("Saving new component... " + component.getComponentName());
        componentService.saveComponent(component);

        return "redirect:/fabrica/ModificarComponente";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String findAllComponents(Model model) {
        // TODO Validate user

        List<Component> components = componentService.findAllComponents();
        model.addAttribute("components", components);

        return "homeComponents";
    }

    @RequestMapping(path = "/{componentId}", method = RequestMethod.GET)
    public String editComponent(Model model, @PathVariable(value = "componentId") Integer componentId) {
        // TODO Validate user

        LOG.info("Updating component, ID: " + componentId);
        Component component = componentService.findComponent(componentId);
        model.addAttribute("component", component);

        return "redirect:/fabrica/ModificarComponente";
    }

    public void setComponentService(ComponentService componentService) {
        this.componentService = componentService;
    }
}
