package lcll.org.gava;



@SuppressWarnings("serial")
public class NotRouteFunctionException extends RuntimeException {

	public NotRouteFunctionException() {
	}

	public String toString() {
		return String.format("%s : %s",super.toString(),"A RouteFunction is needed.");
	}

}
