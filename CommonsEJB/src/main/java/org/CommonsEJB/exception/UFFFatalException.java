package org.CommonsEJB.exception;

public class UFFFatalException extends RuntimeException {
	private static final long serialVersionUID = 1000896224430502360L;

	public UFFFatalException() {
		super();
	}

	public UFFFatalException(String message) {
		super(message);
	}

	public UFFFatalException(Throwable cause) {
		super(cause);
	}

	public UFFFatalException(String message, Throwable cause) {
		super(message, cause);
	}
}
