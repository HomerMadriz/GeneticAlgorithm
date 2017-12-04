package lcll.org.gava;

import java.util.Arrays;

/** La clase RouteMap permite la creción de un mapa (conjunto de nodos y sus relaciones).
 * 
 * @author Mariana Chavez, Omar Madriz, José Luis Torrentera
 */
public class RouteMap {
	private double[][] map;
	private int nodes;
	
	/** Constructor de RouteMap
	 * @param nodes - Número de nodos en el mapa.
	 */
	public RouteMap(int nodes) {
		this.nodes = nodes;
		this.map = new double[nodes][nodes];
	}
	
	
	/** Da los pesos desde un ounto de origen hacia los otros puntos.
	 * @param orig -El punto de origen de donde se determinan los pesos de los demás
	 * @param weights -Lista de pesos del punto de origen hacia los otros puntos
	 */
	public void setRoute(int orig, double[] weights) {
		for(int i = 0; i < nodes; i++) {
			if(i == orig)
				map[orig][i] = (double) 0;
			else
				map[orig][i] = weights[i];
		}
	}
	
	/** Regresa el mapa creado en una matriz.
	 * @return El mapa como una matriz.
	 */
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
