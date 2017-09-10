package com.statistics.model;

/**
 * Throwing Error whenever Exception is encountered.
 *
 * @author shivamoberoi
 */
public class Errors {
	private String errorMessage;

	public Errors(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
