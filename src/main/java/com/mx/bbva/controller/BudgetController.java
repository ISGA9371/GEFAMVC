package com.mx.bbva.controller;

import com.mx.bbva.business.dto.BudgetSearchDTO;
import com.mx.bbva.business.dto.BudgetTransferDTO;
import com.mx.bbva.business.entity.*;
import com.mx.bbva.business.service.*;
import com.mx.bbva.util.query.QueryGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static com.mx.bbva.util.ViewsURLs.*;

@Controller
@RequestMapping(value = "/budgets")
public class BudgetController {
    private static final Logger LOG = Logger.getLogger(BudgetController.class.getName());

    private BudgetService budgetService;
    private AreaService areaService;
    private LevelService levelService;
    private UserService userService;
    private BankingService bankingService;
    private CorporationService corporationService;
    private NatureService natureService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createBudget(Model model) {
        // TODO Validate user

        LOG.info("Creating new budget");
        model.addAttribute("budget", new Budget());
        model.addAttribute("budgetTransfer", new BudgetTransferDTO());
        //TODO Add catalogs
        return URL_BUDGET + NEW_BUDGET;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveBudget(@ModelAttribute("budget") Budget budget) {
        // TODO Validate user

        // LOG.info("Saving new budget... " + budget.getBudgetName());
        budgetService.saveBudget(budget);

        return URL_BUDGET + EDIT_BUDGET;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String findAllBudgets(Model model) {
        // TODO Validate user

        List<Budget> budgets = budgetService.findAllBudgets();
        model.addAttribute("budgets", budgets);

        return URL_BUDGET + SEARCH_BUDGETS;
    }

    @RequestMapping(path = "/{budgetId}", method = RequestMethod.GET)
    public String editBudget(Model model, @PathVariable(value = "budgetId") String budgetId) {
        // TODO Validate user
        LOG.info("Updating budget, ID: " + budgetId);
        if (null != budgetId) {
            Budget budget = budgetService.findBudget(budgetId);
            model.addAttribute("budget", budget);
        } else {
            model.addAttribute("budget", new Budget());
        }
        return URL_BUDGET + EDIT_BUDGET;
    }

    @RequestMapping(value = "/filters", method = RequestMethod.GET)
    public String filtersForRequirements(Model model) {
        model.addAttribute("filters", new Budget());
        return URL_BUDGET + SEARCH_BUDGETS;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchForBudgets(@ModelAttribute("budgetSearchDTO") BudgetSearchDTO budgetSearchDTO, Model model) {
        // TODO Work in progress
        String query = new QueryGenerator().generate(budgetSearchDTO, "Budget");
        List<Budget> budgets = budgetService.findByCustomQuery(query);
        model.addAttribute("budgets", budgets);
        return URL_FACTORY + SEARCH_REQUIREMENTS;
    }

    @ModelAttribute("areas")
    public List<Area> populateAreas() {
        return this.areaService.findAllAreas();
    }

    //FALTA COMBO AÑO TABLAS BUDGETS
    @ModelAttribute("budgetYears")
    public List<Integer> populateBubgetYears() {
        return this.budgetService.findAllYears();
    }

    //FALTA COMBO BANCAS TABLAS 34
    // LevelTypeId 1 - Direccion
    @ModelAttribute("bankingList")
    public List<Banking> populateBankingList() {
        return this.bankingService.findAllBanking();
    }

    //FALTA COMBO ENTIDAD TABLAS 37
    @ModelAttribute("corporations")
    public List<Corporation> populateCorporations() {
        return this.corporationService.findAllCorporations();
    }

    //FALTA COMBO NATURALEZA TABLAS 38
    @ModelAttribute("natures")
    public List<Nature> populateNatures() {
        return this.natureService.findAllNatures();
    }

    // LevelTypeId 1 - Direccion
    @ModelAttribute("principals")
    public List<Level> populatePrincipals() {
        return this.levelService.findByLevelType(new LevelType(1));
    }

    // LevelTypeId 2 - Sub-Direccion
    @ModelAttribute("subPrincipals")
    public List<Level> populateSubPrincipals() {
        LOG.info(this.levelService.findByLevelType(new LevelType(2)).get(2).getLevelSuperior() + "");

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

    // Import services
    @Autowired
    public void setAreaService(AreaService areaService) {
        this.areaService = areaService;
    }

    @Autowired
    public void setLevelService(LevelService levelService) {
        this.levelService = levelService;
    }

    @Autowired
    public void setBudgetService(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setBankingService(BankingService bankingService) {
        this.bankingService = bankingService;
    }

    @Autowired
    public void setCorporationService(CorporationService corporationService) {
        this.corporationService = corporationService;
    }

    @Autowired
    public void setNatureService(NatureService natureService) {
        this.natureService = natureService;
    }
}
