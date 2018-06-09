/**
 * 
 */
package com.adecco.prueba.data.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.adecco.prueba.data.model.Activo;
import com.adecco.prueba.data.model.Tipo;

/**
 * @author Juan Carlos Fuyo Gonzalez
 *
 */
public interface ActivoRepository extends JpaRepository<Activo, Integer> {

	List<Activo> findByTipo(Tipo tipo);

	List<Activo> findByFechaCompra(Date fechaCompra);

	Activo findBySerial(String serial);
	
	@Modifying
	void updateActivo(String serial, Date fechaBaja, int idActivo);
	
}