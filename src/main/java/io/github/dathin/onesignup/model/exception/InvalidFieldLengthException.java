package io.github.dathin.onesignup.model.exception;

import io.github.dathin.boot.dathinstartermodel.exception.GenericException;
import org.springframework.http.HttpStatus;

public class InvalidFieldLengthException extends GenericException {
    public InvalidFieldLengthException() {
        super("You can't specify a field with length over 101, left and right side of . can have 50 length each. Invalid examples: yourtoolongstring.yourtoolongstring. Valid example: my.validField, my (gets default value of my)", HttpStatus.BAD_REQUEST.value());
    }
}
