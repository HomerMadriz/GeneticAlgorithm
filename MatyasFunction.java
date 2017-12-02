package org.gava;

import java.util.List;

public class MatyasFunction implements ObjectiveFunction<Double> {
	
	private static MatyasFunction instance = null;
	
	private MatyasFunction() {
		
	}

	@Override
	public int length() {
		return 2;
	}

	@Override
	public Double function(List<Double> args) {
			double x1 = args.get(0);
			double x2 = args.get(1);
		return (.26*(x1*x1 + x2*x2) - (.48*x1*x2));
	}
	
	public static MatyasFunction getInstance() {
		if(instance == null) instance = new MatyasFunction();
		return instance;
	}

}
