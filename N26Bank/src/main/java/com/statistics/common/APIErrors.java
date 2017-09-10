package com.statistics.common;

/**
 * API Error Codes
 *
 * @author shivamoberoi
 */
public enum APIErrors {
	VALIDATION("Validation error"), VALIDATION_EMPTY_REQUEST_BODY("Empty request body"), VALIDATION_MISSING_TIMESTAMP(
			"Missing timestamp field"),VALIDATION_MISSING_AMOUNT("Missing Amount field"),

	UNEXPECTED_ERROR("Internal API Error");

	private String message;

	APIErrors(String message) {
		this.message = message;
	}

	public String message() {
		return this.message;
	}
}
