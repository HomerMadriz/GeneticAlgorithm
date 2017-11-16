package org.gava;

public class BitDoubleIndividualFactory extends IndividualFactory<Boolean, Double> {

	private int nBits, nComponents;
	private double minValue, maxValue;
	
	public BitDoubleIndividualFactory(int nBits, int nComponents, double min, double max) {
		this.nBits       = nBits;
		this.nComponents = nComponents;
		this.minValue    = min;
		this.maxValue    = max;
	}
	
	@Override
	public Individual<Boolean, Double> create() {
		Phenotype<Double>   phenotype  = new DoubleArrayPhenotype(this.nComponents, this.minValue, this.maxValue);
		Genotype<Boolean>   genotype   = new BitsetGenotype(this.nBits);
		genotype.randomize();
		BitDoubleIndividual individual = new BitDoubleIndividual(genotype, phenotype);
		return individual;
	}

}
