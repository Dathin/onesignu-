package io.github.dathin.onesignup.model.exception;

public class GenericResponse {

    private final String error;


    public GenericResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

}
