package io.github.dathin.onesignup.model.exception;

import org.springframework.http.HttpStatus;

public class DuplicateSearchFieldExcpetion extends GenericException{
    public DuplicateSearchFieldExcpetion() {
        super("You can't have duplicate fields. Invalid examples: duplicate.field, duplicate.field, my, my.default. Valid example: my.field1, my.field2, my (gets default value of my)", HttpStatus.BAD_REQUEST);
    }
}
