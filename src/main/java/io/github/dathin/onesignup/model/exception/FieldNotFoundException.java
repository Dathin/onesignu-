package io.github.dathin.onesignup.model.exception;

import io.github.dathin.boot.dathinstartermodel.exception.GenericException;
import org.springframework.http.HttpStatus;

import java.util.Set;

public class FieldNotFoundException extends GenericException {
    public FieldNotFoundException(Set<String> fields) {
        super(HttpStatus.BAD_REQUEST.value());
        StringBuilder message = new StringBuilder("The following fields could not be found: ");
        for (String field : fields) {
            message.append(field).append(", ");
        }
        message.setLength(message.length() - 2);
        setError(message.toString());
    }
}
