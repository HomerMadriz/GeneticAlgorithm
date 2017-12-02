package lcll.org.gava;

import org.gava.Genotype;

public abstract class IntGenotype extends Genotype<Integer> {
	
	public abstract void    setGene(int index, int value);
	public abstract Integer getGene(int index);
	
}
