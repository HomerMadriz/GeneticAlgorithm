package org.gava;

import java.util.List;

public interface ObjectiveFunction<P> {

	int length();
	double f(List<P> args);
	
}
