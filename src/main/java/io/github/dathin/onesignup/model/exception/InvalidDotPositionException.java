package io.github.dathin.onesignup.model.exception;

import org.springframework.http.HttpStatus;

public class InvalidDotPositionException extends GenericException{
    public InvalidDotPositionException() {
        super("You can't have left or right side of '.' empty. Invalid examples: '.a, a. '. Valid example: my.validField, my (gets default value of my)", HttpStatus.BAD_REQUEST);
    }
}
