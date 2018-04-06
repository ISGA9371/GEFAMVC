package com.mx.bbva.util.query;

import com.mx.bbva.business.dto.ComponentSearchDTO;
import com.mx.bbva.business.dto.RequirementSearchDTO;

import java.util.logging.Logger;

public class QueryGenerator {
    private static final Logger LOGGER = Logger.getLogger(QueryGenerator.class.getName());
    private StringBuffer stringBuffer = new StringBuffer();
    private boolean firstOne = true;
    private final String EQUALS = " = ";
    private final String LIKE = " LIKE ";

    // TODO should be a better way to do this
    public String generate(Object searchDTO, String type) {
        LOGGER.info("Creating query...");
        switch (type) {
            case "Requirement":
                RequirementSearchDTO requirementSearchDTO = (RequirementSearchDTO) searchDTO;
                stringBuffer.append("SELECT NEW com.mx.bbva.business.entity.Requirement(" +
                        "x.requirementId, x.requirementName, x.requirementHour, x.requirementTotalHours, x.requirementBilledHours, " +
                        "x.requirementNoBilledHours, x.requirementBilled, x.requirementDateUpload, x.requirementCanBilled, " +
                        "x.requirementStartDate, x.requirementEndDate, x.userManager, x.technology, x.company, x.status, " +
                        "x.level, x.user, x.application, x.project, x.area, x.methodology, x.serviceType, x.channel, " +
                        "x.programIncrement) " +
                        " FROM Requirement x ");
                if (isNotNullString(requirementSearchDTO.getRequirementName())) {
                    addFilter("x.requirementName", "'%" + requirementSearchDTO.getRequirementName() + "%'", LIKE);
                }
                if (isNotNullInteger(requirementSearchDTO.getPrincipalId())) {
                    addFilter("x.level.levelId", "'" + requirementSearchDTO.getPrincipalId() + "'", EQUALS);
                }
                if (isNotNullString(requirementSearchDTO.getUserInternalId())) {
                    addFilter("x.user.userInternalId", "'%" + requirementSearchDTO.getUserInternalId() + "%'", LIKE);
                }
                if (isNotNullInteger(requirementSearchDTO.getAreaId())) {
                    addFilter("x.area.areaId", "'" + requirementSearchDTO.getAreaId() + "'", EQUALS);
                }
                /*
                if (requirementSearchDTO.getProjectTypeId() != null && !requirementSearchDTO.getPrincipalId().equals(0)) {
                    addFilter("x.projectType.projectTypeId", requirementSearchDTO.getProjectTypeId()));
                }
                if (requirementSearchDTO.getTechnologyId() != null && !requirementSearchDTO.getPrincipalId().equals(0)) {
                    addFilter("x.technology.technologyId", requirementSearchDTO.getTechnologyId()));
                }
                if (requirementSearchDTO.getCompanyId() != null && !requirementSearchDTO.getPrincipalId().equals(0)) {
                    addFilter("x.company.companyId", requirementSearchDTO.getCompanyId()));
                }
                if (requirementSearchDTO.getServiceTypeId() != null && !requirementSearchDTO.getPrincipalId().equals(0)) {
                    addFilter("x.serviceType.serviceTypeId", requirementSearchDTO.getServiceTypeId()));
                }
                if (requirementSearchDTO.getBudgetId() != null) {
                    addFilter("x.budget.budgetId", requirementSearchDTO.getBudgetId()));
                }
                if (requirementSearchDTO.getRequirementStartDate() != null) {
                    addFilter("x.requirementStartDate", requirementSearchDTO.getRequirementStartDate());
                }
                if (requirementSearchDTO.getRequirementEndDate() != null) {
                    addFilter("x.requirementEndDate", requirementSearchDTO.getRequirementEndDate());
                }*/
                break;
            case "Component":
                ComponentSearchDTO componentSearchDTO = (ComponentSearchDTO) searchDTO;
                stringBuffer.append("SELECT NEW com.mx.bbva.business.entity.Component(" +
                        "x.componentId, x.componentName, x.level, x.user, x.area, x.serviceType, x.technology, " +
                        "x.company, x.componentStartDate, x.componentEndDate) " +
                        " FROM Component x ");
                /*if (componentSearchDTO.getComponentName() != null) {
                    addFilter("x.componentName", componentSearchDTO.getComponentName());
                }
                if (componentSearchDTO.getComponentVersion() != null) {
                    addFilter("x.componentVersion", componentSearchDTO.getComponentVersion());
                }
                if (componentSearchDTO.getRequirementName() != null) {
                    addFilter("x.requirement.requirementName", componentSearchDTO.getRequirementName());
                }
                if (componentSearchDTO.getPrincipalId() != null) {
                    addFilter("x.requirement.level.levelId", componentSearchDTO.getPrincipalId()));
                }
                if (componentSearchDTO.getCompanyId() != null) {
                    addFilter("x.company.companyId", componentSearchDTO.getCompanyId()));
                }
                if (componentSearchDTO.getStatusId() != null) {
                    addFilter("x.status.statusId", componentSearchDTO.getStatusId().toString());
                }
                if (componentSearchDTO.getSubPrincipalId()) {
                    addFilter("", componentSearchDTO.getSubPrincipalId().toString());
                }
                if (componentSearchDTO.getTechnologyId() != null) {
                    addFilter("x.technology.technologyId", componentSearchDTO.getTechnologyId().toString());
                }*/
                break;
        }

        LOGGER.info("Query made : " + stringBuffer.toString());
        return stringBuffer.toString();
    }

    private void addFilter(String filter, String value, String operator) {
        if (firstOne) {
            stringBuffer.append(" WHERE ");
            firstOne = false;
        } else {
            stringBuffer.append(" OR ");
        }
        stringBuffer.append(filter).append(operator).append(value);
    }

    private boolean isNotNullString(String value) {
        return value != null && !value.isEmpty();
    }

    private boolean isNotNullInteger(Integer value) {
        return value != null && !value.equals(0);
    }
}
