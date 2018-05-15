package com.mx.bbva.util.query;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class InvoiceQueryGenerator {

    private static final Logger LOG = Logger.getLogger(InvoiceQueryGenerator.class.getName());
    private StringBuffer stringBuffer = new StringBuffer();
    private boolean firstOne = true;
    private final String EQUALS = " = ";
    private final String LIKE = " LIKE ";
    private final String BETWEEN = " BETWEEN ";
    private Map<String, List<String>> items = new HashMap<>();

    public String generateQuery(Map<String, String> searchDTO) {
        LOG.info("Creating query for Invoice...");
        fillValues();
        stringBuffer.append("FROM Invoice x ");

        // TODO transfer date between two dates
        searchDTO.forEach(this::newFilter);

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
        } else if (operator.equals(BETWEEN)) {
            stringBuffer.append(BETWEEN).append("'").append(value).append("'");
        }else {
            stringBuffer.append(" AND ");
        }
        stringBuffer.append(filter).append(operator);

        if (operator.equals(LIKE)) {
            stringBuffer.append("'%").append(value).append("%'");
        } else if (operator.equals(EQUALS)) {
            stringBuffer.append("'").append(value).append("'");
        }
    }

    private void fillValues() {
        items.put("invoiceCutDate", Arrays.asList("x.invoiceCutDate", EQUALS));
        items.put("budgetId", Arrays.asList("x.budgetRequirement.budget.budgetId", EQUALS));
        items.put("levelId", Arrays.asList("x.requirement.level.levelId", EQUALS));
        items.put("budgetStatusId", Arrays.asList("x.statusBudget.budgetId", LIKE));
        items.put("requirementName", Arrays.asList("x.requirement.requirementName", LIKE));
        items.put("statusId", Arrays.asList("x.status.statusId", EQUALS));
        items.put("invoiceCutDateFrom", Arrays.asList("x.invoiceCutDate", BETWEEN));
        items.put("invoiceCutDateTo", Arrays.asList("x.invoiceCutDate", EQUALS));
        items.put("budgetsApplicantName", Arrays.asList("x.budgetRequirement.budget.budgetsApplicant.budgetsApplicantName", LIKE));
        items.put("invoiceSendDate", Arrays.asList("x.invoiceSendDate", EQUALS));
    }
}