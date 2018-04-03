package com.mx.bbva.controller;

import com.mx.bbva.business.entity.Component;
import com.mx.bbva.business.entity.Modification;
import com.mx.bbva.business.entity.Status;
import com.mx.bbva.business.entity.StatusType;
import com.mx.bbva.business.service.ModificationService;
import com.mx.bbva.business.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.logging.Logger;

import static com.mx.bbva.util.ViewsURLs.*;

@Controller
@RequestMapping(value = "/modifications")
public class ModificationController {
    private static final Logger LOG = Logger.getLogger(ModificationController.class.getName());

    private ModificationService modificationService;
    private StatusService statusService;

    /**
     * TODO: EVERY CONTROLLER NEEDS TO HAVE A CUSTOM SEARCH METHOD
     */

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createModification(Model model) {
        // TODO Validate user

        LOG.info("Creating new modification");
        model.addAttribute("modification", new Modification());
        model.addAttribute("component", new Component());


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

    @Autowired
    public void setModificationService(ModificationService modificationService) {
        this.modificationService = modificationService;
    }

    @Autowired
    public void setStatusService(StatusService statusService) {
        this.statusService = statusService;
    }
}
