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
        components.add(new Component(1, "Componente1", "001", "Type1"));
        components.add(new Component(2, "Componente2", "002", "Type"));
        model.addAttribute("components", components);

        return "fabrica/homeComponente";
    }

    @RequestMapping(path = "/{componentId}", method = RequestMethod.GET)
    public String editComponent(Model model, @PathVariable(value = "componentId") Integer componentId) {
        // TODO Validate user

        LOG.info("Updating component, ID: " + componentId);
        Component component = componentService.findComponent(componentId);
        Component finalComponent = new Component(3, "Componente3", "003", "Type3");
        model.addAttribute("component", finalComponent);

        return "fabrica/ModificarComponente";
    }

    public void setComponentService(ComponentService componentService) {
        this.componentService = componentService;
    }
}
