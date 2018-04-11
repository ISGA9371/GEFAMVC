package com.mx.bbva.util.query;

import com.mx.bbva.business.dto.ComponentSearchDTO;

import java.util.Date;
import java.util.Optional;
import java.util.logging.Logger;

public class ComponentQueryGenerator {
    private static final Logger LOG = Logger.getLogger(ComponentQueryGenerator.class.getName());
    private StringBuffer stringBuffer = new StringBuffer();
    private boolean firstOne = true;

    public String generateQuery(ComponentSearchDTO componentSearchDTO) {
        LOG.info("Creating query for Requirement...");
        final String EQUALS = " = ";
        final String LIKE = " LIKE ";

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
        /* TODO Check this value
        if (isNotNullInteger(componentSearchDTO.getSubPrincipalId())) {
            addFilter("x.subPrincipal.levelId", "'" + componentSearchDTO.getSubPrincipalId() + "'", EQUALS);
        } */
        if (isNotNullInteger(componentSearchDTO.getCompanyId())) {
            addFilter("x.requirement.company.companyId", "%" + componentSearchDTO.getCompanyId() + "%", EQUALS);
        }
        if (isNotNullInteger(componentSearchDTO.getTechnologyId())) {
            addFilter("x.requirement.technology.technologyId", "%" + componentSearchDTO.getTechnologyId() + "%", EQUALS);
        }
        if (componentSearchDTO.getTypologyNewComponent() != null) {
            addFilter("x.typology.typologyNewComponent", componentSearchDTO.getTypologyNewComponent().toString(), EQUALS);
        }
        if (isNotNullInteger(componentSearchDTO.getStatusId())) {
            addFilter("x.status.statusId", "'" + componentSearchDTO.getStatusId() + "'", LIKE);
        }

        if (isNotNullDate(componentSearchDTO.getComponentDesignRealDeliverDate())) {
            addFilter("x.componentDesignRealDeliverDate",
                    "%" + componentSearchDTO.getComponentDesignRealDeliverDate() + "%", LIKE);
        }

        /*
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
        }  */
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

    private boolean isNotNullDate(Date value) {
        Optional<Date> finalDate = Optional.ofNullable(value);
        return finalDate.isPresent();
    }
}
