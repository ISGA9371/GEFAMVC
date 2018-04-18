package com.mx.bbva.util.query;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ComponentQueryGenerator {
    private static final Logger LOG = Logger.getLogger(ComponentQueryGenerator.class.getName());
    private StringBuffer stringBuffer = new StringBuffer();
    private boolean firstOne = true;
    private final String EQUALS = " = ";
    private final String LIKE = " LIKE ";
    private Map<String, List<String>> items = new HashMap<>();

    public String generateQuery(Map<String, String> componentSearchDTO) {
        LOG.info("Creating query for Component...");
        fillComponentValues();
        stringBuffer.append("FROM Component x ");

        componentSearchDTO.forEach(this::newFilter);

        LOG.info("Query made: " + stringBuffer.toString());
        return stringBuffer.toString();
    }

    private void newFilter(String key, String value) {
        if (items.containsKey(key) && !value.isEmpty()) {
            List<String> componentValues = items.get(key);
            addFilter(componentValues.get(0), value, componentValues.get(1));
        }
    }

    private void addFilter(String filter, String value, String operator) {
        if (firstOne) {
            stringBuffer.append(" WHERE ");
            firstOne = false;
        } else {
            stringBuffer.append(" OR ");
        }
        stringBuffer.append(filter).append(operator);

        if (operator.equals(LIKE)) {
            stringBuffer.append("'%").append(value).append("%'");
        } else if (operator.equals(EQUALS)) {
            stringBuffer.append("'").append(value).append("'");
        }
    }

    private void fillComponentValues() {
        items.put("componentName", Arrays.asList("x.componentName", LIKE));
        items.put("componentVersion", Arrays.asList("x.componentVersion", LIKE));
        items.put("componentDesignRealDeliverDate", Arrays.asList("x.componentDesignRealDeliverDate", LIKE));
        items.put("componentPreviewDeliverDate", Arrays.asList("x.componentPreviewDeliverDate", LIKE));
        items.put("componentPossibleDeliverDate", Arrays.asList("x.componentPossibleDeliverDate", LIKE));
        items.put("componentRealDeliverDate", Arrays.asList("x.componentRealDeliverDate", LIKE));
        items.put("requirementName", Arrays.asList("x.requirement.requirementName", LIKE));
        items.put("subPrincipalId", Arrays.asList("x.requirement.level.levelId", EQUALS));
        items.put("companyId", Arrays.asList("x.requirement.company.companyId", EQUALS));
        items.put("technologyId", Arrays.asList("x.requirement.technology.technologyId", EQUALS));
        items.put("typologyComponentModified", Arrays.asList("x.typology.typologyComponentModified", EQUALS));
        items.put("statusId", Arrays.asList("x.status.statusId", EQUALS));
        items.put("startProductId", Arrays.asList("x.startTypology.product.productId", LIKE));
        items.put("typologyStartSeverity", Arrays.asList("x.startTypology.typologySeverity", EQUALS));
        items.put("typologyStartSeverityHours", Arrays.asList("x.startTypology.typologySeverityHours", EQUALS));
        items.put("finalProductId", Arrays.asList("x.finalTypology.product.productId", LIKE));
        items.put("typologyFinalSeverity", Arrays.asList("x.finalTypology.typologySeverity", EQUALS));
        items.put("typologyFinalSeverityHours", Arrays.asList("x.finalTypology.typologySeverityHours", EQUALS));
        items.put("statusTypologyId", Arrays.asList("x.statusTypology.statusId", EQUALS));
    }

}
