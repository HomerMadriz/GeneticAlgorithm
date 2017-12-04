package org.gava;

/**
 * Interface que implementa clase para realizar la cruza
 * @param <T> 
 */
public abstract class Crossover <T> {

	/**
	 * Se crean índices aleatorios para fijar una subcadena en los nuevos genotipos
	 * @param genotype1 Genotipo padre
	 * @param genotype2 Genotipo madre
	 */
	public abstract void cross(Genotype<T> genotype1, Genotype<T> genotype2);
	
}
