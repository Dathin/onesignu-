package io.github.dathin.onesignup.model.exception;

import io.github.dathin.boot.dathinstartermodel.exception.GenericException;

public class DuplicateSearchFieldExcpetion extends GenericException {

	public DuplicateSearchFieldExcpetion() {
		super("You can't have duplicate fields. Invalid examples: duplicate.field, duplicate.field, my, my.default. Valid example: my.field1, my.field2, my (gets default value of my)",
				400);
	}

}
