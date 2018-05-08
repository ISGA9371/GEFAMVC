package com.mx.bbva.util.query;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class BudgetQueryGenerator {

    private static final Logger LOG = Logger.getLogger(BudgetQueryGenerator.class.getName());
    private StringBuffer stringBuffer = new StringBuffer();
    private boolean firstOne = true;
    private final String EQUALS = " = ";
    private final String LIKE = " LIKE ";
    private Map<String, List<String>> items = new HashMap<>();

    public String generateQuery(Map<String, String> searchDTO) {
        LOG.info("Creating query for Budget...");
        fillValues();
        stringBuffer.append("FROM Budget x ");

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
        } else {
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
        items.put("budgetId", Arrays.asList("x.budgetId", LIKE));
        items.put("budgetName", Arrays.asList("x.budgetName", LIKE));
        items.put("budgetYear", Arrays.asList("x.budgetYear", EQUALS));
        items.put("budgetCostCenter", Arrays.asList("x.budgetCostCenter", LIKE));
        items.put("areaId", Arrays.asList("x.area.areaId", EQUALS));
        items.put("bankingId", Arrays.asList("x.banking.bankingId", EQUALS));
        items.put("corporationId", Arrays.asList("x.corporation.corporationId", EQUALS));
        items.put("userReceiverId", Arrays.asList("x.userReceiver.userInternalId", LIKE));
        items.put("natureId", Arrays.asList("x.nature.natureId", EQUALS));
    }
}
