package lcll.org.gava;

import java.util.Random;

import org.gava.Genotype;

/**
 * RouteGenotype es la definición del genotipo utilizado en el problema del agente viajero. 
 * 
 * Su atributo chromosome está comprendido por un arreglo de enteros en donde su longitud es definida por el usuario. 
 * 
 * Las rutas serán representadas por números enteros iniciando con el número 1, que es el nodo de origen y terminando con el mismo
 *  ya que en este problema se regresa siempre al inicio. Por lo tanto, el atributo chromosome siempre comenzará y terminará con el
 *  número entero 1.  
 * 
 * @author Omar Antonio Madriz Almanza; Mariana Chavez Medina; Jose Luis Torrentera Arroniz
 * @version 1.0
 *
 */

public class RouteGenotype extends IntGenotype {

	private int[] chromosome;
	private int length;
	 
	/**
	 * Construye un cromosoma a partir de una longitud especifica que representa el número de nodos más uno. 
	 * Se le agrega uno debido a que como el cromosoma representa la ruta que se seguirá, el ultimo nodo que se visita es el que fue indicado cómo primero
	 * ocupando una posición más en el arreglo, por esta razón los cromosomas inician y terminan con el número 1. 
	 * @param length Longitud del cromosoma
	 */
	
	public RouteGenotype(int length) {
		this.length = length + 1;
		this.chromosome = new int[this.length];
	}
	
	/**
	 * Modifica el cromosoma con un valor entero en el índice especificado. 
	 * @param index Indice del arreglo al que se desea modificar.
	 * @param value Nuevo valor.
	 */
	@Override
	public void setGene(int index, Integer value) {
		this.chromosome[index] = value; 
	}

	/**
	 * Retorna el valor del cromosoma en el índice especificado. 
	 * @param index Indice del arreglo al que se desea modificar.
	 */
	@Override
	public Integer getGene(int index) {
		return this.chromosome[index];
	}
	/**
	 * Retorna el tamaño del cromosoma. 
	 */
	@Override
	public int length() {
		return this.length;
	}

	/**
	 * Genera rutas aleatorias realizando permutaciones en el cromosoma despreciando la primera y la última posición ya que estas representan el origen y el destino final
	 * de la ruta. 
	 */
	@Override
	public void randomize() {
		Random rnd = new Random();
		this.chromosome[0] = 1;
		this.chromosome[this.chromosome.length - 1] = 1;
		
		for(int i = 1; i < this.chromosome.length - 1; i++)this.chromosome[i] = i+1;
		
		for(int i = 1; i < this.chromosome.length - 1; i++) {
			int random = rnd.nextInt(this.chromosome.length - 2) + 1;
			int tmp;
			
			tmp = this.chromosome[i];
			this.chromosome[i] = this.chromosome[random];
			this.chromosome[random] = tmp;
		}

	}

	/**
	 * Realiza un clone idéntico del genotipo. 
	 */
	@Override
	public Genotype<Integer> clone() {
		RouteGenotype clone = new RouteGenotype(this.length - 1);
		clone.chromosome = this.chromosome.clone();
		return clone;
	}
	
	/**
	 * Retorna el cromosoma del genotipo. 
	 * @return chromosome
	 */
	public int[] getChromosome() {
		return chromosome;
	}
	
}
