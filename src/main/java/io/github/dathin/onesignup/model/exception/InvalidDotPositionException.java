package io.github.dathin.onesignup.model.exception;

import io.github.dathin.boot.dathinstartermodel.exception.GenericException;
import org.springframework.http.HttpStatus;

public class InvalidDotPositionException extends GenericException {
    public InvalidDotPositionException() {
        super("You can't have left or right side of '.' empty. Invalid examples: '.a, a. '. Valid example: my.validField, my (gets default value of my)", HttpStatus.BAD_REQUEST.value());
    }
}
