/**
 * 
 */
package com.adecco.prueba.services.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adecco.prueba.data.model.Activo;
import com.adecco.prueba.data.repository.ActivoRepository;
import com.adecco.prueba.services.ValidateActivoException;
import com.adecco.prueba.web.model.Response;

/**
 * Aspecto que valida un Activo fijo a crear por parte del cliente Rest
 * 
 * @author Juan Carlos Fuyo
 *
 */
@Component
@Aspect
public class ValidatorImpl implements Validator {

	@Autowired
	private ActivoRepository activoRepo;

	@Pointcut("execution(* createActivo(*)) && args(activo)")
	public void validateCreate(Activo activo) {
	}

	@Before("validateCreate(activo)")
	@Override
	public void validateActivoCreate(Activo activo) {
		if (activo.getFechaBaja() != null && activo.getFechaBaja().compareTo(activo.getFechaCompra()) > 0)
			throw new ValidateActivoException(Response.DATE_ERROR_MSG);
	}

	@Pointcut("execution(* modifyActivo(*)) && args(activo)")
	public void validateUpdate(Activo activo) {
	}

	@Before("validateUpdate(activo)")
	@Override
	public void validateActivoUpdate(Activo activo) {
		if (activo.getFechaBaja() != null && activo.getFechaBaja().compareTo(activoRepo.findById(activo.getIdActivo()).get().getFechaCompra()) > 0)
			throw new ValidateActivoException(Response.DATE_ERROR_MSG);
	}

}
