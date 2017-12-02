package org.gava;

import java.util.Random;

public class BitFlipMutator extends Mutator<Boolean> {

	private static BitFlipMutator instance = null;
	
	private Random random = new Random();

	private BitFlipMutator() { 
		
	}
	
	@Override
	public void mutate(Genotype<Boolean> genotype) {
		int index = random.nextInt(genotype.length());
		genotype.setGene(index, !genotype.getGene(index));
	}

	public static BitFlipMutator getInstance() {
		if(instance == null) instance = new BitFlipMutator();
		return instance;
	}
}
