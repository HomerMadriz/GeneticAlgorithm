package org.gava;

public class RouteIndividualFactory extends IndividualFactory<Integer, Integer> {
	
	private int length; 
	private int maxWeight;
	private int nodeNumb; //temporary
	
	
	public RouteIndividualFactory(int length, int maxWeight, int nodeNumb) {
		this.length = length;
		this.maxWeight = maxWeight;
		this.nodeNumb = nodeNumb;
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
