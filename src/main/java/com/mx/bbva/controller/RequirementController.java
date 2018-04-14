package com.mx.bbva.controller;


import com.mx.bbva.business.dto.RequirementSearchDTO;
import com.mx.bbva.business.dto.ResponseDTO;
import com.mx.bbva.business.entity.*;
import com.mx.bbva.business.service.*;
import com.mx.bbva.util.query.RequirementQueryGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private MethodologyService methodologyService;
    private ProgramIncrementService programIncrementService;
    private StatusService statusService;
    private ProjectService projectService;
    private FareService fareService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addRequirement(Model model) {
        model.addAttribute("requirement", new Requirement());
        return URL_FACTORY + NEW_REQUIREMENT;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveRequirement(Model model, @ModelAttribute("requirement") Requirement requirement) {
        // TODO Validate XMY from the request
        LOGGER.info("Saving requirement");
        requirementService.saveRequirement(requirement);
        Requirement requirementSaved = requirementService.findOneRequirement(requirement.getRequirementId());
        model.addAttribute("requirement", requirementSaved);
        return REDIRECT + "requirements/" + requirement.getRequirementId();
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
        return URL_FACTORY + EDIT_REQUIREMENT;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllRequirements(Model model) {
        LOGGER.info("find requirements view");
        List<Requirement> requirements = requirementService.findAllRequirements();
        model.addAttribute("requirements", requirements);
        RequirementSearchDTO to = new RequirementSearchDTO();

        //List<Level> c = this.levelService.findByLevelSuperior(2);
        //LOGGER.info("SUPEROIOr " + c.size());
        model.addAttribute("criteria", to);
        return URL_FACTORY + SEARCH_REQUIREMENTS;
    }

    @RequestMapping(value = "/filters", method = RequestMethod.GET)
    public String filtersForRequirements(Model model) {
        model.addAttribute("requirementSearchDTO", new RequirementSearchDTO());
        return URL_FACTORY + SEARCH_REQUIREMENTS;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchForRequirements(@ModelAttribute("requirementSearchDTO") RequirementSearchDTO requirementSearchDTO, Model model) {
        // TODO Work in progress
        String query = new RequirementQueryGenerator().generateQuery(requirementSearchDTO);
        List<Requirement> requirements = requirementService.findByCustomQuery(query);
        model.addAttribute("requirements", requirements);
        return URL_FACTORY + SEARCH_REQUIREMENTS;
    }

    @RequestMapping(value = "/{requirementId}/fare", method = RequestMethod.GET)
    public ResponseEntity<?> findFareValue(@PathVariable Integer requirementId) {
        Requirement requirement = requirementService.findOneRequirement(requirementId);
        Double fareValue = fareService.findByRequirement(requirement);
        return new ResponseEntity<Object>(new ResponseDTO(fareValue), HttpStatus.OK);
    }

    // Model Attributes will available to the view all the time
    // TODO Only return id + name for the drop down list
    // LevelTypeId 1 - Direccion
    @ModelAttribute("principals")
    public List<Level> populatePrincipals() {
        return this.levelService.findByLevelType(new LevelType(1));
    }

    // LevelTypeId 2 - Sub-Direccion
    @ModelAttribute("subPrincipals")
    public List<Level> populateSubPrincipals() {
        LOGGER.info(this.levelService.findByLevelType(new LevelType(2)).get(2).getLevelSuperior() + "");

        return this.levelService.findByLevelType(new LevelType(2));
    }

    @ModelAttribute("areas")
    public List<Area> populateAreas() {
        return this.areaService.findAllAreas();
    }

    @ModelAttribute("statusList")
    public List<Status> populateStatusList() {
        return this.statusService.findAllStatus();
    }

    @ModelAttribute("statusListRequeriment")
    public List<Status> populateStatusListRequeriment() {
        return this.statusService.findStatusByType(new StatusType(7));
    }


    @ModelAttribute("technologies")
    public List<Technology> populateTechnologies() {
        return this.technologyService.findAllTechnologies();
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
        return this.companyService.findAllCompaniesForDropDownList();
    }

    @ModelAttribute("serviceTypes")
    public List<ServiceType> populateServiceTypes() {
        return this.serviceTypeService.findAllServiceTypes();
    }

    @ModelAttribute("programIncrements")
    public List<ProgramIncrement> populateProgramIncrements() {
        return this.programIncrementService.findAll();
    }

    @ModelAttribute("methodologies")
    public List<Methodology> populateMethodologies() {
        return this.methodologyService.findAllMethodologies();
    }

    //FALTA COMBO DE PROYECTOS TABLA 22
    @ModelAttribute("projects")
    public List<Project> populateProjects() {
        return this.projectService.findAllProjects();
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
    public void setMethodologyService(MethodologyService methodologyService) {
        this.methodologyService = methodologyService;
    }

    @Autowired
    public void setProgramIncrementService(ProgramIncrementService programIncrementService) {
        this.programIncrementService = programIncrementService;
    }

    @Autowired
    public void setStatusService(StatusService statusService) {
        this.statusService = statusService;
    }

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Autowired
    public void setFareService(FareService fareService) {
        this.fareService = fareService;
    }
}
