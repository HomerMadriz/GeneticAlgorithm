package org.gava;

import java.util.Random;

public class TwoPointCrossover extends Crossover<Boolean> {

	private Random random = new Random(System.currentTimeMillis());

	@Override
	public void cross(Genotype<Boolean> genotype1, Genotype<Boolean> genotype2) {
		int index1 = random.nextInt(genotype1.length());
		int index2 = random.nextInt(genotype2.length());
		while(index2 == index1) index2 = random.nextInt(genotype2.length());
		if(index1 < index2) {
			for(int i = index1; i <= index2; i ++) {
				boolean value1 = genotype1.getGene(i);
				boolean value2 = genotype2.getGene(i);
				genotype1.setGene(i, value2);
				genotype2.setGene(i, value1);
				
			}
		} else {
			for(int i = index2; i <= index1; i ++) {
				boolean value1 = genotype1.getGene(i);
				boolean value2 = genotype2.getGene(i);
				genotype1.setGene(i, value2);
				genotype2.setGene(i, value1);				
			}
		}
	}

}
