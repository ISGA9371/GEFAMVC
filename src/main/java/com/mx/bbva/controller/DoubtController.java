package com.mx.bbva.controller;

import com.mx.bbva.business.entity.*;
import com.mx.bbva.business.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static com.mx.bbva.util.ViewsURLs.*;

@Controller
@RequestMapping("/doubts")
public class DoubtController {
    private static final Logger LOG = Logger.getLogger(DoubtController.class.getName());

    private DoubtService doubtService;
    private LevelService levelService;
    private CompanyService companyService;
    private PriorityService priorityService;
    private StatusService statusService;
    private ComponentService componentService;
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addDoubt(Model model, @RequestParam(value = "componentId") Integer componentId) {
        Component component = componentService.findComponent(componentId);
        model.addAttribute("componentData", component);
        model.addAttribute("doubt", new Doubt());
        return URL_FACTORY + NEW_DOUBT;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveDoubt(@ModelAttribute("doubt") Doubt doubt) {
        doubtService.saveDoubt(doubt);
        // TODO
        //return URL_FACTORY + EDIT_DOUBT;
        return INDEX;
    }

    @RequestMapping(value = "/{doubtId}", method = RequestMethod.GET)
    public String getOneDoubt(Model model, @PathVariable Integer doubtId) {
        Doubt doubt = doubtService.findDoubt(doubtId);
        model.addAttribute("doubt", doubt);
        return URL_FACTORY + EDIT_DOUBT;
    }

    // Model Attributes will available to the view all the time
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

    @ModelAttribute("companies")
    public List<Company> populateCompanies() {
        return this.companyService.findAllCompaniesForDropDownList();
    }

    @ModelAttribute("priorities")
    public List<Priority> populatePriorities() {
        return this.priorityService.findAllPriorities();
    }

    @ModelAttribute("status")
    public List<Status> populateStatus() {
        return this.statusService.findAllStatus();
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

    // Import services
    @Autowired
    public void setDoubtService(DoubtService doubtService) {
        this.doubtService = doubtService;
    }

    @Autowired
    public void setLevelService(LevelService levelService) {
        this.levelService = levelService;
    }

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Autowired
    public void setPriorityService(PriorityService priorityService) {
        this.priorityService = priorityService;
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
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
