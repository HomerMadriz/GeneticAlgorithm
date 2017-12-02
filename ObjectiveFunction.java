package org.gava;

import java.util.List;

public interface ObjectiveFunction<P> {

	int length();
	Double function(List<P> args);
	
}
