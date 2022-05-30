package io.github.dathin.onesignup.util;

import org.junit.jupiter.api.Test;

class CaseFormatterTest {

	CaseFormatter caseFormatter = new CaseFormatter();

	@Test
	void fromTextToCamelCase() {
		final var pedro_madeira = caseFormatter.fromTextToCamelCase("Pedro Madeira");
		final var s = caseFormatter.fromCamelCaseToText(pedro_madeira);
		System.out.println(pedro_madeira);
	}

}