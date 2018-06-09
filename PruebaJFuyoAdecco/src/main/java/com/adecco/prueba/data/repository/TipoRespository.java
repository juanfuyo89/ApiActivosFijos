/**
 * 
 */
package com.adecco.prueba.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adecco.prueba.data.model.Tipo;

/**
 * @author Juan Carlos Fuyo Gonzalez
 *
 */
public interface TipoRespository extends JpaRepository<Tipo, Integer> {

}
