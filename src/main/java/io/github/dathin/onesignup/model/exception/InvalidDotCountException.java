package io.github.dathin.onesignup.model.exception;

import io.github.dathin.boot.dathinstartermodel.exception.GenericException;
import org.springframework.http.HttpStatus;

public class InvalidDotCountException extends GenericException {
    public InvalidDotCountException() {
        super("You can't specify more than a dot per field. Invalid examples: my.invalid.field, my..invalidField. Valid example: my.validField, my (gets default value of my)", HttpStatus.BAD_REQUEST.value());
    }
}
