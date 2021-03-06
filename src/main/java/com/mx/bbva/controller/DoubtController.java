package com.mx.bbva.controller;

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
        Doubt doubtSaved = this.doubtService.findDoubt(doubt.getDoubtId());
        return REDIRECT + "doubts/" + doubtSaved.getDoubtId();
    }

    @RequestMapping(value = "/{doubtId}", method = RequestMethod.GET)
    public String getOneDoubt(Model model, @PathVariable Integer doubtId) {
        Doubt doubt = this.doubtService.findDoubt(doubtId);
        model.addAttribute("doubt", doubt);
        model.addAttribute("componentData", doubt.getComponent());
        return URL_FACTORY + EDIT_DOUBT;
    }

    @RequestMapping(value = "/filters", method = RequestMethod.GET)
    public String filtersForDoubts(Model model) {
        // model.addAttribute("doubtSearchDTO", new DoubtSearchDTO());
        return URL_FACTORY + SEARCH_DOUBTS;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchForDoubts(Model model) {
        // TODO Work in progress
        /*String query = new QueryGenerator().generate(doubtSearchDTO, "Doubt");
        List<Doubt> doubts = new ArrayList<>();
        doubts = doubtService.findByCustomQuery(query); */
        model.addAttribute("doubts", this.doubtService.findAllDoubts());
        return URL_FACTORY + SEARCH_DOUBTS;
    }

    @RequestMapping(value = "/types", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllDoubtTypes() {
        List<DoubtType> doubtTypes = this.doubtService.findAllDoubtTypes();
        return new ResponseEntity<Object>(new ResponseListDTO(doubtTypes), HttpStatus.OK);
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

    @ModelAttribute("doubtTypes")
    public List<DoubtType> populateDoubtTypes() {
        return this.doubtService.findAllDoubtTypes();
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
