package com.mx.bbva.controller;

import com.mx.bbva.business.entity.Budget;
import com.mx.bbva.business.service.BudgetService;
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
@RequestMapping(value = "/budgets")
public class BudgetController {
    private static final Logger LOG = Logger.getLogger(BudgetController.class.getName());

    private BudgetService budgetService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createBudget(Model model) {
        // TODO Validate user

        LOG.info("Creating new budget");
        model.addAttribute("budget", new Budget());
        //TODO Add catalogs
        return URL_FACTORY + NEW_BUDGET;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveBudget(@ModelAttribute("budgete") Budget budget) {
        // TODO Validate user

        // LOG.info("Saving new budget... " + budget.getBudgetName());
        budgetService.saveBudget(budget);

        return URL_FACTORY + EDIT_BUDGET;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String findAllBudgets(Model model) {
        // TODO Validate user

        List<Budget> budgets = budgetService.findAllBudgets();
        model.addAttribute("budgets", budgets);

        return "redirect:/" + URL_FACTORY + SEARCH_BUDGETS;
    }

    @RequestMapping(path = "/{budgetId}", method = RequestMethod.GET)
    public String editBudget(Model model, @PathVariable(value = "budgetId") Integer budgetId) {
        // TODO Validate user
        LOG.info("Updating budget, ID: " + budgetId);
        if (null != budgetId) {
            Budget budget = budgetService.findBudget(budgetId);
            model.addAttribute("budget", budget);
        } else {
            model.addAttribute("budget", new Budget());
        }
        return URL_FACTORY + EDIT_BUDGET;
    }

    @Autowired
    public void setBudgetService(BudgetService budgetService) {
        this.budgetService = budgetService;
    }
}
