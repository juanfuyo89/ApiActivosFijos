/**
 * 
 */
package com.adecco.prueba.services;

/**
 * Clase de Excepcion para un activo fijo con una fecha de compra superior a la fecha de baja
 * 
 * @author Juan Carlos Fuyo
 *
 */
public class ValidateActivoException extends RuntimeException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public ValidateActivoException() {
		super();
	}

	public ValidateActivoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ValidateActivoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidateActivoException(String message) {
		super(message);
	}

	public ValidateActivoException(Throwable cause) {
		super(cause);
	}

}
