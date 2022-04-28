package io.github.dathin.onesignup.model.exception;

import org.springframework.http.HttpStatus;

public class InvalidBlankFieldException extends GenericException{
    public InvalidBlankFieldException() {
        super("You can't specify a blank field. Invalid examples: my.validField, ,my.anotherValidField. Valid example: my.validField, my (gets default value of my)", HttpStatus.BAD_REQUEST);
    }
}
