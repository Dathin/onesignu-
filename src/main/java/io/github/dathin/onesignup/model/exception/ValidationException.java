package io.github.dathin.onesignup.model.exception;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ValidationException extends GenericException{

    private final List<FormResponse> formResponse;

    public ValidationException(List<FormResponse> formResponse) {
        super("Error validating input", HttpStatus.BAD_REQUEST);
        this.formResponse = formResponse;
    }

    public List<FormResponse> getFormResponse() {
        return formResponse;
    }
}
