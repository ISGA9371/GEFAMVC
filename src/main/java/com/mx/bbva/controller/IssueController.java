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
import java.util.Map;
import java.util.logging.Logger;

import static com.mx.bbva.util.ViewsURLs.*;

@Controller
@RequestMapping(value = "/issues")
public class IssueController {
    private static final Logger LOG = Logger.getLogger(IssueController.class.getName());

    private IssueService issueService;
    private OriginService originService;
    private PriorityService priorityService;
    private ComponentService componentService;
    private UserService userService;
    private LevelService levelService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createIssue(Model model, @RequestParam(value = "componentId") Integer componentId) {
        // TODO Validate user
        Component component = componentService.findComponent(componentId);
        model.addAttribute("componentData", component);
        model.addAttribute("issue", new Issue());
        //TODO Add catalogs
        return URL_FACTORY + NEW_ISSUE;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveIssue(@ModelAttribute("issue") Issue issue) {
        issueService.saveIssue(issue);
        Issue issueSaved = issueService.findIssue(issue.getIssueId());
        return REDIRECT + "issues/" + issueSaved.getIssueId();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String findAllIssues(Model model) {
        // TODO Validate user
        List<Issue> issues = issueService.findAll();
        model.addAttribute("issues", issues);
        return URL_FACTORY + SEARCH_ISSUES;
    }

    @RequestMapping(path = "/{issueId}", method = RequestMethod.GET)
    public String editIssue(Model model, @PathVariable(value = "issueId") Integer issueId) {
        // TODO Validate user
        LOG.info("Updating issue, ID: " + issueId);
        if (null != issueId) {
            Issue issue = issueService.findIssue(issueId);
            model.addAttribute("issue", issue);
        } else {
            model.addAttribute("issue", new Issue());
        }
        return URL_FACTORY + EDIT_ISSUE;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<?> searchForIssues(@RequestParam Map<String, String> parameters) {
        // TODO Work in progress
        /*String query = new IssueQueryGenerator().generateQuery(issueSearchDTO);
        List<Issue> issues = issueService.findByCustomQuery(query); */
        return new ResponseEntity<Object>(new ResponseListDTO(this.issueService.findAll()), HttpStatus.OK);
    }

    @ModelAttribute("origins")
    public List<Origin> populateOrigins() {
        return this.originService.findAllOrigins();
    }

    @ModelAttribute("priorities")
    public List<Priority> populatePriorities() {
        return this.priorityService.findAllPriorities();
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
    public void setIssueService(IssueService issueService) {
        this.issueService = issueService;
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
    public void setComponentService(ComponentService componentService) {
        this.componentService = componentService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setLevelService(LevelService levelService) {
        this.levelService = levelService;
    }
}
