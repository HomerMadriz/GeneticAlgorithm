package lcll;


import java.util.Collections;
import java.util.List;

import org.gava.Individual;
import org.gava.RouletteSelector;
import org.gava.Selector;

public class HierarchySelector<G,P> implements Selector<G, P> {

	/**
	 * Se ordenan los individuos de la Lista y se pasan por la ruleta
	 */
	@Override
	public List<Individual<G, P>> select(List<Individual<G, P>> population) {
		RouletteSelector<G, P> roulette = new RouletteSelector<>();
		Collections.sort(population);
		return roulette.select(population);
	}

}