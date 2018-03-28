package com.mx.bbva.controller;


import com.mx.bbva.business.entity.*;
import com.mx.bbva.business.service.*;
import com.mx.bbva.to.RequirementSearchTO;
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
    private ProgramIncrementService programIncrementTypeService;
    private MethodologyService methodologyService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addRequirement(Model model) {
        model.addAttribute("requirement", new Requirement());
        return URL_FACTORY + NEW_REQUIREMENT;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveRequirement(@ModelAttribute("requirement") Requirement requirement) {
        LOGGER.info("Saving requirement");
        requirementService.saveRequirement(requirement);
        return URL_FACTORY + EDIT_REQUIREMENT;
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
        //List<Requirement> requirements = requirementService.findAllRequirements();
        //model.addAttribute("requirements", requirements);
        RequirementSearchTO to = new RequirementSearchTO();

        List<Level> c = this.levelService.findByLevelSuperior(2);
        LOGGER.info("SUPEROIOr "+c.size());
        model.addAttribute("criteria",to);
        return URL_FACTORY + SEARCH_REQUIREMENTS;
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public String findRequirements(Model model,@ModelAttribute(value="criteria") RequirementSearchTO criteria) {
        LOGGER.info("Find requirements by selected criteria");

        LOGGER.info("Criteria "+criteria);
        //List<Requirement> requirements = requirementService.findAllRequirements();
        //model.addAttribute("requirements", requirements);
        return "redirect:/requirements";
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
        LOGGER.info(this.levelService.findByLevelType(new LevelType(2)).get(2).getLevelSuperior()+"");

        return this.levelService.findByLevelType(new LevelType(2));
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
        return this.companyService.findAllCompaniesForDropDownList();
    }

    @ModelAttribute("serviceTypes")
    public List<ServiceType> populateServiceTypes() {
        return this.serviceTypeService.findAllServiceTypes();
    }

 //   @ModelAttribute("programIncrements")
 //   public List<ProgramIncrement> populateProgramIncrements() {
 //       return this.programIncrementTypeService.findAll();
 //   }
    @ModelAttribute("methodologies")
    public List<Methodology> populateMethodologies() {
        return this.methodologyService.findAllMethodologies();
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

    //@Autowired
    //public void setProgramIncrementService(ProgramIncrementService programIncrementTypeService) {
    //    this.programIncrementTypeService = programIncrementTypeService;
    //}

    @Autowired
    public void setMethodologyService(MethodologyService methodologyService){
        this.methodologyService = methodologyService;
    }
}
