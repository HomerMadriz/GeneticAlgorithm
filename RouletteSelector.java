package org.gava;

import java.util.ArrayList;
import java.util.List;

public class RouletteSelector<G ,P> implements Selector<G, P> {


	/**
	 * Selección por Ruleta. 
	 */
	@Override
	public List<Individual<G, P>> select(List<Individual<G, P>> oldPopulation) {
		final int N = oldPopulation.size();
		List<Individual<G, P>> newPopulation = new ArrayList<Individual<G, P>>(N);
		double[] expectedValues = new double[N]; 
		double fitnessSum = 0;
		double maxFitness = 0;
		int    bestIndividual = -1;
		for(int i = 0; i < N; i ++) {
			Individual<G, P> individual = oldPopulation.get(i);
			double fitness = individual.getFitness();
			fitnessSum += fitness;
			if(fitness > maxFitness) {
				maxFitness = fitness;
				bestIndividual = i;
			}
		}
		if(fitnessSum == 0) fitnessSum = 0.0001;
		for(int i = 0; i < N; i ++) {
			Individual<G, P> individual = oldPopulation.get(i);
			expectedValues[i] = individual.getFitness() / fitnessSum;
		}

		newPopulation.add(oldPopulation.get(bestIndividual).clone()); 
		for(int i = 1; i < N; i ++) {
			double rnd = Math.random();
			double evSum = 0;
			for(int j = 0; j < N; j ++) {
				evSum += expectedValues[j];
				if(evSum >= rnd) {
					Individual<G, P> selected = oldPopulation.get(j);
					newPopulation.add(selected.clone());
					break;
				}
			}
		}
		return newPopulation;
	}

}