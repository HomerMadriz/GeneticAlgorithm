package lcll.org.gava;

import org.gava.Genotype;
import org.gava.Individual;
import org.gava.IndividualFactory;
import org.gava.Phenotype;

/** Esta clase es encarga de la creación de objetos de la clase RouteIndividual
 * @author Mariana Chavez, Omar Madriz, José Luis Torrentera
 *
 */
public class RouteIndividualFactory extends IndividualFactory<Integer, Integer> {
	
	private int length; 
	
	
	/** Constructor de la clase RouteIndividualFactory
	 * @param length -Tamaño de las rutas a crear.
	 */
	public RouteIndividualFactory(int length) {
		this.length = length;
	}
	
	@Override
	public Individual<Integer, Integer> create() {
		Genotype<Integer> genotype = new RouteGenotype(this.length);
		Phenotype<Integer> phenotype = new RoutePhenotype(this.length);
		genotype.randomize();
		RouteIndividual individual = new RouteIndividual(genotype, phenotype);
		return individual;
	}

}
