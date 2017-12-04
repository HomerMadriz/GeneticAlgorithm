package org.gava;

import java.util.ArrayList;
import java.util.List;

/**
 *  Método estocástico de búsqueda de solucipnes casi-óptimas.
 *  
 *  Genera muchas soluciones a lo largo de generaciones y las evalúa.
 *  Permite la exporación y explotación.
 *  
 *  Utiliza Genotipos y Fenotipos para llegar a la solución. 
 * 
 * 
 * @author Omar Antonio Madriz Almanza; Mariana Chavez Medina; Jose Luis Torrentera Arroniz
 * @version 1.0
 *
 * @param <G> Genotype
 * @param <P> Phenotype
 */

public class GeneticAlgorithm<G, P> {

	private IndividualFactory<G, P> individualFactory = null;
	private Selector<G, P> selector = null;
	private Crossover<G> crossover = null;
	private Mutator<G> mutator = null;
	private ObjectiveFunction<P> objectiveFunction = null;

	private List<Individual<G, P>> population = null;
	private int populationSize = 0; 
	private int generations = 0;
	private int bestIndividualIndex = -1;

	/**
	 * Permite especificar el número de generaciones que se realizarán en el algoritmo, este cambia dependiendo el problema a optimizar.
	 * @param generations El número de generaciones es calculado de manera distinta dependiendo el problema que se aborde. 
	 * @throws IllegalArgumentException No se permiten generaciones menores a cero. 
	 */
	public void setGenerations(int generations) throws IllegalArgumentException {
		if(generations <= 0) throw new IllegalArgumentException("Generations number must be greater than 0");
		this.generations = generations;
	}

	/**
	 * Permite indicar el tamaño de la población. 
	 * @param populationSize El tamaño se determina de distintas maneras dependiendo del problema a optimizar.
	 * @throws IllegalArgumentException No se permiten problaciones menores a 1.
	 */
	public void setPopulationSize(int populationSize) throws IllegalArgumentException {
		if(populationSize <= 1) throw new IllegalArgumentException("Population size must be greater than 1");
		this.populationSize = populationSize;
	}
	
	
	/**
	 * Indica cuál será la función objetivo.
	 * @param objectiveFunction La función objetivo evalua la función a optimizar realizandoles su Fitness
	 * @throws IllegalArgumentException No se permiten funciones objetivo nulas. 
	 */
	public void setObjectiveFunction(ObjectiveFunction<P> objectiveFunction) throws IllegalArgumentException {
		if(objectiveFunction == null) throw new IllegalArgumentException("Objective function must not be null");
		this.objectiveFunction = objectiveFunction;
	}

	/**
	 * Indica cuál será el selector que se utilizará.
	 * @param selector Los selectores varían dependiendo del problema a optimizar.
	 * @throws IllegalArgumentException No se permiten selectores nulos. 
	 */
	public void setSelector(Selector<G, P> selector) throws IllegalArgumentException {
		if(selector == null) throw new IllegalArgumentException("Selector must not be null");
		this.selector = selector;
	}

	/**
	 * Indica cuál algoritmo de cruza se utilizará
	 * @param crossover Los algoritmos de cruza varían dependiendo del problema a optimizar.
	 * @throws IllegalArgumentException No se permiten algoritmos de cruza nulos.
	 */
	public void setCrossover(Crossover<G> crossover) throws IllegalArgumentException {
		if(crossover == null) throw new IllegalArgumentException();
		this.crossover = crossover;
	}
 
	/**
	 * Indica el mutador que se utilizará.
	 * @param mutator Los mutadores varían dependiendo del problema a optimizar.
	 * @throws IllegalArgumentException No se permiten mutadores nulos.
	 */
	public void setMutator(Mutator<G> mutator) throws IllegalArgumentException {
		if(mutator == null) throw new IllegalArgumentException();
		this.mutator = mutator;
	}
	
	/**
	 * Utiliza el selector con la poblacion perteneciente al algoritmo. 
	 */
	public void selection() {
		this.population = selector.select(this.population);
	}
	
	/**
	 * Realiza el fitness cada uno de los individuos de la población, normalizando el resultado y retornando el mejor individuo según el calculo de su aptitud. 
	 * @return bestIndividual Retorna el mejor individuo despues de realizar el fitness.
	 */
	public int updateFitness() {
		int bestIndividual = -1;
		double bestFitness = -1;
		int i;
		for (i = 0; i < this.populationSize; i++) {
			Individual<G, P> individual = this.population.get(i);
			double f = individual.normalize(this.objectiveFunction);
			individual.setFitness(f);
			if(f > bestFitness) {
				bestFitness = f;
				bestIndividual = i;
			}
		}
		return bestIndividual;
	} 
	
	/**
	 * Realiza la cruza entre la población y el mejor individuo.
	 * @param best Indice del mejor individuo dentro de la lista de población. 
	 */
	public void crossover(int best) {
		for (int i = 0; i < this.populationSize; i += 2) {
			if(i == best || i + 1 == best) continue;
			Individual<G, P> individual0 = this.population.get(i);
			Individual<G, P> individual1 = this.population.get(i + 1);
			if (Math.random() < 0.8) {
				crossover.cross(individual0.genotype, individual1.genotype);
			}
		}
	}

	/**
	 * Le realiza una mutación al mejor individuo de la población
	 * @param best Indice del mejor individuo dentro de la lista de población. 
	 */
	public void mutation(int best) {
		for (int i = 0; i < this.populationSize; i++) {
			if(i == best) continue;
			Individual<G, P> individual = this.population.get(i);
			if (Math.random() < 0.1) {
				mutator.mutate(individual.genotype);
			}
		}
	}

	/**
	 * Indica cual será la fabrica de individuos que se utlizará.
	 * @param individualFactory Crea individuos, cada fabrica será diferente dependiendo de las necesidades del algoritmo. 
	 */
	public void setIndividualFactory(IndividualFactory<G, P> individualFactory) {
		this.individualFactory = individualFactory;
	}

	/**
	 * Llena la lista de población con el tamaño, los individuos y la fabrica especificados por el usuario. 
	 */
	private void initPopulation() {
		this.population = new ArrayList<>(this.populationSize);
		for (int i = 0; i < this.populationSize; i++) {
			Individual<G, P> individual = this.individualFactory.create();
			this.population.add(individual);
		}
	}

	/**
	 * Comienza el algoritmo genetico validando que se encuentren correctamente configurados los elementos necesarios para su correcto funcionamiento. 
	 */
	public void run() {
		if(this.objectiveFunction == null) throw new MissingStageException("Objective function is not specified"); 
		if(this.individualFactory == null) throw new MissingStageException("Individual factory is not specified");
		if(this.selector  == null) throw new MissingStageException("Selector method is not specified");
		if(this.crossover == null) throw new MissingStageException("Crossover method is not specified");
		if(this.mutator   == null) throw new MissingStageException("Mutator method is not specified");
		
		initPopulation();
		for (int g = 0; g < this.generations; g++) {
			bestIndividualIndex = updateFitness();
//			System.out.printf("%d: %s\n", g, this.population.get(bestIndividualIndex));
			selection();
			crossover(bestIndividualIndex);
			mutation(bestIndividualIndex);
		}
	} 
	
	/**
	 * 
	 * @return Phenotype El fenotipo del mejor resultado generado en el algoritmo.
	 */
	public List<P> getBest() {
		if(bestIndividualIndex == -1) return null;
		Individual<G, P> bestIndividual = population.get(bestIndividualIndex);
		List<P> phenotype = bestIndividual.getPhenotype();
		return phenotype;
	}
	

}
