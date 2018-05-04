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
@RequestMapping("/ayuda")
public class AyudaController {
    private static final Logger LOG = Logger.getLogger(DoubtController.class.getName());

    //private DoubtService doubtService;
    private LevelService levelService;
    //private CompanyService companyService;
    //private PriorityService priorityService;
    //private StatusService statusService;
    //private ComponentService componentService;
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addDoubt(Model model, @RequestParam(value = "componentId") Integer componentId) {
        //Component component = componentService.findComponent(componentId);
        //model.addAttribute("componentData", component);
        model.addAttribute("doubt", new Doubt());
        return URL_BUDGET + NEW_DISPERSION;
    }

    @ModelAttribute("principals")
    public List<Level> populatePrincipals() {
        return this.levelService.findByLevelType(new LevelType(1));
    }

    // LevelTypeId 2 - Sub-Direccion
    @ModelAttribute("subPrincipals")
    public List<Level> populateSubPrincipals() {
        return this.levelService.findByLevelType(new LevelType(2));
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

    @Autowired
    public void setLevelService(LevelService levelService) {
        this.levelService = levelService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
