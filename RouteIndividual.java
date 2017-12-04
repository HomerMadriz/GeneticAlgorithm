package lcll.org.gava;

import java.util.List;

import org.gava.Genotype;
import org.gava.Individual;
import org.gava.ObjectiveFunction;
import org.gava.Phenotype;

public class RouteIndividual extends Individual<Integer, Integer> {
	
	

	public RouteIndividual(Genotype<Integer> genotype, Phenotype<Integer> phenotype) {
		super(genotype, phenotype);
	}

	@Override
	public void updatePhenotype() {
		for(int i = 0; i < super.genotype.length(); i++) {
			super.phenotype.setValue(i, super.genotype.getGene(i));
		}
	}

	@Override
	public Individual<Integer, Integer> clone() {
		Individual<Integer, Integer> clone = new RouteIndividual(super.genotype.clone(), super.phenotype.clone());
		clone.setFitness(this.fitness);
		return clone;
	}

	@Override
	public List<Integer> getPhenotype() {
		return this.phenotype.asList();
	}

	@Override
	public double normalize(ObjectiveFunction<Integer> objectiveFunction)throws NotRouteFunctionException {
		if (!(objectiveFunction instanceof RouteFunction)) throw new NotRouteFunctionException();
		double distance = objectiveFunction.function(this.getPhenotype());	
		RouteFunction routeFunction = (RouteFunction) objectiveFunction;
		return 1 - (distance/(routeFunction.getMaxWeight() * routeFunction.length()));
	}

	
}
