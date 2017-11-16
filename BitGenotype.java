package org.gava;

public abstract class BitGenotype extends Genotype<Boolean> {

	public abstract void    setGene(int index, Boolean value);
	public abstract Boolean getGene(int index);

	public abstract void    setBit(int index);
	public abstract void    clearBit(int index);
	public abstract boolean getBit(int index);
	
}
