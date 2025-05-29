package com.example.pdv.dto;

import java.util.Arrays;
import java.util.List;

public class ApiExceptionDTO {
    private List<String> errorList;

    public ApiExceptionDTO(List<String> errorList) {
        this.errorList = errorList;
    }

    public ApiExceptionDTO(String message){
        this.errorList = Arrays.asList(message);
    }

    public List<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
}
