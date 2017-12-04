package lcll.org.gava;

import org.gava.Genotype;

/**
 * Clase que extiende a Genotype, indica que los genotipos utilizados en el algoritmo genético serán de tipo Integer.  
 * Esta clase de genotipos es útil para resolver el problema del agente viajero. 
 * 
 * @author Omar Antonio Madriz Almanza; Mariana Chavez Medina; Jose Luis Torrentera Arroniz
 * @version 1.0
 *
 */

public abstract class IntGenotype extends Genotype<Integer> {
	
	public abstract void    setGene(int index, Integer value);
	public abstract Integer getGene(int index);
	
}
