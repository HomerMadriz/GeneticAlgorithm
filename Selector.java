package org.gava;

import java.util.List;

/**
 *Interface que implementan clases para la selección
 * @param <G>
 * @param <P>
 */
public interface Selector<G, P> {


	/**
	 * Método para realizar la selección
	 * @param population Lista de tipo Individuo, contiene Fenotipo y Genotipo
	 * @return Una lista con nuevos individuos que pasaron la selección
	 */
	List<Individual<G, P>> select (List<Individual<G, P>> population);

}
