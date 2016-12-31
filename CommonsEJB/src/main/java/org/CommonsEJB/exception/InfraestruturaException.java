/**
 * 
 */
package org.CommonsEJB.exception;

/**
 * @author Pablo
 *
 */
public class InfraestruturaException extends RuntimeException {

	private final static long serialVersionUID = 1;

	public InfraestruturaException(Exception msg) {
		super(msg);
	}
}
