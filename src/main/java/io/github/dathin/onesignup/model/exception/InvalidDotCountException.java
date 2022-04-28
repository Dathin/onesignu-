package io.github.dathin.onesignup.model.exception;

import org.springframework.http.HttpStatus;

public class InvalidDotCountException extends GenericException{
    public InvalidDotCountException() {
        super("You can't specify more than a dot per field. Invalid examples: my.invalid.field, my..invalidField. Valid example: my.validField, my (gets default value of my)", HttpStatus.BAD_REQUEST);
    }
}
