package lcll.org.gava;

import java.util.Arrays;

public class RouteMap {
	private double[][] map;
	private int nodes;
	
	public RouteMap(int nodes) {
		this.nodes = nodes;
		this.map = new double[nodes][nodes];
	}
	
	
	public void setRoute(int orig, double[] weights) {
		for(int i = 0; i < nodes; i++) {
			if(i == orig)
				map[orig][i] = (double) 0;
			else
				map[orig][i] = weights[i];
		}
	}
	
	public double[][] getMap(){
		return map;
	}
	
	public String toString() {
		String answ = "";
		for(int i= 0; i < this.nodes; i++)
			answ += (Arrays.toString(map[i]) + "\n");
	return answ;
	}
}
