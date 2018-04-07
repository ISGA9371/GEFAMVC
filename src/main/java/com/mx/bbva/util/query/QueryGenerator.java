package com.mx.bbva.util.query;

import com.mx.bbva.business.dto.ComponentSearchDTO;
import com.mx.bbva.business.dto.RequirementSearchDTO;

import java.util.logging.Logger;

public class QueryGenerator {
    static final Logger LOGGER = Logger.getLogger(QueryGenerator.class.getName());
    StringBuffer stringBuffer = new StringBuffer();
    boolean firstOne = true;

    // TODO should be a better way to do this
    public String generate(Object searchDTO, String type) {
        LOGGER.info("Creating query...");
        final String EQUALS = " = ";
        final String LIKE = " LIKE ";

        switch (type) {
            case "Requirement":
                RequirementSearchDTO requirementSearchDTO = (RequirementSearchDTO) searchDTO;
                stringBuffer.append("FROM Requirement x ");
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
                if (isNotNullInteger(requirementSearchDTO.getProjectTypeId())) {
                    addFilter("x.projectType.projectTypeId", "'" + requirementSearchDTO.getProjectTypeId() + "'", EQUALS);
                }
                if (isNotNullInteger(requirementSearchDTO.getTechnologyId())) {
                    addFilter("x.technology.technologyId", "'" + requirementSearchDTO.getTechnologyId(), EQUALS);
                }
                if (isNotNullInteger(requirementSearchDTO.getCompanyId())) {
                    addFilter("x.company.companyId", "'" + requirementSearchDTO.getCompanyId() + "'", EQUALS);
                }
                if (isNotNullInteger(requirementSearchDTO.getServiceTypeId())) {
                    addFilter("x.serviceType.serviceTypeId", "'" + requirementSearchDTO.getServiceTypeId() + "'", EQUALS);
                }
                if (isNotNullString(requirementSearchDTO.getBudgetId())) {
                    addFilter("x.budget.budgetId", "'%" + requirementSearchDTO.getBudgetId() + "%'", LIKE);
                }
                if (isNotNullString(requirementSearchDTO.getRequirementStartDate())) {
                    addFilter("x.requirementStartDate", "'%" + requirementSearchDTO.getRequirementStartDate() + "%'", LIKE);
                }
                if (isNotNullString(requirementSearchDTO.getRequirementEndDate())) {
                    addFilter("x.requirementEndDate", "'%" + requirementSearchDTO.getRequirementEndDate() + "%'", LIKE);
                }
                break;
            case "Component":
                ComponentSearchDTO componentSearchDTO = (ComponentSearchDTO) searchDTO;
                stringBuffer.append("FROM Component x ");
                if (isNotNullString(componentSearchDTO.getComponentName())) {
                    addFilter("x.componentName", "%" + componentSearchDTO.getComponentName() + "%", LIKE);
                }
                if (isNotNullString(componentSearchDTO.getRequirementName())) {
                    addFilter("x.requirement.requirementName", "%" + componentSearchDTO.getRequirementName() + "%", LIKE);
                }
                if (isNotNullString(componentSearchDTO.getComponentVersion())) {
                    addFilter("x.componentVersion", "%" + componentSearchDTO.getComponentVersion() + "%", LIKE);
                }
                if (isNotNullInteger(componentSearchDTO.getPrincipalId())) {
                    addFilter("x.requirement.level.levelId", "'" + componentSearchDTO.getPrincipalId() + "'", EQUALS);
                }
                /*
                if (isNotNullInteger(componentSearchDTO.getSubPrincipalId())) {
                    addFilter("x.subPrincipal.levelId", "'" + componentSearchDTO.getSubPrincipalId() + "'", EQUALS);
                }*/
                if (isNotNullInteger(componentSearchDTO.getCompanyId())) {
                    addFilter("x.requirement.company.companyId", "%" + componentSearchDTO.getCompanyId() + "%", EQUALS);
                }
                if (isNotNullInteger(componentSearchDTO.getTechnologyId())) {
                    addFilter("x.requirement.technology.technologyId", "%" + componentSearchDTO.getTechnologyId() + "%", EQUALS);
                }
                /* TODO Boolean
                if (isNotNullString(componentSearchDTO.isTypologyNewComponent())) {
                    addFilter("", "%" + someValue + "%", LIKE);
                }*/
                if (isNotNullInteger(componentSearchDTO.getStatusId())) {
                    addFilter("x.status.statusId", "'" + componentSearchDTO.getStatusId() + "'", LIKE);
                }
                /* TODO DATE
                if (isNotNullString(componentSearchDTO.getComponentDesignRealDeliverDate())) {
                    addFilter("", "%" + someValue + "%", LIKE);
                }
                if (isNotNullString(componentSearchDTO.getComponentPreviewDeliverDate())) {
                    addFilter("", "%" + someValue + "%", LIKE);
                }
                if (isNotNullString(componentSearchDTO.getComponentPossibleDeliverDate())) {
                    addFilter("", "%" + someValue + "%", LIKE);
                }
                if (isNotNullString(componentSearchDTO.getComponentRealDeliverDate())) {
                    addFilter("", "%" + someValue + "%", LIKE);
                }
                if (isNotNullInteger(componentSearchDTO.getStartProductId())) {
                    addFilter("", "'" + componentSearchDTO.getStartProductId() + "'", EQUALS);
                }
                if (isNotNullInteger(componentSearchDTO.getFinalProductId())) {
                    addFilter("", "'" + componentSearchDTO.getFinalProductId() + "'", EQUALS);
                }
                if (isNotNullInteger(componentSearchDTO.getTypologyStartSeverity())) {
                    addFilter("", "'" + componentSearchDTO.getTypologyStartSeverity() + "'", EQUALS);
                } */
                /* TODO Long
                if (isNotNullString(componentSearchDTO.getTypologyStartSeverityHours())) {
                    addFilter("", "'" + someValue + "'", EQUALS);
                }
                if (isNotNullString(componentSearchDTO.getTypologyFinalSeverityHours())) {
                    addFilter("", "'" + someValue + "'", EQUALS);
                }*/
                if (isNotNullInteger(componentSearchDTO.getStatusTypologyId())) {
                    addFilter("x.statusTypology.statusId", "'" + componentSearchDTO.getStatusTypologyId() + "'", EQUALS);
                }
                //if (isNotNullInteger(componentSearchDTO.getTypologyFinalSeverity())) {
                //    addFilter("", "'" + componentSearchDTO.getTypologyFinalSeverity() + "'", EQUALS);
                //}
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
