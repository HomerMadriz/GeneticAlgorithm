package org.gava;

import java.util.ArrayList;
import java.util.List;

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

	public void setGenerations(int generations) throws IllegalArgumentException {
		if(generations <= 0) throw new IllegalArgumentException("Generations number must be greater than 0");
		this.generations = generations;
	}

	public void setPopulationSize(int populationSize) {
		if(populationSize <= 1) throw new IllegalArgumentException("Population size must be greater than 1");
		this.populationSize = populationSize;
	}
	
	public void setObjectiveFunction(ObjectiveFunction<P> objectiveFunction) throws IllegalArgumentException {
		if(objectiveFunction == null) throw new IllegalArgumentException("Objective function must not be null");
		this.objectiveFunction = objectiveFunction;
	}

	public void setSelector(Selector<G, P> selector) throws IllegalArgumentException {
		if(selector == null) throw new IllegalArgumentException();
		this.selector = selector;
	}

	public void setCrossover(Crossover<G> crossover) throws IllegalArgumentException {
		if(crossover == null) throw new IllegalArgumentException();
		this.crossover = crossover;
	}

	public void setMutator(Mutator<G> mutator) throws IllegalArgumentException {
		if(mutator == null) throw new IllegalArgumentException();
		this.mutator = mutator;
	}
	
	public void selection(int best) {
		this.population = selector.select(this.population);
	}

	public int updateFitness() {
		int bestIndividual = -1;
		double bestFitness = -1;
		int i;
		for (i = 0; i < this.populationSize; i++) {
			Individual<G, P> individual = this.population.get(i);
			double result = this.objectiveFunction.f(individual.getPhenotype());
			double f = 1.0 / (result + 1.0);
			individual.setFitness(f);
			if(f > bestFitness) {
				bestFitness = f;
				bestIndividual = i;
			}
		}
		return bestIndividual;
	}
	
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

	public void mutation(int best) {
		for (int i = 0; i < this.populationSize; i++) {
			if(i == best) continue;
			Individual<G, P> individual = this.population.get(i);
			if (Math.random() < 0.1) {
				mutator.mutate(individual.genotype);
			}
		}
	}

	public void setIndividualFactory(IndividualFactory<G, P> individualFactory) {
		this.individualFactory = individualFactory;
	}

	private void initPopulation() {
		this.population = new ArrayList<>(this.populationSize);
		for (int i = 0; i < this.populationSize; i++) {
			Individual<G, P> individual = this.individualFactory.create();
			this.population.add(individual);
		}
	}

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
			selection(bestIndividualIndex);
			crossover(bestIndividualIndex);
			mutation(bestIndividualIndex);
		}
	}
	
	public List<P> getBest() {
		if(bestIndividualIndex == -1) return null;
		Individual<G, P> bestIndividual = population.get(bestIndividualIndex);
		List<P> phenotype = bestIndividual.getPhenotype();
		return phenotype;
	}
	

}
