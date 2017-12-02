package org.gava;

import java.util.Random;

public class RouteGenotype extends IntGenotype {

	private int[] chromosome;
	private int length;
	 
	public RouteGenotype(int length) {
		this.length = length;
		this.chromosome = new int[length];
	}
	
	@Override
	public void setGene(int index, int value) {
		this.chromosome[index] = value; 
	}

	@Override
	public Integer getGene(int index) {
		return this.chromosome[index];
	}

	@Override
	public void setGene(int index, Integer value) {
		this.chromosome[index] = value;

	}

	@Override
	public int length() {
		return this.length;
	}

	@Override
	public void randomize() {
		Random rnd = new Random();
		this.chromosome[0] = 1;
		this.chromosome[this.chromosome.length - 1] = 1;
		
		for(int i = 1; i < this.chromosome.length - 1; i++)this.chromosome[i] = i+1;
		
		for(int i = 1; i < this.chromosome.length - 1; i++) {
			int random = rnd.nextInt(this.chromosome.length - 2) + 1;
			int tmp;
			
			tmp = this.chromosome[i];
			this.chromosome[i] = this.chromosome[random];
			this.chromosome[random] = tmp;
		}

	}

	@Override
	public Genotype<Integer> clone() {
		RouteGenotype clone = new RouteGenotype(this.length);
		clone.chromosome = this.chromosome.clone();
		return clone;
	}
	
	public int[] getChromosome() {
		return chromosome;
	}
	
}
