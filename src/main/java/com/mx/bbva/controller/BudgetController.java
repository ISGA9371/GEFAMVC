package com.mx.bbva.controller;

import com.mx.bbva.business.dto.BudgetSearchDTO;
import com.mx.bbva.business.dto.ResponseDTO;
import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.*;
import com.mx.bbva.business.service.*;
import com.mx.bbva.util.query.BudgetQueryGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
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

    // This method will fit the info for the view
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createBudget(Model model) {
        // TODO Validate user

        LOG.info("Creating new budget");
        model.addAttribute("budget", new Budget());
        model.addAttribute("transfer", new Transfer());
        //TODO Add catalogs
        return URL_BUDGET + NEW_BUDGET;
    }

    // save the budget and generate the transfer, return to edit the saved transfer
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveBudget(@ModelAttribute("budget") Budget budget, @ModelAttribute("transfer") Transfer transfer) {
        // TODO Validate user

        //TODO Validate if the budget already exist

        budgetService.saveBudget(budget);

        if (transfer != null) {
            transfer.setBudget(budget);
            transferService.saveTransfer(transfer);
            return REDIRECT + "budgets/transfers/" + transfer.getTransferId();
        }

        return URL_BUDGET + SEARCH_BUDGETS;
    }

    @RequestMapping(path = "/{budgetId}", method = RequestMethod.GET)
    public String editBudget(Model model, @PathVariable(value = "budgetId") String budgetId) {
        // TODO Validate user
        if (null != budgetId) {
            Budget budget = budgetService.findBudget(budgetId);
            model.addAttribute("budget", budget);
        } else {
            model.addAttribute("budget", new Budget());
        }
        return URL_BUDGET + EDIT_BUDGET;
    }

    @RequestMapping(path = "/transfers/{transferId}", method = RequestMethod.GET)
    public String editTransfer(Model model, @PathVariable(value = "transferId") Integer transferId) {
        // TODO Validate user
        LOG.info("Updating transfer, ID: " + transferId);
        if (null != transferId) {
            Transfer transfer = transferService.findTransfer(transferId);
            model.addAttribute("transfer", transfer);
        } else {
            model.addAttribute("transfer", new Transfer());
        }
        return URL_BUDGET + EDIT_BUDGET;
    }

    // Update a transfer
    @RequestMapping(value = "/transfers", method = RequestMethod.PUT)
    public String saveTransfer(@ModelAttribute("transfer") Transfer transfer) {
        // TODO Validate user

        Transfer transferSaved = transferService.saveTransfer(transfer);

        return REDIRECT + "budgets/" + transferSaved.getTransferId();
    }

    // This method will fit the info to generate a new budget-transfer
    @RequestMapping(value = "/{budgetId}/transfers/add", method = RequestMethod.GET)
    public String createTransfer(Model model, @PathVariable("budgetId") String budgetId) {
        // TODO Validate user

        Budget budget = budgetService.findBudget(budgetId);
        LOG.info("Creating new transfer... budgetID = " + budget.getBudgetId());
        model.addAttribute("budget", budget);
        model.addAttribute("transfer", new Transfer());
        //TODO Add catalogs
        return URL_BUDGET + NEW_TRANSFER;
    }

    // This method will fit the view's info, adding the selected transfer
    @RequestMapping(value = "/{budgetId}/dispersions/add", method = RequestMethod.GET)
    public String createDispersion(Model model, @PathVariable("budgetId") String budgetId,
                                   @RequestParam("transferId") Integer transferId) {
        // TODO Validate user
        // TODO budgetId ill have tu use that
        Transfer transfer = transferService.findTransfer(transferId);
        model.addAttribute("transfer", transfer);
        //TODO Add catalogs
        return URL_BUDGET + NEW_DISPERSION;
    }

    // This method will fit the view's info, adding the selected transfer
    @RequestMapping(value = "/{budgetId}/dispersions", method = RequestMethod.PUT)
    public String addDispersion(@PathVariable("budgetId") Integer budgetId,
                                @RequestBody List<Transfer> transfers) {
        // TODO Validate user

        // TODO do something here

        //TODO Add catalogs
        return URL_BUDGET + SEARCH_BUDGETS;
    }

    @RequestMapping(value = "/filters", method = RequestMethod.GET)
    public String filtersForRequirements(Model model) {
        model.addAttribute("budgetSearchDTO", new BudgetSearchDTO());
        return URL_BUDGET + SEARCH_BUDGETS;
    }

    @ResponseBody
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Transfer> searchForBudgets(@RequestParam Map<String, String> parameters) {
        // TODO Work in progress
        String query = new BudgetQueryGenerator().generateQuery(parameters);
        List<Budget> budgets = budgetService.findByCustomQuery(query);

        List<Transfer> transfers = new ArrayList<>();
        for (Budget budget : budgets) {
            transfers.addAll(transferService.findTransfersByBudget(budget));
        }
        for (Transfer transfer : transfers) {
            Budget budgetDb = transfer.getBudgetDb();
            budgetDb.setTransfers(null);
            transfer.setBudget(budgetDb);
        }
        return transfers;
    }

    @RequestMapping(value = "/invoices/implantation-dates", method = RequestMethod.GET)
    public ResponseEntity<?> invoiceImplantationDates() {

        List<Date> invoiceSendDates = invoiceService.findAllInvoiceSendDates();

        return new ResponseEntity<Object>(new ResponseListDTO(invoiceSendDates), HttpStatus.OK);
    }

    @RequestMapping(value = "/invoices/cut-dates", method = RequestMethod.GET)
    public ResponseEntity<?> invoiceCutDates() {

        List<Date> invoiceCutDates = invoiceService.findAllInvoiceCutDates();

        return new ResponseEntity<Object>(new ResponseListDTO(invoiceCutDates), HttpStatus.OK);
    }

    @RequestMapping(value = "/billing/filters", method = RequestMethod.GET)
    public String filtersForBilling(Model model) {
        model.addAttribute("invoice", new Invoice());
        return URL_BUDGET + BILLING_CUT;
    }


    @ResponseBody
    @RequestMapping(value = "/billing/search", method = RequestMethod.GET)
    public List<Invoice> searchForBillings(@RequestParam Map<String, String> parameters) {
        // TODO Work in progress
        /* String query = new QueryGenerator().generate(budgetSearchDTO, "Budget");
        List<Budget> budgets = budgetService.findByCustomQuery(query); */

        return invoiceService.findAllInvoices();
    }

    @RequestMapping(value = "/payments/filters", method = RequestMethod.GET)
    public String filtersForPayment(Model model) {
        model.addAttribute("payment", new Payment());
        return URL_BUDGET + STATUS_PAYMENT;
    }


    @ResponseBody
    @RequestMapping(value = "/payments/search", method = RequestMethod.GET)
    public List<Payment> searchForPayments(@RequestParam Map<String, String> parameters) {
        // TODO Work in progress
        /*String query = new QueryGenerator().generate(budgetSearchDTO, "Budget");
        List<Budget> budgets = budgetService.findByCustomQuery(query);*/

        return paymentService.findAllPayments();
    }

    @RequestMapping(value = "/assign", method = RequestMethod.PUT)
    public ResponseEntity<?> assignBudget(Model model, @RequestBody List<BudgetRequirement> budgetRequirements) {

        for (BudgetRequirement budgetRequirement : budgetRequirements) {
            if (budgetService.notAvailableForAssignment(budgetRequirement)) {
                //SEND ERROR MESSAGE MAYBE
                budgetRequirements.remove(budgetRequirement);
            }
        }
        budgetService.assignBudget(budgetRequirements);

        return new ResponseEntity<Object>(new ResponseDTO("success"), HttpStatus.OK);
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
                                        @ModelAttribute("requirementData") Requirement requirement,
                                        @RequestParam Map<String, String> parameters, Model model) {
        // TODO Work in progress
        String query = new BudgetQueryGenerator().generateQuery(parameters);
        List<Budget> budgets = budgetService.findByCustomQuery(query);

        model.addAttribute("budgetSearchDTO", budgetSearchDTO);
        model.addAttribute("requirementData", requirementService.findOneRequirement(requirement.getRequirementId()));
        model.addAttribute("budgets", budgets);

        return "/layout/pepe-result :: coso";
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
