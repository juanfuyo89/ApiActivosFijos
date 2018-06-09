/**
 * 
 */
package com.adecco.prueba.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adecco.prueba.data.model.Ciudad;

/**
 * @author Juan Carlos Fuyo Gonzalez
 *
 */
public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {

}
