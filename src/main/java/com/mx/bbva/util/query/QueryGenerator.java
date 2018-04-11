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
        final String EQUALS = " = ";
        final String LIKE = " LIKE ";

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
