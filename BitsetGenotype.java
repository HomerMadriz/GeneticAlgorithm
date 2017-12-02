package org.gava;

import java.util.BitSet;
import java.util.Random;

public class BitsetGenotype extends BitGenotype {
  
	private BitSet chromosome = null;
	private final  int length;
	
	public BitsetGenotype(int length) {
		this.length = length;
		this.chromosome = new BitSet(length);
	}
	
	@Override
	public void setGene(int index, Boolean value) {
		this.chromosome.set(index, value);
	}

	@Override
	public Boolean getGene(int index) {
		return this.chromosome.get(index);
	}

	@Override
	public int length() {
		return length;
	}

	@Override
	public void randomize() {
		Random rnd = new Random();
		for(int i = 0; i < length; i ++) chromosome.set(i, rnd.nextBoolean());
	}
	
	@Override
	public void setBit(int index) {
		this.chromosome.set(index);
	}

	@Override
	public void clearBit(int index) {
		this.chromosome.clear(index);
	}

	@Override
	public boolean getBit(int index) {
		return this.chromosome.get(index);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < length; i ++) {
			sb.append(chromosome.get(i)? '1' : '0');
			if((i + 1) % 4 == 0) sb.append(' ');
		}
		return sb.toString();
	}

	public Genotype<Boolean> clone() {
		BitsetGenotype clone = new BitsetGenotype(this.length);
		clone.chromosome = (BitSet) this.chromosome.clone();
		return clone;
	}
}
