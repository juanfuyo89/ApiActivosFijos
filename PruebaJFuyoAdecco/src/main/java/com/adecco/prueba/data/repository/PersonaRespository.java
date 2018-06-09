/**
 * 
 */
package com.adecco.prueba.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adecco.prueba.data.model.Persona;

/**
 * @author Juan Carlos Fuyo Gonzalez
 *
 */
public interface PersonaRespository extends JpaRepository<Persona, Integer> {

}
