package org.gava;

import java.math.BigDecimal;
import java.util.List;

public class BitDoubleIndividual extends Individual<Boolean, Double> {

	public BitDoubleIndividual(Genotype<Boolean> bitGenotype, Phenotype<Double> dblPhenotype) {
		super(bitGenotype, dblPhenotype);
	}
	 
	@Override
	public void updatePhenotype() {
		final int bitsPerValue    = super.genotype.length() / super.phenotype.length();
		final BigDecimal base     = new BigDecimal("2");
		final BigDecimal maxValue = new BigDecimal(Math.pow(2, bitsPerValue) - 1);
		for(int v = 0, g = 0; v < super.phenotype.length(); v ++) {
			BigDecimal sum  = new BigDecimal("0");
			BigDecimal acc  = new BigDecimal("1"); 
			for( ; g < (v + 1) * bitsPerValue; g ++) { 
				if(super.genotype.getGene(g)) sum = sum.add(acc);
				acc = acc.multiply(base);
			}			
			double normalized = sum.divide(maxValue, 16, BigDecimal.ROUND_HALF_UP).doubleValue();
			super.phenotype.setValue(v, phenotype.getMinValue(v) + normalized * (phenotype.getMaxValue(v) - phenotype.getMinValue(v)));
		}
	}
	
	public String toString() {
//		final int bitsPerValue = super.genotype.length() / super.phenotype.length();
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		for(int v = 0; v < phenotype.length(); v ++) {
//			for(  ; g < (v + 1) * bitsPerValue; g ++) sb.append(genotype.getGene(g)? '1' : '0');
			sb.append(String.format(" %.8f", phenotype.getValue(v)));
			if(v < phenotype.length() - 1) sb.append(", ");
		}
		sb.append(String.format(",  %.6f>", super.fitness));
		return sb.toString();
	}

	@Override
	public Individual<Boolean, Double> clone() {
		Individual<Boolean, Double> clone = new BitDoubleIndividual(super.genotype.clone(), super.phenotype.clone());
		clone.fitness = this.fitness;
		return clone;
	}
	
	public List<Double> getPhenotype() {
		return this.phenotype.asList();
	}

	@Override
	public double normalize(ObjectiveFunction<Double> objectiveFunction) {
		double result = objectiveFunction.function(this.getPhenotype());
		return 1.0 / (result + 1) ;
	}
	
}
