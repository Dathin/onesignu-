package io.github.dathin.onesignup.validators;

import io.github.dathin.onesignup.model.exception.FormResponse;
import io.github.dathin.onesignup.model.exception.ValidationException;

import java.util.ArrayList;
import java.util.List;

public abstract class Validator<T> {

    protected List<FormResponse> violations;

    protected Validator() {
        violations = new ArrayList<>();
    }

    protected abstract void validate(T t);

    public void throwOnViolations(T t) {
        validate(t);
        if (violations.isEmpty()) {
            throw new ValidationException(violations);
        }
    }

}
