package com.mx.bbva.util.query;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class RequirementQueryGenerator {
    private static final Logger LOG = Logger.getLogger(RequirementQueryGenerator.class.getName());
    private StringBuffer stringBuffer = new StringBuffer();
    private boolean firstOne = true;
    private final String EQUALS = " = ";
    private final String LIKE = " LIKE ";
    private Map<String, List<String>> items = new HashMap<>();

    public String generateQuery(Map<String, String> searchDTO) {
        LOG.info("Creating query for Requirement...");
        fillValues();
        stringBuffer.append(" SELECT x FROM Requirement x ");

        if (searchDTO.containsKey("budgetId") && !searchDTO.get("budgetId").isEmpty()) {
            firstOne = false;
            stringBuffer.append(" JOIN x.budgetRequirementsList AS brs WHERE brs.budget.budgetId LIKE '%")
                    .append(searchDTO.get("budgetId")).append("%' ");
        }
        searchDTO.forEach(this::newFilter);

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

    private void fillValues() {
        items.put("requirementName", Arrays.asList("x.requirementName", LIKE));
        items.put("requirementStartDate", Arrays.asList("x.requirementStartDate", EQUALS));
        items.put("requirementEndDate", Arrays.asList("x.requirementEndDate", EQUALS));
        items.put("subPrincipalId", Arrays.asList("x.level.levelId", EQUALS));
        items.put("companyId", Arrays.asList("x.company.companyId", EQUALS));
        items.put("technologyId", Arrays.asList("x.technology.technologyId", EQUALS));
        items.put("userInternalId", Arrays.asList("x.user.userInternalId", EQUALS));
        items.put("userManagerId", Arrays.asList("x.userManager.userInternalId", EQUALS));
        items.put("areaId", Arrays.asList("x.area.areaId", EQUALS));
        items.put("programIncrementId", Arrays.asList("x.programIncrement.programIncrementId", EQUALS));
        items.put("channelId", Arrays.asList("x.channel.channelId", EQUALS));
        items.put("applicationId", Arrays.asList("x.application.applicationId", EQUALS));
        items.put("serviceTypeId", Arrays.asList("x.serviceType.serviceTypeId", EQUALS));
        items.put("methodologyId", Arrays.asList("x.project.methodology.methodologyId", EQUALS));
    }
}
