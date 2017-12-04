package org.gava;

import java.util.List;

/**
 * Interface que implementan la clase para crear la función objetivo
 * @param <P>
 */
public interface ObjectiveFunction<P> {

	/**
	 * Longitud
	 * @return
	 */
	int length();
	
	/**
	 * Definición de la función objetivo
	 * @param args Lista con argumentos utilizables en la función objetivo
	 * @return La función objetivo
	 */
	Double function(List<P> args);

}