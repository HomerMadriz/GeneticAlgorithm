package org.gava;

import java.util.List;

public abstract class Phenotype<T> {
	
	public abstract void setValue(int index, T value);
	public abstract T getValue(int index);
	public abstract int  length();
	public abstract T getMinValue();
	public abstract T getMaxValue();
	public abstract List<T> asList();
	public abstract Phenotype<T> clone();

}
