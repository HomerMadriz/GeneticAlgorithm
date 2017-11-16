package org.gava;

public abstract class Crossover <T> {

	public abstract void cross(Genotype<T> genotype1, Genotype<T> genotype2);
	
}
