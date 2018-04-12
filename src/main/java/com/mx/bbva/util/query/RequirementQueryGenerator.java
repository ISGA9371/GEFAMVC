package com.mx.bbva.util.query;

import com.mx.bbva.business.dto.RequirementSearchDTO;

import java.util.logging.Logger;

public class RequirementQueryGenerator {
    private static final Logger LOG = Logger.getLogger(RequirementQueryGenerator.class.getName());
    private StringBuffer stringBuffer = new StringBuffer();
    private boolean firstOne = true;

    public String generateQuery(RequirementSearchDTO searchDTO) {
        LOG.info("Creating query for Requirement...");
        final String EQUALS = " = ";
        final String LIKE = " LIKE ";

        stringBuffer.append("FROM Requirement x ");
        // TODO Check how to search the budget
        /*
        if (isNotNullString(searchDTO.getBudgetId())) {
            addFilter("br.budget.budgetId", "'%" + searchDTO.getBudgetId() + "%'", LIKE);
        }*/
        if (isNotNullString(searchDTO.getRequirementName())) {
            addFilter("x.requirementName", "'%" + searchDTO.getRequirementName() + "%'", LIKE);
        }
        if (isNotNullInteger(searchDTO.getPrincipalId())) {
            addFilter("x.level.levelId", "'" + searchDTO.getPrincipalId() + "'", EQUALS);
        }
        if (isNotNullString(searchDTO.getUserInternalId())) {
            addFilter("x.user.userInternalId", "'%" + searchDTO.getUserInternalId() + "%'", LIKE);
        }
        if (isNotNullString(searchDTO.getUserManagerId())) {
            addFilter("x.userManager.userInternalId", "'%" + searchDTO.getUserInternalId() + "%'", LIKE);
        }
        if (isNotNullInteger(searchDTO.getAreaId())) {
            addFilter("x.area.areaId", "'" + searchDTO.getAreaId() + "'", EQUALS);
        }
        if (isNotNullInteger(searchDTO.getProgramIncrementId())) {
            addFilter("x.programIncrement.programIncrementId", "'" + searchDTO.getProgramIncrementId() + "'", EQUALS);
        }
        if (isNotNullInteger(searchDTO.getChannelId())) {
            addFilter("x.channel.channelId", "'" + searchDTO.getChannelId() + "'", EQUALS);
        }
        if (isNotNullInteger(searchDTO.getApplicationId())) {
            addFilter("x.application.applicationId", "'" + searchDTO.getApplicationId() + "'", EQUALS);
        }
        if (isNotNullInteger(searchDTO.getProjectTypeId())) {
            addFilter("x.projectType.projectTypeId", "'" + searchDTO.getProjectTypeId() + "'", EQUALS);
        }
        if (isNotNullInteger(searchDTO.getTechnologyId())) {
            addFilter("x.technology.technologyId", "'" + searchDTO.getTechnologyId() + "'", EQUALS);
        }
        if (isNotNullInteger(searchDTO.getCompanyId())) {
            addFilter("x.company.companyId", "'" + searchDTO.getCompanyId() + "'", EQUALS);
        }
        if (isNotNullInteger(searchDTO.getServiceTypeId())) {
            addFilter("x.serviceType.serviceTypeId", "'" + searchDTO.getServiceTypeId() + "'", EQUALS);
        }
        if (isNotNullString(searchDTO.getRequirementStartDate())) {
            addFilter("x.requirementStartDate", "'%" + searchDTO.getRequirementStartDate() + "%'", LIKE);
        }
        if (isNotNullString(searchDTO.getRequirementEndDate())) {
            addFilter("x.requirementEndDate", "'%" + searchDTO.getRequirementEndDate() + "%'", LIKE);
        }
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
