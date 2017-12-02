package TestGAVA;

import java.util.List;
//import java.util.Random;

import org.gava.Crossover;
import org.gava.GeneticAlgorithm;
import org.gava.IndividualFactory;
import org.gava.Mutator;
import org.gava.ObjectiveFunction;
import org.gava.Selector;

import lcll.org.gava.HierarchySelector;
import lcll.org.gava.MutualExchangeMutator;
import lcll.org.gava.OrderCrossover;
import lcll.org.gava.RouteFunction;
import lcll.org.gava.RouteIndividualFactory;
import lcll.org.gava.RouteMap;

public class RouteTest {

	public static void main(String[] args) {
		final int NODOS = 16;
		//Random rnd = new Random();
		GeneticAlgorithm<Integer, Integer> ga = new GeneticAlgorithm<>();
		RouteMap map = new RouteMap(NODOS);
		
		double[] pesosA = {0,3,4,2,5,3,1,1,4,4,2,2,3,2,5,4};
		double[] pesosB = {3,0,1,5,3,3,4,2,2,5,3,2,2,3,5,5};
		double[] pesosC = {4,1,0,2,5,3,3,5,5,5,5,5,4,1,4,1};
		double[] pesosD = {2,5,2,0,1,1,2,1,3,2,3,2,2,3,4,3};
		double[] pesosE = {5,3,4,1,0,3,3,2,2,1,1,5,2,2,5,5};
		double[] pesosF = {3,3,3,1,3,0,4,3,1,1,3,5,3,4,1,3};
		double[] pesosG = {1,4,3,2,3,4,0,3,2,2,1,2,3,3,5,5};
		double[] pesosH = {1,2,5,1,2,3,3,0,1,4,5,5,1,4,4,2};
		double[] pesosI = {4,2,5,3,2,1,2,1,0,2,4,4,3,1,1,3};
		double[] pesosJ = {4,5,5,2,1,1,2,4,2,0,3,3,1,3,5,5};
		double[] pesosK = {2,3,5,3,1,3,1,5,4,3,0,2,3,1,2,4};
		double[] pesosL = {2,2,5,2,5,5,2,5,4,3,2,0,5,3,2,5};
		double[] pesosM = {3,2,3,2,2,3,3,1,2,1,3,5,0,5,5,1};
		double[] pesosN = {2,3,1,3,2,4,3,4,1,3,1,3,5,0,2,5};
		double[] pesosO = {5,5,4,5,5,1,5,4,1,5,2,2,5,2,0,5};
		double[] pesosP = {4,5,1,3,5,3,5,2,3,5,4,5,1,5,5,0};
		
		map.setRoute(0, pesosA);
		map.setRoute(1, pesosB);
		map.setRoute(2, pesosC);
		map.setRoute(3, pesosD);
		map.setRoute(4, pesosE);
		map.setRoute(5, pesosF);
		map.setRoute(6, pesosG);
		map.setRoute(7, pesosH);
		map.setRoute(8, pesosI);
		map.setRoute(9, pesosJ);
		map.setRoute(10, pesosK);
		map.setRoute(11, pesosL);
		map.setRoute(12, pesosM);
		map.setRoute(13, pesosN);
		map.setRoute(14, pesosO);
		map.setRoute(15, pesosP);
		
		System.out.println(map);
						
		ga.setGenerations(160_000); // No. NODOS * 10,000
		ga.setPopulationSize(8);
		
		ObjectiveFunction<Integer>          function  = new RouteFunction(map.getMap(), 5, NODOS);
		IndividualFactory<Integer, Integer> factory   = new RouteIndividualFactory(NODOS);
		Selector<Integer, Integer>          selector  = new HierarchySelector<>();
		Crossover<Integer>                 crossover = OrderCrossover.getInstance();
		Mutator<Integer>                   mutator   = MutualExchangeMutator.getInstance();
		
		ga.setObjectiveFunction(function);
		ga.setIndividualFactory(factory);
		ga.setSelector (selector);		
		ga.setCrossover(crossover); 
		ga.setMutator  (mutator);
		
		ga.run();
		
		List<Integer> best = ga.getBest();
		System.out.printf("Best Route: " + best);
		double fx = function.function(best);
		System.out.printf("\npesoTotal =  %.8f\n", fx);
	}

}
