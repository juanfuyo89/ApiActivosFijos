/**
 * 
 */
package com.adecco.prueba.services.aspects;

import com.adecco.prueba.data.model.Activo;

/**
 * Interfaz que define los metodos de validacion de Activos fijos mediante AOP
 * 
 * @author Juan Carlos Fuyo
 *
 */
public interface Validator {

	/**
	 * Advice que valida la modificacion de un Activo fijo
	 */
	void validateActivoUpdate(Activo activo);

	/**
	 * Advice que valida la creacion de un Activo fijo
	 */
	void validateActivoCreate(Activo activo);
	
}
