package org.gava;

/** Esta clase es encarga de la creación de objetos de la clase Individual
 * @author Hugo Ivan Piza
 *
 * @param <G> Genotipo de los individuos
 * @param <P> Fenotipo de los individuos
 */
public abstract class IndividualFactory<G, P> {
	
	/** Crea un objeto de la clase individuo
	 * @return Individuo creado.
	 */
	public abstract Individual<G, P> create();
	
}
