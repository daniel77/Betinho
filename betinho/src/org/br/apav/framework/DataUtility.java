/*
 * SISTEMA BETINHO - UNICENP - APAV 
 * Copyright 2007 
 * Todos os direitos são reservados.  
 */
package org.br.apav.framework;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe Utilitária para trabalhar com Data. Essa classe trabalha no formato
 * brasileiro de data e hora
 * 
 * @author Daniel Gorski
 * @author Adriano Almeida
 * @author Aramis Y.
 * @since 08/2007
 * 
 * @see java.util.Date
 * @see java.text.DateFormat
 * 
 */
public class DataUtility {

	/**
	 * Data e Hora no formato dd/MM/yyyy HH:mm
	 */
	private static final DateFormat dataHoraFormato = new SimpleDateFormat(
			"dd/MM/yyyy HH:mm");

	/**
	 * Data no formato dd/MM/yyyy HH:mm
	 */
	private static final DateFormat dataFormato = new SimpleDateFormat(
			"dd/MM/yyyy");

	/**
	 * Retorna um Date, com a data e hora alterada.
	 * 
	 * @param data
	 * @return
	 */
	public static Date stringToDateHora(String data) {
		try {
			return dataHoraFormato.parse(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Retorna um Date, com a data e hora.
	 * 
	 * @param data
	 * @return
	 */
	public static Date stringToDate(String data) {
		if (data == null || "".equals(data))
			return null;

		try {
			return dataFormato.parse(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Método que retorna uma string no formato data/hora dd/mm/yyyy de um Date.
	 * 
	 * @param data
	 *            objeto date
	 * @return string data.
	 */
	public static String dateToString(Date data) {
		if (data == null)
			return "";
		return dataFormato.format(data);

	}

	/**
	 * Método que retorna uma string no formato data/hora dd/mm/yyyy hh24:mm:ss
	 * de um Date.
	 * 
	 * @param data
	 *            objeto date
	 * @return string data.
	 */
	public static String dateHoraToString(Date data) {
		if (data == null)
			return "";
		return dataHoraFormato.format(data);

	}

}
