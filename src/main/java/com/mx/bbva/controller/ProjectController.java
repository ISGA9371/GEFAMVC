package com.mx.bbva.controller;

import com.mx.bbva.business.entity.Project;
import com.mx.bbva.business.service.ProjectService;
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
@RequestMapping(value = "/projects")
public class ProjectController {
    private static final Logger LOG = Logger.getLogger(ProjectController.class.getName());

    private ProjectService projectService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createProject(Model model) {
        // TODO Validate user
        LOG.info("Creating new project");
        model.addAttribute("project", new Project());
        //TODO Add catalogs
        return URL_FACTORY + NEW_PROJECT;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveProject(@ModelAttribute("project") Project project) {
        // TODO Validate user
        projectService.saveProject(project);

        return URL_FACTORY + EDIT_PROJECT;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String findAllProjects(Model model) {
        // TODO Validate user
        List<Project> projects = projectService.findAllProjects();
        model.addAttribute("projects", projects);
        return URL_FACTORY + SEARCH_PROJECTS;
    }

    @RequestMapping(path = "/{projectId}", method = RequestMethod.GET)
    public String editProject(Model model, @PathVariable(value = "projectId") String projectId) {
        // TODO Validate user
        LOG.info("Updating project, ID: " + projectId);
        if (null != projectId) {
            Project project = projectService.findProject(projectId);
            model.addAttribute("project", project);
        } else {
            model.addAttribute("project", new Project());
        }
        return URL_FACTORY + EDIT_PROJECT;
    }

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

}
