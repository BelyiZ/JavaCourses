package com.spring.crud.dto;

import java.util.List;

public class ErrorsDTO {

    private String error;

    private List<FieldErrorDTO> fieldErrors;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<FieldErrorDTO> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldErrorDTO> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}