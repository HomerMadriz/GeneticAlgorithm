package org.gava;

import static java.lang.Math.PI;
import static java.lang.Math.cos;

import java.util.List;

public class RastriginFunction implements ObjectiveFunction<Double> {

	private static RastriginFunction instance = null;
	
	private RastriginFunction() {
		
	}
	
	@Override
	public int length() {
		return 2;
	}

	@Override
	public double f(List<Double> args) {
		double x1 = args.get(0);
		double x2 = args.get(1);
		return 20 + (x1 * x1) + (x2 * x2) - 10 * (cos(2 * PI * x1) + cos(2 * PI * x2));
	}
	
	public static RastriginFunction getInstance() {
		if(instance == null) instance = new RastriginFunction();
		return instance;
	}

}
