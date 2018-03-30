package com.mx.bbva.util.queries;

import com.mx.bbva.business.dto.RequirementSearchDTO;

import java.util.logging.Logger;

public class QueryGenerator {
    private static final Logger LOGGER = Logger.getLogger(QueryGenerator.class.getName());
    private StringBuffer stringBuffer = new StringBuffer();
    private boolean firstOne = true;

    public String generate(RequirementSearchDTO searchDTO) {
        LOGGER.info("Creating query...");
        stringBuffer.append("SELECT NEW com.mx.bbva.business.entity.Requirement(x.requirementId, x.requirementName) FROM Requirement x ");
        if (null != searchDTO.getAttAreaId()) {
            addFilter("x.area.areaId", String.valueOf(searchDTO.getAttAreaId()));
        }
        if (null != searchDTO.getServiceTypeId()) {
            addFilter("x.serviceType.serviceTypeId", String.valueOf(searchDTO.getServiceTypeId()));
        }
        LOGGER.info("Query made : " + stringBuffer.toString());
        return stringBuffer.toString();
    }

    private void addFilter(String filter, String value) {
        if (firstOne) {
            stringBuffer.append(" WHERE ");
            firstOne = false;
        } else {
            stringBuffer.append(" AND ");
        }
        stringBuffer.append(filter).append(" = ").append(value);
    }
}
