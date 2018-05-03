package com.mx.bbva.controller;

import com.mx.bbva.business.dto.ModificationSearchDTO;
import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.*;
import com.mx.bbva.business.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    private UserService userService;

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
        return REDIRECT + "modifications/" + modification.getModificationId();
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

    @ResponseBody
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<?> searchForModifications(@RequestParam Map<String, String> parameters) {
        // TODO Work in progress
        /*String query = new ModificationQueryGenerator().generateQuery(modificationSearchDTO);
        List<Modification> modifications = modificationService.findByCustomQuery(query); */
        return new ResponseEntity<Object>(new ResponseListDTO(this.modificationService.findAllModifications()), HttpStatus.OK);
    }

    @ModelAttribute("users")
    public List<User> populateUsers() {
        List<User> users = new ArrayList<>();
        // TODO Use Enum's
        // 1 - Gestoria FSW
        users.addAll(this.userService.findUsersByType(1));
        // 2 - Gestoria PBAS
        users.addAll(this.userService.findUsersByType(2));
        return users;
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

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
