package io.github.dathin.onesignup.mapper;

import io.github.dathin.onesignup.model.exception.*;
//import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;

import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface SearchFieldsMapper {

	int keyTagAndDotMaxLength = 101;

	default Set<String> from(String[] fields) {
		var set = new HashSet<String>();
		if (fields.length == 0 || fields.length > 25) {
			throw new InvalidFieldsLengthException();
		}
		for (String field : fields) {
			var dotCount = StringUtils.countMatches(field, '.');
			if (field.length() > keyTagAndDotMaxLength) {
				throw new InvalidFieldLengthException();
			}
			else if (field.isBlank()) {
				throw new InvalidBlankFieldException();
			}
			else if (dotCount == 0) {
				set.add(field + ".default");
			}
			else if (dotCount > 1) {
				throw new InvalidDotCountException();
			}
			else if (dotCount == 1) {
				var splitField = field.split("\\.");
				if (splitField.length < 2 || splitField[0].isBlank() || splitField[1].isBlank()) {
					throw new InvalidDotPositionException();
				}
				set.add(field);
			}
			else {
				set.add(field);
			}
		}
		if (set.size() != fields.length) {
			throw new DuplicateSearchFieldExcpetion();
		}
		return set;
	}

}
