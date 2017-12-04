package org.gava;

import java.util.List;

/**
 * Clase abstracta y genérica que define los métodos necesarios para la construcción de un fenotipo 
 * útil en algoritmos genéticos.
 * 
 * @author Hugo Iván Piza Dávila
 * @param <T> Type
 */

public abstract class Phenotype<T> { 
	
	public abstract void setValue(int index, T value);
	public abstract T getValue(int index);
	public abstract int  length();
	public abstract T getMinValue(int index);
	public abstract T getMaxValue(int index);
	public abstract List<T> asList();
	public abstract Phenotype<T> clone();

}
