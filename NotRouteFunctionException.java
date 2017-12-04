package lcll.org.gava;



/** Excepción, alerta sobre la necesidad de poner RouteFunctionException
 * @author Mariana Chavez, Omar Madriz, José Luis Torrentera
 *
 */

@SuppressWarnings("serial")
public class NotRouteFunctionException extends RuntimeException {

	/** Constructor de la clase
	 * 
	 */
	public NotRouteFunctionException() {
	}

 public String toString() {
		return String.format("%s : %s",super.toString(),"A RouteFunction is needed.");
	}

}
