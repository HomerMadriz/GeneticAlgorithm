package lcll.org.gava;

import org.gava.Genotype;
import org.gava.Individual;
import org.gava.IndividualFactory;
import org.gava.Phenotype;

public class RouteIndividualFactory extends IndividualFactory<Integer, Integer> {
	
	private int length; 
	
	
	public RouteIndividualFactory(int length) {
		this.length = length;
	}
	
	@Override
	public Individual<Integer, Integer> create() {
		Genotype<Integer> genotype = new RouteGenotype(this.length);
		Phenotype<Integer> phenotype = new RoutePhenotype(this.length);
		genotype.randomize();
		RouteIndividual individual = new RouteIndividual(genotype, phenotype);
		return individual;
	}

}
