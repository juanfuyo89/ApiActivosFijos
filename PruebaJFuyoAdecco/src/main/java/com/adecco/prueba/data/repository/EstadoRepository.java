/**
 * 
 */
package com.adecco.prueba.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adecco.prueba.data.model.Estado;

/**
 * @author Juan Carlos Fuyo Gonzalez
 *
 */
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
