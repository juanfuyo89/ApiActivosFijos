package com.adecco.prueba.test.services;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.adecco.prueba.data.model.Activo;
import com.adecco.prueba.data.repository.ActivoRepository;
import com.adecco.prueba.services.ActivoService;
import com.adecco.prueba.services.ActivoServiceImpl;

/**
 * Clase de pruebas unitarias con Mockito para la capa de Servicios
 * 
 * @author Juan Carlos Fuyo
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TestServiceMock {

	private final Logger logger = LogManager.getRootLogger();

	@Mock
	private ActivoRepository activoRepoMock;
	
	@InjectMocks
	private ActivoService activoService = new ActivoServiceImpl();
	
	@Before
	public void setUp() throws Exception {
		logger.info("Inicio de Test Services");
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllActivos() {
		when(activoRepoMock.findAll()).thenReturn(new ArrayList<Activo>());
		assertThat(activoService.getAllActivos(), is(notNullValue()));
		verify(activoRepoMock).findAll();
	}

	@Test
	public void getActivosByFechaCompra() {
		when(activoRepoMock.findByFechaCompra(Mockito.any())).thenReturn(new ArrayList<Activo>());
		assertThat(activoService.getActivosByFechaCompra("08-06-2018"), is(notNullValue()));
		verify(activoRepoMock).findByFechaCompra(Mockito.any());
	}

	@Test
	public void getActivosBySerial() {
		when(activoRepoMock.findBySerial(Mockito.any())).thenReturn(new Activo());
		assertThat(activoService.getActivosBySerial(Mockito.any()), is(notNullValue()));
		verify(activoRepoMock).findBySerial(Mockito.any());
	}

	@Test
	public void createActivo() {
		activoService.createActivo(Mockito.any());
		verify(activoRepoMock).save(Mockito.any());
	}

	@Test
	public void modifyActivo() {
		Activo activo = new Activo();
		activo.setSerial("HMX349OK4");
		activo.setFechaBaja(new Date());
		activo.setIdActivo(1);
		activoService.modifyActivo(activo);
		verify(activoRepoMock).updateActivo(Mockito.any(), Mockito.any(), anyInt());
	}

}
