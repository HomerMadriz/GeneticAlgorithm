package org.gava;

import java.util.List;

public class RouteIndividual extends Individual<Integer, Integer> {
	
	

	public RouteIndividual(Genotype<Integer> genotype, Phenotype<Integer> phenotype) {
		super(genotype, phenotype);
	}

	@Override
	public void updatePhenotype() {
		for(int i = 0; i< super.genotype.length(); i++) {
			super.phenotype.setValue(i, super.genotype.getGene(i));
		}
	}

	@Override
	public Individual<Integer, Integer> clone() {
		Individual<Integer, Integer> clone = new RouteIndividual(super.genotype.clone(), super.phenotype.clone());
		clone.fitness = this.fitness;
		return clone;
	}

	@Override
	public List<Integer> getPhenotype() {
		return this.phenotype.asList();
	}

	@Override
	public double normalize(ObjectiveFunction<Integer> objectiveFunction) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
