package org.gava;

import java.util.ArrayList;
import java.util.List;

public class DoubleArrayPhenotype extends DoublePhenotype {

	private double[] array;
	private double[] minValue;
	private double[] maxValue; 
	private List<Double> valuesList = null;
	
	public DoubleArrayPhenotype(int length, double[] min, double[] max) {
		this.array      = new double[length];
		this.minValue   = min;
		this.maxValue   = max;
		this.valuesList = new ArrayList<Double>(length);
		for(int i = 0; i < length; i ++) this.valuesList.add(0.0);
	}
	 
	@Override
	public void setValue(int index, Double value) {
		this.array[index] = value;
		this.valuesList.set(index, value);
	}

	@Override
	public Double getValue(int index) {
		return this.array[index];
	}

	@Override
	public int length() {
		return this.array.length;
	}

	@Override
	public Double getMinValue(int index) {
		return this.minValue[index];
	}

	@Override
	public Double getMaxValue(int index) { 
		return this.maxValue[index];
	}

	@Override
	public List<Double> asList() {
		return this.valuesList;
	}

	@Override
	public Phenotype<Double> clone() {
		DoubleArrayPhenotype clone = new DoubleArrayPhenotype(this.length(), this.minValue, this.maxValue);
		clone.array      = this.array.clone();
		clone.valuesList = new ArrayList<Double>(this.valuesList);
		return clone;
	}	
	
}
