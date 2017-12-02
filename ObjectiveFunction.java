package org.gava;

import java.util.List;

public interface ObjectiveFunction<P> {

	int length();
	P function(List<P> args);
	
}
