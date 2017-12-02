package org.gava;

import java.util.List;

public abstract class Individual<G, P> {
	
	protected Genotype<G>  genotype;
	protected Phenotype<P> phenotype;
	
	protected double fitness = 0;
	
	public abstract void updatePhenotype();
	public abstract Individual<G, P> clone();
	public abstract List<P> getPhenotype();	
	public abstract double normalize(ObjectiveFunction<P> objectiveFunction);
	
	public Individual(Genotype<G> genotype, Phenotype<P> phenotype) {
		this.genotype  = genotype;
		this.phenotype = phenotype;
		updatePhenotype();
	}
	
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}
	
	public double getFitness() {
		return this.fitness;
	}

}
