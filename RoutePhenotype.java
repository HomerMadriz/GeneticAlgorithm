package lcll.org.gava;

import java.util.ArrayList;
import java.util.List;

import org.gava.Phenotype;

/**
 * RouteGenotype es la definición del fenotipo utilizado en el problema del agente viajero. En este caso su estructura es identica a la del genotipo.
 * 
 * Su atributo array es analogo a chromosome (en RouteGenotype) y está comprendido por un arreglo de enteros en donde su longitud es definida por el usuario. 
 * 
 *  Las posiciones del arreglo representarán las rutas siendo números enteros los nodos, iniciando con el número 1, que es el nodo de origen y terminando con el mismo
 *  ya que en este problema se regresa siempre al inicio. Por lo tanto, el atributo array siempre comenzará y terminará con el
 *  número entero 1.  
 * 
 * @author Omar Antonio Madriz Almanza; Mariana Chavez Medina; Jose Luis Torrentera Arroniz
 * @version 1.0
 *
 */

public class RoutePhenotype extends IntPhenotype {

	private int[] array;
	private int length;
	private List<Integer> valuesList = null; 
 
/**
 * Las instancias se inicializarán con un arreglo de tamaño length + 1.
 * Se le agrega uno debido a que como se representa la ruta que se seguirá, el ultimo nodo que se visita es el que fue indicado cómo primero
 * ocupando una posición más en el arreglo, por esta razón los cromosomas inician y terminan con el número 1. 
 * 
 * Además se crea una Lista ya que en ciertos procesos del algoritmo se necesitará la representación en List del fenotipo, esta lista será inicializada
 * por defecto en cero. 
 * @param length
 */
	public RoutePhenotype(int length) {
		this.length = length + 1;
		this.array = new int[this.length];
		this.valuesList = new ArrayList<Integer>(this.length);
		for(int i = 0; i < this.length; i ++) this.valuesList.add(0); 
	}

	/**
	 * Modifica los valores del arreglo y de la lista en el indice especificado. 
	 * @param index
	 * @param value
	 */
	@Override
	public void setValue(int index, Integer value) {
		this.array[index] = value;
		this.valuesList.set(index, value);

	}

	/**
	 * Regresa el valor de la posición del arreglo especificada por el indice. 
	 * @param index
	 */
	@Override
	public Integer getValue(int index) {
		return this.array[index];
	}

	/**
	 * Retorna el valor de la longitud del arreglo. 
	 * @return length
	 */
	@Override
	public int length() {
		return this.length;
	}

	/**
	 * Método inutilizado debido a que es innecesario en el problema del agente viajero.
	 */
	@Override
	public Integer getMinValue(int index) {
		// Metodo no utilizado por el momento
		return null;
	}

	/**
	 * Método inutilizado debido a que es innecesario en el problema del agente viajero.
	 */
	@Override
	public Integer getMaxValue(int index) {
		// Metodo no utilizado por el momento
		return null;
	}

	/**
	 * Retorna una lista con los valores contenidos en el arreglo. 
	 */
	@Override
	public List<Integer> asList() {	
		return this.valuesList;
	}

	/**
	 * Retorna una copia idéntica del fenotipo. 
	 */
	@Override
	public Phenotype<Integer> clone() {
		RoutePhenotype clone = new RoutePhenotype(this.length - 1);
		clone.array = this.array.clone();
		return clone;
	}

}
