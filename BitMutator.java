package org.gava;

import java.util.Random;

public class BitMutator extends Mutator<Boolean> {

	private Random random = new Random();
	
	@Override
	public void mutate(Genotype<Boolean> genotype) {
		int index = random.nextInt(genotype.length());
		genotype.setGene(index, !genotype.getGene(index));
	}

}
