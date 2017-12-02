package org.gava;

import java.util.List;

public class McCormickFunction implements ObjectiveFunction<Double> {

	private static McCormickFunction instance = null;
	
	private McCormickFunction() {
	
	}
	
	@Override
	public int length() {
		return 2;
	}

	@Override
	public Double function(List<Double> args) {
		double x1 = args.get(0);
		double x2 = args.get(1);
		
		return Math.sin(x1 + x2) + (x1 - x2)*(x1 - x2) - (1.5 * x1) + (2.5 * x2) + 1;
	}
	
	public static McCormickFunction getInstance() {
		if(instance == null) instance = new McCormickFunction();
		return instance;
	}

}
