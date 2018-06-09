/**
 * 
 */
package com.adecco.prueba.services.utilities;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

/**
 * Clase utilitaria que implementa metodos estaticos para el servicio Rest
 * 
 * @author Juan Carlos Fuyo
 *
 */
public class Util {
	
	/**
	 * Realiza el parser de una fecha a una instancia de LocalDate
	 * 
	 * @param dateString
	 * @return
	 */
	public static Date parseStrToDate(String dateString) throws DateTimeParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-M-yyyy");
		LocalDate localDate = LocalDate.parse(dateString, formatter);
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}
}
