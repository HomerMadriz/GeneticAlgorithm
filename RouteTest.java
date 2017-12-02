package TestGAVA;

import org.gava.BitDoubleIndividualFactory;
import org.gava.GeneticAlgorithm;
import org.gava.IndividualFactory;
import org.gava.ObjectiveFunction;
import org.gava.RouteFunction;

public class RouteTest {

	public static void main(String[] args) {
		GeneticAlgorithm<Integer, Integer> ga = new GeneticAlgorithm<>();
		RouteMap<Integer> map = new RouteMap<>(10);
		
		ga.setGenerations(100_000); // No. gen * 10,000
		ga.setPopulationSize(5);
		
		ObjectiveFunction<Integer>          function  = new RouteFunction(map.getMap());
		IndividualFactory<Boolean, Double> factory   = new BitDoubleIndividualFactory(
				                                             64, function.length(), -10, 10, -10, 10);

	}

}
