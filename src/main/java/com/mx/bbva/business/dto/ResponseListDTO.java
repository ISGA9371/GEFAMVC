package com.mx.bbva.business.dto;

import java.util.List;

public class ResponseListDTO {
    private List<?> data;

    public ResponseListDTO() {
    }

    public ResponseListDTO(List<?> data) {
        this.data = data;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
