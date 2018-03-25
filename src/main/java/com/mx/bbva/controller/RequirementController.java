package com.mx.bbva.controller;


import com.mx.bbva.business.entity.*;
import com.mx.bbva.business.service.*;
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
@RequestMapping("/requirements")
public class RequirementController {
    private static final Logger LOGGER = Logger.getLogger(RequirementController.class.getName());

    private AreaService areaService;
    private RequirementService requirementService;
    private TechnologyService technologyService;
    private LevelService levelService;
    private LevelTypeService levelTypeService;
    private UserService userService;
    private ApplicationService applicationService;
    private ChannelService channelService;
    private CompanyService companyService;
    private ServiceTypeService serviceTypeService;
    private ProgramIncrementTypeService programIncrementTypeService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addRequirement(Model model) {
        model.addAttribute("requirement", new Requirement());
        return NEW_REQUIREMENT;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveRequirement(@ModelAttribute("requirement") Requirement requirement) {
        LOGGER.info("Saving requirement");
        requirementService.saveRequirement(requirement);
        return EDIT_REQUIREMENT;
    }

    @RequestMapping(value = "/{requirementId}", method = RequestMethod.GET)
    public String getOneRequirement(Model model, @PathVariable(required = false) Integer requirementId) {
        LOGGER.info("Find one element" + requirementId);
        if (null != requirementId) {
            Requirement requirement = requirementService.findOneRequirement(requirementId);
            model.addAttribute("requirement", requirement);
        } else {
            model.addAttribute("requirement", new Requirement());
        }
        return EDIT_REQUIREMENT;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllRequirements(Model model) {
        List<Requirement> requirements = requirementService.findAllRequirements();
        model.addAttribute("requirements", requirements);
        return SEARCH_REQUIREMENTS;
    }

    // Model Attributes will available to the view all the time
    // TODO Only return id + name for the drop down list
    @ModelAttribute("levels")
    public List<Level> populateLevels() {
        return this.levelService.findAllLevels();
    }

    @ModelAttribute("levelTypes")
    public List<LevelType> populateLevelTypes() {
        return this.levelTypeService.findAllLevelTypes();
    }

    @ModelAttribute("areas")
    public List<Area> populateAreas() {
        return this.areaService.findAllAreas();
    }

    @ModelAttribute("technologies")
    public List<Technology> populateTechnologies() {
        return this.technologyService.findAllTechnologies();
    }

    @ModelAttribute("users")
    public List<User> populateUsers() {
        return this.userService.findAllUsers();
    }

    @ModelAttribute("applications")
    public List<Application> populateApplications() {
        return this.applicationService.findAllApplications();
    }

    @ModelAttribute("channels")
    public List<Channel> populateChannels() {
        return this.channelService.findAllChannels();
    }

    @ModelAttribute("companies")
    public List<Company> populateCompanies() {
        return this.companyService.findAllCompanies();
    }

    @ModelAttribute("serviceTypes")
    public List<ServiceType> populateServiceTypes() {
        return this.serviceTypeService.findAllServiceTypes();
    }

    @ModelAttribute("programIncrementTypes")
    public List<ProgramIncrementType> populateProgramIncrementTypes() {
        return this.programIncrementTypeService.findAll();
    }

    // Import services
    @Autowired
    public void setAreaService(AreaService areaService) {
        this.areaService = areaService;
    }

    @Autowired
    public void setRequirementService(RequirementService requirementService) {
        this.requirementService = requirementService;
    }

    @Autowired
    public void setTechnologyService(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @Autowired
    public void setLevelService(LevelService levelService) {
        this.levelService = levelService;
    }

    @Autowired
    public void setLevelTypeService(LevelTypeService levelTypeService) {
        this.levelTypeService = levelTypeService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setApplicationService(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @Autowired
    public void setChannelService(ChannelService channelService) {
        this.channelService = channelService;
    }

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Autowired
    public void setServiceTypeService(ServiceTypeService serviceTypeService) {
        this.serviceTypeService = serviceTypeService;
    }

    @Autowired
    public void setProgramIncrementTypeService(ProgramIncrementTypeService programIncrementTypeService) {
        this.programIncrementTypeService = programIncrementTypeService;
    }
}
