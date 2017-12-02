package org.gava;

public abstract class IntPhenotype extends Phenotype<Integer> {
	@Override
	public abstract void setValue(int index, Integer value);
	
	@Override
	public abstract Integer getValue(int index);
}
