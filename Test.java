package TestGAVA;
import java.util.List;

import org.gava.BitDoubleIndividualFactory;
import org.gava.BitFlipMutator;
import org.gava.BitUniformCrossover;
import org.gava.Crossover;
import org.gava.GeneticAlgorithm;
import org.gava.IndividualFactory;
import org.gava.MatyasFunction;
import org.gava.McCormickFunction;
import org.gava.Mutator;
import org.gava.ObjectiveFunction;
import org.gava.RastriginFunction;
import org.gava.RouletteSelector;
import org.gava.Selector;
 
@SuppressWarnings("unused")
public class Test {
	
	public static void main(String[] args) {
		GeneticAlgorithm<Boolean, Double> ga = new GeneticAlgorithm<>();
		ga.setGenerations(1000);
		ga.setPopulationSize(1000);
		
		ObjectiveFunction<Double>          function  = MatyasFunction.getInstance();
		IndividualFactory<Boolean, Double> factory   = new BitDoubleIndividualFactory(
				                                             64, function.length(), -10, 10, -10, 10);
		Selector<Boolean, Double>          selector  = new RouletteSelector<Boolean, Double>();
		Crossover<Boolean>                 crossover = BitUniformCrossover.getInstance();
		Mutator<Boolean>                   mutator   = BitFlipMutator.getInstance();
		
		ga.setObjectiveFunction(function);
		ga.setIndividualFactory(factory);
		ga.setSelector (selector);		
		ga.setCrossover(crossover); 
		ga.setMutator  (mutator);
		
		ga.run();
		
		List<Double> best = ga.getBest();
		System.out.printf("  bestX  = <%.7f, %.7f>\n", best.get(0), best.get(1));
		double fx = function.function(best);
		System.out.printf("f(bestX) =  %.8f\n", fx);
		
	}

}
