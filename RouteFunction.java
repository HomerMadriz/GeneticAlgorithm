package lcll.org.gava;

import java.util.List;

import org.gava.ObjectiveFunction;

public class RouteFunction implements ObjectiveFunction<Integer> {

	private int length;
	private double[][] map;
	private int maxWeight;
	
	public RouteFunction(double[][] map, int maxW, int length) {
		this.map = map;
		this.maxWeight = maxW ;
		this.length = length;
	}
	
	
	
	@Override
	public int length() {
		return this.length;
	}

	@Override
	public Double function(List<Integer> route) {
		double sum = 0;
		
		for(int i = 0; i < route.size() - 1; i++) {
			sum += map[route.get(i)-1][route.get(i+1)-1];
		}	
		return sum;
	}



	public int getMaxWeight() {
		return maxWeight;
	}

	
}
