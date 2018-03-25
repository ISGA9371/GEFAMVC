package com.mx.bbva.controller;

import com.mx.bbva.business.model.Issue;
import com.mx.bbva.business.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/issues")
public class IssueController {
    private static final Logger LOG = Logger.getLogger(IssueController.class.getName());

    private IssueService issueService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createIssue(Model model) {
        // TODO Validate user
        LOG.info("Creating new issue");
        model.addAttribute("issue", new Issue());
        //TODO Add catalogs
        return "SOME-URL";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveIssue(@ModelAttribute("issuee") Issue issue) {
        // TODO Validate user
        issueService.saveIssue(issue);
        return "SOME-URL";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String findAllIssues(Model model) {
        // TODO Validate user
        List<Issue> issues = issueService.findAll();
        model.addAttribute("issues", issues);
        return "SOME-URL";
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
        return "SOME-URL";
    }

    @Autowired
    public void setIssueService(IssueService issueService) {
        this.issueService = issueService;
    }
}
