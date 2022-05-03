package io.github.dathin.onesignup.model.exception;

import io.github.dathin.boot.dathinstartermodel.exception.GenericException;
import org.springframework.http.HttpStatus;

public class InvalidBlankFieldException extends GenericException {
    public InvalidBlankFieldException() {
        super("You can't specify a blank field. Invalid examples: my.validField, ,my.anotherValidField. Valid example: my.validField, my (gets default value of my)", HttpStatus.BAD_REQUEST.value());
    }
}
