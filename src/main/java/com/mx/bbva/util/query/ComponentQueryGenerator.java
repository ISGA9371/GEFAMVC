package com.mx.bbva.util.query;

import java.util.Map;
import java.util.logging.Logger;

public class ComponentQueryGenerator {
    private static final Logger LOG = Logger.getLogger(ComponentQueryGenerator.class.getName());
    private StringBuffer stringBuffer = new StringBuffer();
    private boolean firstOne = true;

    public String generateQuery(Map<String, String> componentSearchDTO) {
        // TODO This solution SUCKS
        LOG.info("Creating query for Component...");
        final String EQUALS = " = ";
        final String LIKE = " LIKE ";

        stringBuffer.append("FROM Component x ");

        if (componentSearchDTO.containsKey("componentName") && !componentSearchDTO.get("componentName").isEmpty()) {
            addFilter("x.componentName", "'%" + componentSearchDTO.get("componentName") + "%'", LIKE);
        }
        if (componentSearchDTO.containsKey("requirementName") && !componentSearchDTO.get("requirementName").isEmpty()) {
            addFilter("x.requirement.requirementName", "'%" + componentSearchDTO.get("requirementName") + "%'", LIKE);
        }
        if (componentSearchDTO.containsKey("componentVersion") && !componentSearchDTO.get("componentVersion").isEmpty()) {
            addFilter("x.componentVersion", "'%" + componentSearchDTO.get("componentVersion") + "%'", LIKE);
        }
        if (componentSearchDTO.containsKey("subPrincipalId") && !componentSearchDTO.get("subPrincipalId").isEmpty()) {
            addFilter("x.requirement.level.levelId", "'" + componentSearchDTO.get("subPrincipalId") + "'", EQUALS);
        }
        if (componentSearchDTO.containsKey("companyId") && !componentSearchDTO.get("companyId").isEmpty()) {
            addFilter("x.requirement.company.companyId", "'%" + componentSearchDTO.get("companyId") + "%'", EQUALS);
        }
        if (componentSearchDTO.containsKey("technologyId") && !componentSearchDTO.get("technologyId").isEmpty()) {
            addFilter("x.requirement.technology.technologyId", "'%" + componentSearchDTO.get("technologyId") + "%'", EQUALS);
        }
        if (componentSearchDTO.containsKey("typologyComponentModified") && !componentSearchDTO.get("typologyComponentModified").isEmpty()) {
            addFilter("x.typology.typologyComponentModified", componentSearchDTO.get("typologyComponentModified"), EQUALS);
        }
        if (componentSearchDTO.containsKey("statusId") && !componentSearchDTO.get("statusId").isEmpty()) {
            addFilter("x.status.statusId", "'" + componentSearchDTO.get("statusId") + "'", LIKE);
        }
        if (componentSearchDTO.containsKey("componentDesignRealDeliverDate") && !componentSearchDTO.get("componentDesignRealDeliverDate").isEmpty()) {
            addFilter("x.componentDesignRealDeliverDate", "'%" + componentSearchDTO.get("componentDesignRealDeliverDate") + "%'", LIKE);
        }
        if (componentSearchDTO.containsKey("componentPreviewDeliverDate") && !componentSearchDTO.get("componentPreviewDeliverDate").isEmpty()) {
            addFilter("x.componentPreviewDeliverDate", "'%" + componentSearchDTO.get("componentPreviewDeliverDate") + "%'", LIKE);
        }
        if (componentSearchDTO.containsKey("componentPossibleDeliverDate") && !componentSearchDTO.get("componentPossibleDeliverDate").isEmpty()) {
            addFilter("x.componentPossibleDeliverDate", "'%" + componentSearchDTO.get("componentPossibleDeliverDate") + "%'", LIKE);
        }
        if (componentSearchDTO.containsKey("componentRealDeliverDate") && !componentSearchDTO.get("componentRealDeliverDate").isEmpty()) {
            addFilter("x.componentRealDeliverDate", "'%" + componentSearchDTO.get("componentRealDeliverDate") + "%'", LIKE);
        }
        if (componentSearchDTO.containsKey("startProductId") && !componentSearchDTO.get("startProductId").isEmpty()) {
            addFilter("x.startTypology.product.productId", "'%" + componentSearchDTO.get("startProductId") + "%'", LIKE);
        }
        if (componentSearchDTO.containsKey("typologyStartSeverity") && !componentSearchDTO.get("typologyStartSeverity").isEmpty()) {
            addFilter("x.startTypology.typologySeverity", "'" + componentSearchDTO.get("typologyStartSeverity") + "'", EQUALS);
        }
        if (componentSearchDTO.containsKey("typologyStartSeverityHours") && !componentSearchDTO.get("typologyStartSeverityHours").isEmpty()) {
            addFilter("x.startTypology.typologySeverityHours", "'" + componentSearchDTO.get("typologyStartSeverityHours") + "'", EQUALS);
        }
        if (componentSearchDTO.containsKey("finalProductId") && !componentSearchDTO.get("finalProductId").isEmpty()) {
            addFilter("x.finalTypology.product.productId", "'%" + componentSearchDTO.get("startProductId") + "%'", LIKE);
        }
        if (componentSearchDTO.containsKey("typologyFinalSeverity") && !componentSearchDTO.get("typologyFinalSeverity").isEmpty()) {
            addFilter("x.finalTypology.typologySeverity", "'" + componentSearchDTO.get("typologyStartSeverity") + "'", EQUALS);
        }
        if (componentSearchDTO.containsKey("typologyFinalSeverityHours") && !componentSearchDTO.get("typologyFinalSeverityHours").isEmpty()) {
            addFilter("x.finalTypology.typologySeverityHours", "'" + componentSearchDTO.get("typologyFinalSeverityHours") + "'", EQUALS);
        }
        if (componentSearchDTO.containsKey("statusTypologyId") && !componentSearchDTO.get("statusTypologyId").isEmpty()) {
            addFilter("x.statusTypology.statusId", "'" + componentSearchDTO.get("statusTypologyId") + "'", EQUALS);
        }
        LOG.info("Query made: " + stringBuffer.toString());
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
}
