package io.github.dathin.onesignup.model.exception;

import io.github.dathin.boot.dathinstartermodel.exception.GenericException;

public class InvalidFieldsLengthException extends GenericException {

	public InvalidFieldsLengthException() {
		super("You need to specify at least 1 field and at maximum 25 fields", 400);
	}

}
