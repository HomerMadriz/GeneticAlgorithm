package org.gava;

public abstract class Genotype<T> {

	public abstract void setGene(int index, T value);
	public abstract T getGene(int index);
	public abstract int  length();
	public abstract void randomize();
	public abstract Genotype<T> clone();
	
}
