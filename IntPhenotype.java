package lcll.org.gava;

import org.gava.Phenotype;
/**
 * Clase que extiende a Phenotype, indica que los fenotipos utilizados en el algoritmo genético serán de tipo Integer.  
 * Esta clase de fenotipos es útil para resolver el problema del agente viajero. 
 * 
 * @author Omar Antonio Madriz Almanza; Mariana Chavez Medina; Jose Luis Torrentera Arroniz
 * @version 1.0
 *
 */


public abstract class IntPhenotype extends Phenotype<Integer> {
	@Override
	public abstract void setValue(int index, Integer value);
	
	@Override
	public abstract Integer getValue(int index);
}
