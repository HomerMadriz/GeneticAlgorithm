package org.gava;

import java.util.List;

public interface Selector<G, P> {
	
	List<Individual<G, P>> select(List<Individual<G, P>> population);
	
}
