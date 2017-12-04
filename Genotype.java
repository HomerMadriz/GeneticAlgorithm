package org.gava;
/**
 * Clase abstracta y genérica que define los métodos necesarios para la construcción de un genotipo 
 * útil en algoritmos genéticos.
 * 
 * @author Hugo Iván Piza Dávila
 * * @param <T> Type
 */
public abstract class Genotype<T> {

	public abstract void setGene(int index, T value);
	public abstract T getGene(int index);
	public abstract int  length();
	public abstract void randomize();
	public abstract Genotype<T> clone();
	
}
