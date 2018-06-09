package com.adecco.prueba.test.data;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;
import java.util.function.Function;

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
import com.adecco.prueba.data.repository.ActivoRepository;
import com.adecco.prueba.services.utilities.Util;

/**
 * Clase de pruebas para la capa de Datos
 * 
 * @author Juan Carlos Fuyo
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRepository {

	private final Logger logger = LogManager.getRootLogger();

	@Autowired 
	ActivoRepository activoRepository;

	@Before
	public void setUp() throws Exception {
		logger.info("Inicio de Test de Repositorios");
	}

	@Test
	public void findAll() {
		List<Activo> activos = activoRepository.findAll();
		activos.forEach(logger::info);
		assertNotNull(activos);
	}

	@Test
	public void findByTipo() {
		List<Activo> activos = activoRepository.findByTipo(new Tipo(3));
		activos.forEach(logger::info);
		assertNotNull(activos);
	}

	@Test
	public void findByFechaCompra() {
		Function<String, Date> funParse = (dateString) -> Util.parseStrToDate(dateString);
		List<Activo> activos = activoRepository.findByFechaCompra(funParse.apply("23-06-2017"));
		activos.forEach(activo -> logger.info(activo));
		assertNotNull(activos);
	}

	@Test
	public void findBySerial() {
		Activo activo = activoRepository.findBySerial("HMX349OK4");
		logger.info(activo);
		assertNotNull(activo);
	}

	@Test
	@Transactional
	public void save() {
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
		activoRepository.save(activo);
		logger.info(activo);
		assertNotNull(activo.getIdActivo());
	}

	@Test
	@Transactional
	public void updateActivo() {
		Function<String, Date> funParse = (dateString) -> Util.parseStrToDate(dateString);
		activoRepository.updateActivo("GPU647OK7", funParse.apply("23-06-2015"), 1);
	}

}