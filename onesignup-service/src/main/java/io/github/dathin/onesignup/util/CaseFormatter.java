package io.github.dathin.onesignup.util;

public class CaseFormatter {

	public static String fromTextToCamelCase(String s) {
		if (s == null) {
			return s;
		}
		StringBuilder sb = new StringBuilder(s.length());
		sb.append(Character.toLowerCase(s.charAt(0)));
		boolean uppercaseNext = false;
		for (int i = 1; i < s.length(); i++) {
			char iChar = s.charAt(i);
			if (iChar == ' ') {
				uppercaseNext = true;
				continue;
			}
			sb.append(uppercaseNext ? Character.toUpperCase(iChar) : Character.toLowerCase(iChar));
			uppercaseNext = false;
		}
		return sb.toString();
	}

	public static String fromCamelCaseToText(String s) {
		if (s == null) {
			return s;
		}
		StringBuilder sb = new StringBuilder(s.length());
		sb.append(Character.toUpperCase(s.charAt(0)));
		for (int i = 1; i < s.length(); i++) {
			char iChar = s.charAt(i);
			if (Character.isUpperCase(iChar)) {
				sb.append(' ');
				sb.append(iChar);
				continue;
			}
			sb.append(iChar);
		}
		return sb.toString();
	}

}
