package org.gava;

/** Operación de Mutación. 
 * La clase Mutator da una plantilla para todas las clases que realizan una operación de Mutación.
 * @version 1.0 
 * @author Hugo Ivan Piza
 *
 * @param <T> - Tipo
 */
public abstract class Mutator<T> {

	
	/** El método mutate realiza un cambio sobre el genotipo del indivisuo k para generar un nuevo individuo.
	 *
	 * @param genotype Genotipo del individuo a mutar
	 */
	public abstract void mutate(Genotype<T> genotype);
	
}
