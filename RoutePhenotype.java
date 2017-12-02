package org.gava;

import java.util.List;

public class RoutePhenotype extends IntPhenotype {

	private int[] array;
	private int length;
	private List<Integer> valuesList = null;
 

	public RoutePhenotype(int length) {
		this.length = length;
		this.array = new int[this.length];
		for(int i = 0; i < length; i ++) this.valuesList.add(0);
	}

	@Override
	public void setValue(int index, Integer value) {
		this.array[index] = value;
		this.valuesList.set(index, value);

	}

	@Override
	public Integer getValue(int index) {
		return this.array[index];
	}

	@Override
	public int length() {
		return this.length;
	}

	@Override
	public Integer getMinValue(int index) {
		// Metodo no utilizado por el momento
		return null;
	}

	@Override
	public Integer getMaxValue(int index) {
		// Metodo no utilizado por el momento
		return null;
	}

	@Override
	public List<Integer> asList() {	
		return this.valuesList;
	}

	@Override
	public Phenotype<Integer> clone() {
		RoutePhenotype clone = new RoutePhenotype(this.length);
		clone.array = this.array.clone();
		return clone;
	}

}
