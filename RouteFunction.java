package lcll;

import java.util.List;

import org.gava.ObjectiveFunction;

public class RouteFunction implements ObjectiveFunction<Integer> {

	private int length;
	private double[][] map;
	private int maxWeight;

	/**
	 * Constructor para inicialización de ruta
	 * @param map Matriz cuadrada con los pesos de cada arista
	 * @param maxW Peso máximo introducido de alguna arista
	 * @param length No. de nodos
	 */
	public RouteFunction(double[][] map, int maxW, int length) {
		this.map = map;
		this.maxWeight = maxW ;
		this.length = length;
	}

	@Override
	public int length() {
		return this.length;
	}

	/**
	 * Se recibe una ruta especifica y se calcula el peso de la ruta
	 */
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