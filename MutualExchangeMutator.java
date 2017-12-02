package lcll.org.gava;

import java.util.Random;

import org.gava.Genotype;
import org.gava.Mutator; 

public class MutualExchangeMutator extends Mutator<Integer> {

	private static MutualExchangeMutator instance = null;
	private Random random = new Random();
	
	@Override
	public void mutate(Genotype<Integer> genotype) {
		int index1 = random.nextInt((genotype.length() - 2))+ 1; 
		int index2;
		int tmp;
		
		do {
		index2 = random.nextInt(genotype.length() - 2) + 1;
		}while(index1 == index2);
		
		tmp = genotype.getGene(index1);
		genotype.setGene(index1, genotype.getGene(index2));
		genotype.setGene(index2, tmp);
	}
	
	public static MutualExchangeMutator getInstance() {
		if(instance == null) instance = new MutualExchangeMutator();
		return instance;
	}

}
