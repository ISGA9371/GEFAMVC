package com.mx.bbva.controller;

import com.mx.bbva.business.entity.Component;
import com.mx.bbva.business.entity.Issue;
import com.mx.bbva.business.entity.Origin;
import com.mx.bbva.business.entity.Priority;
import com.mx.bbva.business.service.ComponentService;
import com.mx.bbva.business.service.IssueService;
import com.mx.bbva.business.service.OriginService;
import com.mx.bbva.business.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createIssue(Model model, @RequestParam(value = "componentId") Integer componentId) {
        // TODO Validate user
        LOG.info("Creating new issue");
        Component component = componentService.findComponent(componentId);
        model.addAttribute("componentData", component);
        model.addAttribute("issue", new Issue());
        //TODO Add catalogs
        return URL_FACTORY + NEW_ISSUE;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveIssue(@ModelAttribute("issuee") Issue issue) {
        // TODO Validate user
        issueService.saveIssue(issue);
        return URL_FACTORY + EDIT_ISSUE;
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

    @ModelAttribute("origins")
    public List<Origin> populateOrigins() {
        return this.originService.findAllOrigins();
    }

    @ModelAttribute("priorities")
    public List<Priority> populatePriorities() {
        return this.priorityService.findAllPriorities();
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
}
