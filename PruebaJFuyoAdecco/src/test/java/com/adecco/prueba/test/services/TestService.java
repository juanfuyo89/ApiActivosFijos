/**
 * 
 */
package com.adecco.prueba.test.services;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.adecco.prueba.data.model.Activo;
import com.adecco.prueba.data.model.Estado;
import com.adecco.prueba.data.model.Tipo;
import com.adecco.prueba.services.ActivoService;

/**
 * Clase de pruebas de integracion para la capa de Servicios
 * 
 * @author Juan Carlos Fuyo
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestService {
	
	private final Logger logger = LogManager.getRootLogger();

	@Autowired 
	ActivoService activoService;
	
	@Before
	public void setUp() throws Exception {
		logger.info("Inicio de Test de integracion de la capa de Servicios");
	}

	@Test
	public void getAllActivos() {
		assertThat(activoService.getAllActivos(), is(notNullValue()));
	}

	@Test
	public void getActivosByTipo() {
		assertThat(activoService.getActivosByTipo(3), is(notNullValue()));
	}

	@Test
	public void getActivosByFechaCompra() {
		assertThat(activoService.getActivosByFechaCompra("08-06-2018"), is(notNullValue()));
	}

	@Test
	public void getActivosBySerial() {
		assertThat(activoService.getActivosBySerial("HMX349OK4"), is(notNullValue()));
	}

	@Test
	@Transactional
	public void createActivo() {
		Activo activo = new Activo();
		activo.setNombre("Activo Prueba");
		activo.setInternoInventario(87);
		activo.setSerial("GPU647OK7");
		activo.setAlto(20);
		activo.setAncho(20);
		activo.setLargo(20);
		activo.setPeso(2);
		activo.setColor("Azul");
		activo.setFechaCompra(new Date());
		activo.setValorCompra(10000);
		activo.setTipo(new Tipo(2));
		activo.setEstado(new Estado(1));
		activoService.createActivo(activo);
		logger.info("Activo ingresado con id: " + activo.getIdActivo());
		assertNotNull(activo.getIdActivo());
	}

	@Test
	@Transactional
	public void modifyActivo() {
		Activo activo = new Activo();
		activo.setSerial("HMX349OK4");
		activo.setFechaBaja(null);
		activo.setIdActivo(1);
		activoService.modifyActivo(activo);
		assertNotNull(activo.getIdActivo());
	}

}
