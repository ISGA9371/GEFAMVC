package com.mx.bbva.util.query;

import com.mx.bbva.business.dto.ComponentSearchDTO;
import com.mx.bbva.business.dto.RequirementSearchDTO;

import java.util.logging.Logger;

public class QueryGenerator {
    private static final Logger LOGGER = Logger.getLogger(QueryGenerator.class.getName());
    private StringBuffer stringBuffer = new StringBuffer();
    private boolean firstOne = true;

    // TODO should be a better way to do this
    public String generate(Object searchDTO, String type) {
        LOGGER.info("Creating query...");
        switch (type) {
            case "Requirement":
                RequirementSearchDTO requirementSearchDTO = (RequirementSearchDTO) searchDTO;
                stringBuffer.append("SELECT NEW com.mx.bbva.business.entity.Requirement(" +
                        "x.requirementId, x.requirementName, x.level, x.user, x.area, x.serviceType, x.technology, " +
                        "x.company, x.requirementStartDate, x.requirementEndDate) " +
                        " FROM Requirement x ");
                if (null != requirementSearchDTO.getRequirementName()) {
                    addFilter("x.requirementName", requirementSearchDTO.getRequirementName());
                }
                if (null != requirementSearchDTO.getPrincipalId()) {
                    addFilter("x.level.levelId", String.valueOf(requirementSearchDTO.getPrincipalId()));
                }
                if (null != requirementSearchDTO.getUserInternalId()) {
                    addFilter("x.user.userInternalId", requirementSearchDTO.getUserInternalId());
                }
                if (null != requirementSearchDTO.getAreaId()) {
                    addFilter("x.area.areaId", String.valueOf(requirementSearchDTO.getAreaId()));
                }
                if (null != requirementSearchDTO.getProjectTypeId()) {
                    addFilter("x.projectType.projectTypeId", String.valueOf(requirementSearchDTO.getProjectTypeId()));
                }
                if (null != requirementSearchDTO.getTechnologyId()) {
                    addFilter("x.technology.technologyId", String.valueOf(requirementSearchDTO.getTechnologyId()));
                }
                if (null != requirementSearchDTO.getCompanyId()) {
                    addFilter("x.company.companyId", String.valueOf(requirementSearchDTO.getCompanyId()));
                }
                if (null != requirementSearchDTO.getServiceTypeId()) {
                    addFilter("x.serviceType.serviceTypeId", String.valueOf(requirementSearchDTO.getServiceTypeId()));
                }
                if (null != requirementSearchDTO.getBudgetId()) {
                    addFilter("x.budget.budgetId", String.valueOf(requirementSearchDTO.getBudgetId()));
                }
                if (null != requirementSearchDTO.getRequirementStartDate()) {
                    addFilter("x.requirementStartDate", requirementSearchDTO.getRequirementStartDate());
                }
                if (null != requirementSearchDTO.getRequirementEndDate()) {
                    addFilter("x.requirementEndDate", requirementSearchDTO.getRequirementEndDate());
                }
                break;
            case "Component":
                ComponentSearchDTO componentSearchDTO = (ComponentSearchDTO) searchDTO;
                stringBuffer.append("SELECT NEW com.mx.bbva.business.entity.Component(" +
                        "x.componentId, x.componentName, x.level, x.user, x.area, x.serviceType, x.technology, " +
                        "x.company, x.componentStartDate, x.componentEndDate) " +
                        " FROM Component x ");
                if (null != componentSearchDTO.getComponentName()) {
                    addFilter("x.componentName", componentSearchDTO.getComponentName());
                }
                if (null != componentSearchDTO.getComponentVersion()) {
                    addFilter("x.componentVersion", componentSearchDTO.getComponentVersion());
                }
                if (null != componentSearchDTO.getRequirementName()) {
                    addFilter("x.requirement.requirementName", componentSearchDTO.getRequirementName());
                }
                if (null != componentSearchDTO.getPrincipalId()) {
                    addFilter("x.requirement.level.levelId", String.valueOf(componentSearchDTO.getPrincipalId()));
                }
                if (null != componentSearchDTO.getCompanyId()) {
                    addFilter("x.company.companyId", String.valueOf(componentSearchDTO.getCompanyId()));
                }
                if (null != componentSearchDTO.getStatusId()) {
                    addFilter("x.status.statusId", componentSearchDTO.getStatusId().toString());
                }
                /*if (null != componentSearchDTO.getSubPrincipalId()) {
                    addFilter("", componentSearchDTO.getSubPrincipalId().toString());
                }*/
                if (null != componentSearchDTO.getTechnologyId()) {
                    addFilter("x.technology.technologyId", componentSearchDTO.getTechnologyId().toString());
                }
                break;
        }

        LOGGER.info("Query made : " + stringBuffer.toString());
        return stringBuffer.toString();
    }

    private void addFilter(String filter, String value) {
        if (firstOne) {
            stringBuffer.append(" WHERE ");
            firstOne = false;
        } else {
            stringBuffer.append(" AND ");
        }
        stringBuffer.append(filter).append(" = ").append(value);
    }
}
