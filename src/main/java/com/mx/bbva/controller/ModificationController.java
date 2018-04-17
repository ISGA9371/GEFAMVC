package com.mx.bbva.controller;

import com.mx.bbva.business.dto.ModificationSearchDTO;
import com.mx.bbva.business.entity.Component;
import com.mx.bbva.business.entity.Modification;
import com.mx.bbva.business.entity.Origin;
import com.mx.bbva.business.entity.Priority;
import com.mx.bbva.business.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

import static com.mx.bbva.util.ViewsURLs.*;

@Controller
@RequestMapping(value = "/modifications")
public class ModificationController {
    private static final Logger LOG = Logger.getLogger(ModificationController.class.getName());

    private ModificationService modificationService;
    private StatusService statusService;
    private ComponentService componentService;
    private OriginService originService;
    private PriorityService priorityService;

    /**
     * TODO: EVERY CONTROLLER NEEDS TO HAVE A CUSTOM SEARCH METHOD
     */

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createModification(Model model, @RequestParam(value = "componentId") Integer componentId) {
        // TODO Validate user
        LOG.info("Creating new modification");
        Component component = componentService.findComponent(componentId);
        model.addAttribute("componentData", component);
        model.addAttribute("modification", new Modification());
        //TODO Add catalogs
        return URL_FACTORY + NEW_MODIFICATION;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveModification(@ModelAttribute("modificatione") Modification modification) {
        // TODO Validate user
        modificationService.saveModification(modification);
        return URL_FACTORY + EDIT_MODIFICATION;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String findAllModifications(Model model) {
        // TODO Validate user
        List<Modification> modifications = modificationService.findAllModifications();
        model.addAttribute("modifications", modifications);

        return URL_FACTORY + SEARCH_MODIFICATIONS;
    }

    @RequestMapping(path = "/{modificationId}", method = RequestMethod.GET)
    public String editModification(Model model, @PathVariable(value = "modificationId") Integer modificationId) {
        // TODO Validate user
        LOG.info("Updating modification, ID: " + modificationId);
        if (null != modificationId) {
            Modification modification = modificationService.findModification(modificationId);
            model.addAttribute("modification", modification);
            model.addAttribute("componentData", modification.getComponent());
        } else {
            model.addAttribute("modification", new Modification());
            model.addAttribute("componentData", new Component() {
            });
        }
        return URL_FACTORY + EDIT_MODIFICATION;
    }

    @RequestMapping(value = "/filters", method = RequestMethod.GET)
    public String filtersForModifications(Model model) {
        model.addAttribute("modificationSearchDTO", new ModificationSearchDTO());
        return URL_FACTORY + SEARCH_MODIFICATIONS;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchForModifications(@ModelAttribute("modificationSearchDTO") ModificationSearchDTO modificationSearchDTO, Model model) {
        // TODO Work in progress
        /*String query = new ModificationQueryGenerator().generateQuery(modificationSearchDTO);
        List<Modification> modifications = modificationService.findByCustomQuery(query); */
        model.addAttribute("modifications", modificationService.findAllModifications());
        return URL_FACTORY + SEARCH_MODIFICATIONS;
    }

    @ModelAttribute("priorities")
    public List<Priority> populatePriorities() {
        return this.priorityService.findAllPriorities();
    }

    @ModelAttribute("origins")
    public List<Origin> populateOrigins() {
        return this.originService.findAllOrigins();
    }

    @Autowired
    public void setModificationService(ModificationService modificationService) {
        this.modificationService = modificationService;
    }

    @Autowired
    public void setStatusService(StatusService statusService) {
        this.statusService = statusService;
    }

    @Autowired
    public void setComponentService(ComponentService componentService) {
        this.componentService = componentService;
    }

    @Autowired
    public void setOriginService(OriginService originService) {
        this.originService = originService;
    }

    @Autowired
    public void setPriorityService(PriorityService priorityService) {
        this.priorityService = priorityService;
    }
}
