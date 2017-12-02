package org.gava;

public class BitDoubleIndividualFactory extends IndividualFactory<Boolean, Double> {

	private int nBits, nComponents;
	private double[] minValue ;
	private double[] maxValue ;

	public BitDoubleIndividualFactory(int nBits, int nComponents, double ... minMax) {
		this.nBits       = nBits;
		this.nComponents = nComponents;
		this.minValue = new double[minMax.length/2];
		this.maxValue = new double[minMax.length/2];
		for(int i = 0, j = 0; i < minMax.length; i += 2, j++) {
			this.minValue[j] = minMax[i];
			this.maxValue[j] = minMax[i+1];
		}
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
