package com.mx.bbva.controller;

import com.mx.bbva.business.entity.Component;
import com.mx.bbva.business.entity.Modification;
import com.mx.bbva.business.entity.Origin;
import com.mx.bbva.business.entity.Priority;
import com.mx.bbva.business.service.ModificationService;
import com.mx.bbva.business.service.StatusService;
import com.mx.bbva.business.service.ComponentService;
import com.mx.bbva.business.service.PriorityService;
import com.mx.bbva.business.service.OriginService;
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

        // LOG.info("Saving new modification... " + modification.getModificationName());
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
        } else {
            model.addAttribute("modification", new Modification());
        }
        return URL_FACTORY + EDIT_MODIFICATION;
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
