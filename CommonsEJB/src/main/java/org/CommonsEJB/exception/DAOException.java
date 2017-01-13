package org.CommonsEJB.exception;

public class DAOException extends UFFFatalException {
	private static final long serialVersionUID = -1555104124339514398L;

	public DAOException(String message) {
		super(message);
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}
}
