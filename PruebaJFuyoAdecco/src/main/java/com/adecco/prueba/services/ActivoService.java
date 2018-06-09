/**
 * 
 */
package com.adecco.prueba.services;

import java.util.List;

import com.adecco.prueba.data.model.Activo;

/**
 * Define los metodos de servicio para el manejo de activos en la aplicación
 * 
 * @author Juan Carlos Fuyo
 *
 */
public interface ActivoService {
	
	/**
	 * Retorna un listado de los activos en sistema
	 * 
	 * @return
	 */
	List<Activo> getAllActivos();

	/**
	 * Retorna un listado de activos con base en su Tipo
	 * 
	 * @param idTipo
	 * @return List<Activo>
	 */
	List<Activo> getActivosByTipo(int idTipo);

	/**
	 * Retorna un listado de activos con base en la Fecha de compra
	 * 
	 * @param fechaCompra
	 * @return List<Activo>
	 */
	List<Activo> getActivosByFechaCompra(String fechaCompra);

	/**
	 * Retorna un activo con base en su Serial
	 * 
	 * @param serial
	 * @return Activo
	 */
	Activo getActivosBySerial(String serial);

	/**
	 * Crea un activo en sistema
	 * 
	 * @param activo
	 */
	void createActivo(Activo activo);

	/**
	 * Actualiza un activo (serial y fecha de baja) en sistema
	 * 
	 * @param activo
	 */
	void modifyActivo(Activo activo);

}