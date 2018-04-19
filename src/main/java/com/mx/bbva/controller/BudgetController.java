package com.mx.bbva.controller;

import com.mx.bbva.business.dto.BudgetSearchDTO;
import com.mx.bbva.business.entity.*;
import com.mx.bbva.business.service.*;
import com.mx.bbva.util.query.QueryGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
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
    private TransferService transferService;
    private PaymentService paymentService;
    private InvoiceService invoiceService;
    private RequirementService requirementService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createBudget(Model model) {
        // TODO Validate user

        LOG.info("Creating new budget");
        model.addAttribute("budget", new Budget());
        model.addAttribute("transfer", new Transfer());
        //TODO Add catalogs
        return URL_BUDGET + NEW_BUDGET;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveBudget(@ModelAttribute("budget") Budget budget, @ModelAttribute("transfer") Transfer transfer) {
        // TODO Validate user

        // LOG.info("Saving new budget... " + budget.getBudgetName());
        budgetService.saveBudget(budget);
        transfer.setBudget(budget);
        transferService.saveTransfer(transfer);

        return REDIRECT + "budgets/" + transfer.getTransferId();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String findAllBudgets(Model model) {
        // TODO Validate user

        List<Budget> budgets = budgetService.findAllBudgets();
        model.addAttribute("budgets", budgets);

        return URL_BUDGET + SEARCH_BUDGETS;
    }

    @RequestMapping(path = "/{transferId}", method = RequestMethod.GET)
    public String editBudget(Model model, @PathVariable(value = "transferId") Integer transferId) {
        // TODO Validate user
        LOG.info("Updating transfer, ID: " + transferId);
        if (null != transferId) {
            //Budget budget = budgetService.findBudget(budgetId);
            Transfer transfer = transferService.findTransfer(transferId);
            LOG.info("Selected transfer: " + transfer);
            LOG.info("Selected transferId: " + transfer.getTransferId());
            model.addAttribute("transfer", transfer);
        } else {
            model.addAttribute("transfer", new Transfer());
        }
        return URL_BUDGET + EDIT_BUDGET;
    }

    @RequestMapping(value = "/filters", method = RequestMethod.GET)
    public String filtersForRequirements(Model model) {
        model.addAttribute("budgetSearchDTO", new BudgetSearchDTO());
        return URL_BUDGET + SEARCH_BUDGETS;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchForBudgets(@ModelAttribute("budgetSearchDTO") BudgetSearchDTO budgetSearchDTO, Model model) {
        // TODO Work in progress
        /*String query = new QueryGenerator().generate(budgetSearchDTO, "Budget");
        List<Budget> budgets = budgetService.findByCustomQuery(query); */
        model.addAttribute("budgets", budgetService.findAllBudgets());
        return URL_FACTORY + SEARCH_REQUIREMENTS;
    }

    @RequestMapping(value = "/billing/filters", method = RequestMethod.GET)
    public String filtersForBilling(Model model) {
        model.addAttribute("filters", new Budget());
        return URL_BUDGET + BILLING_CUT;
    }

    @RequestMapping(value = "/billing/search", method = RequestMethod.GET)
    public String searchForBillings(@ModelAttribute("billingSearchDTO") BudgetSearchDTO budgetSearchDTO, Model model) {
        // TODO Work in progress
        String query = new QueryGenerator().generate(budgetSearchDTO, "Budget");
        List<Budget> budgets = budgetService.findByCustomQuery(query);
        model.addAttribute("budgets", budgets);
        return URL_BUDGET + BILLING_CUT;
    }

    @RequestMapping(value = "/payments/filters", method = RequestMethod.GET)
    public String filtersForPayment(Model model) {
        model.addAttribute("payment", new Payment());
        return URL_BUDGET + STATUS_PAYMENT;
    }

    @RequestMapping(value = "/payments/search", method = RequestMethod.GET)
    public String searchForPayments(@ModelAttribute("payment") Payment payment, Model model) {
        // TODO Work in progress
        /*String query = new QueryGenerator().generate(budgetSearchDTO, "Budget");
        List<Budget> budgets = budgetService.findByCustomQuery(query);*/
        model.addAttribute("invoices", invoiceService.findAllInvoices());
        return URL_BUDGET + STATUS_PAYMENT;
    }

    @RequestMapping(value = "/assign", method = RequestMethod.PUT)
    public String assignBudget(Model model, @RequestParam("budgets") List<Budget> budgets) {

        return URL_FACTORY + ASSIGN_BUDGET_REQUIREMENT;
    }

    @RequestMapping(value = "/assign/filters", method = RequestMethod.GET)
    public String filtersForBudgetAssign(@RequestParam("requirementId") Integer requirementId, Model model) {
        Requirement requirement = requirementService.findOneRequirement(requirementId);
        model.addAttribute("requirementData", requirement);
        model.addAttribute("budgetSearchDTO", new BudgetSearchDTO());
        return URL_FACTORY + ASSIGN_BUDGET_REQUIREMENT;
    }

    @RequestMapping(value = "/assign/search", method = RequestMethod.GET)
    public String searchForBudgetAssing(@ModelAttribute("budgetSearchDTO") BudgetSearchDTO budgetSearchDTO,
                                        @ModelAttribute("requirementData") Requirement requirement, Model model) {
        // TODO Work in progress
        /*String query =
        List<Budget> budgets = budgetService.findByCustomQuery(query);*/
        model.addAttribute("requirementData", requirement);
        model.addAttribute("budgets", budgetService.findAllBudgets());
        return URL_FACTORY + ASSIGN_BUDGET_REQUIREMENT;
    }

    // CATALOGS

    @ModelAttribute("areas")
    public List<Area> populateAreas() {
        return this.areaService.findAllAreas();
    }

    //FALTA COMBO AÑO TABLAS BUDGETS
    @ModelAttribute("budgetYears")
    public List<Integer> populateBubgetYears() {
        return Arrays.asList(2017, 2018, 2019);
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

    @Autowired
    public void setTransferService(TransferService transferService) {
        this.transferService = transferService;
    }

    @Autowired
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Autowired
    public void setInvoiceService(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Autowired
    public void setRequirementService(RequirementService requirementService) {
        this.requirementService = requirementService;
    }
}
