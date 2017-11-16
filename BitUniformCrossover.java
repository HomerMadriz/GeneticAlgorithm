package org.gava;

import java.util.Random;

public class BitUniformCrossover extends Crossover<Boolean> {

	private static BitUniformCrossover instance = null;

	private Random random = new Random();
	
	private BitUniformCrossover() {
	}
	
	@Override
	public void cross(Genotype<Boolean> genotype1, Genotype<Boolean> genotype2) {
		int index1 = random.nextInt(genotype1.length());
		int index2 = random.nextInt(genotype2.length());
		if(index1 > index2) {
			int tmp = index1;
			index1  = index2;
			index2  = tmp;
		}
		for(int i = index1; i <= index2; i ++) {
			if(Math.random() < 0.5) {
				boolean gene1 = genotype1.getGene(i);
				genotype1.setGene(i, genotype2.getGene(i));
				genotype2.setGene(i, gene1);
			}
		}
	}

	public static BitUniformCrossover getInstance() {
		if(instance == null) instance = new BitUniformCrossover();
		return instance;
	}
	
}
