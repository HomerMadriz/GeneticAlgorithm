package org.gava;

import java.util.List;

/** La clase Individual describe al individuo y su aptitud.
 * @author Hugo Ivan Piza
 *
 * @param <G> Genotipo del individuo
 * @param <P> Fenotipo del Individuo
 */
public abstract class Individual<G, P> implements Comparable<Individual<G, P>> {
	
	protected Genotype<G>  genotype;
	protected Phenotype<P> phenotype;
	
	protected double fitness = 0;
	
	/** Actualiza el valor del Fenotipo, según lo encontrado en el genotipo.
	 * 
	 */
	public abstract void updatePhenotype();
	public abstract Individual<G, P> clone();
	/** Devuelve el Fenotipo del individuo a manera de una lista.
	 * @return -Lista con los valores del Fenotipo.
	 */
	public abstract List<P> getPhenotype();	
	/** Normaliza la evaluación de la función entre valores de 0 a 1, para atribuirselos a la aptitud (fitness).
	 * @param objectiveFunction Función con la que se va a normalizar.
	 * @return -Retorna el valor de la aptitud.
	 */
	public abstract double normalize(ObjectiveFunction<P> objectiveFunction);
	
	/** Constructor del Individuo
	 * @param genotype Genotipo del individuo
	 * @param phenotype Fenotipo del individuo
	 */
	public Individual(Genotype<G> genotype, Phenotype<P> phenotype) {
		this.genotype  = genotype;
		this.phenotype = phenotype;
		updatePhenotype(); 
	}
	
	/** Da el valor de la aptitud del Individuo.
	 * @param fitness Aptitud del Individuo
	 */
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}
	
	/** Regresa la aptitud del individuo
	 * @return Aptitud del Individuo
	 */
	public double getFitness() {
		return this.fitness;
	}
	
	
	public int compareTo(Individual<G, P> individual2) {
		if(this.fitness < individual2.getFitness())
			return -1;
		if(this.fitness > individual2.getFitness())
			return 1;
		return 0;
	}

}
