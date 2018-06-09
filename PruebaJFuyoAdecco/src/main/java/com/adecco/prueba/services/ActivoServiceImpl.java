/**
 * 
 */
package com.adecco.prueba.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adecco.prueba.data.model.Activo;
import com.adecco.prueba.data.model.Tipo;
import com.adecco.prueba.data.repository.ActivoRepository;
import com.adecco.prueba.data.repository.TipoRespository;
import com.adecco.prueba.services.utilities.Util;

/**
 * @author Juan Carlos Fuyo
 *
 */
@Service
public class ActivoServiceImpl implements ActivoService {

	@Autowired
	private ActivoRepository activoRepo;
	@Autowired
	private TipoRespository tipoRepo;
	
	@Override
	public List<Activo> getAllActivos() {
		return activoRepo.findAll();
	}

	@Override
	public List<Activo> getActivosByTipo(int idTipo) {
		System.out.println(tipoRepo);
		Optional<Tipo> tipo = tipoRepo.findById(idTipo);
		return activoRepo.findByTipo(tipo.get());
	}

	@Override
	public List<Activo> getActivosByFechaCompra(String fechaCompra) {
		Function<String, Date> funParse = (dateString) -> Util.parseStrToDate(dateString);
		return activoRepo.findByFechaCompra(funParse.apply(fechaCompra));
	}

	@Override
	public Activo getActivosBySerial(String serial) {
		return activoRepo.findBySerial(serial);
	}

	@Override
	@Transactional
	public void createActivo(Activo activo) {
		activoRepo.save(activo);
	}

	@Override
	@Transactional
	public void modifyActivo(Activo activo) {
		activoRepo.updateActivo(activo.getSerial(), activo.getFechaBaja(), activo.getIdActivo());
	}

}
