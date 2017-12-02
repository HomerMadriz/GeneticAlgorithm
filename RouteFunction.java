package org.gava;

import java.util.List;

public class RouteFunction implements ObjectiveFunction<Integer> {

	private int length;
	private Integer[][] map;
	
	public RouteFunction(Integer[][] map) {
		this.map = map;
	}
	
	@Override
	public int length() {
		return this.length;
	}

	@Override
	public Integer function(List<Integer> route) {
		int sum = 0;
		
		for(int i = 0; i < route.size() - 1; i++) {
			sum += map[route.get(i)][route.get(i+1)];
		}	
		return sum;
	}
	
}
