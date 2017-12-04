package lcll;

import java.util.Random;
import org.gava.Crossover;
import org.gava.Genotype;


public class OrderCrossover extends Crossover<Integer> {

	private static OrderCrossover instance = null;

	private Random random = new Random();


	/**
	 * Se crean dos arreglos de enteros con la información del genotipo padre y madre
	 */
	@Override
	public void cross(Genotype<Integer> genotypePadre, Genotype<Integer> genotypeMadre) {
		int index1 = random.nextInt(genotypePadre.length() - 2) + 1;
		int index2;
		int t;

		do {
			index2 = random.nextInt(genotypePadre.length());
		}while(index1 == index2);

		if(index2 < index1) {
			t = index1;
			index1 = index2;
			index2 = t;
		}

		int[] madre = new int[genotypeMadre.length()];
		int[] padre = new int[genotypePadre.length()];

		for(int i = 0; i < genotypePadre.length(); i++) {
			madre[i] = genotypeMadre.getGene(i);
			padre[i] = genotypePadre.getGene(i);
		}

		Crossover(genotypeMadre, padre, madre, index1, index2);
		Crossover(genotypePadre, madre, padre, index1, index2);

	} 

	/**
	 * Se hace singleton
	 * @return instancia de la cruza
	 */
	public static OrderCrossover getInstance() {
		if(instance == null) instance = new OrderCrossover();
		return instance;
	}

	/**
	 * Se fija la subcadena fija en el rango de los índices aleatorios
	 * Se llena el nuevo arreglo con la informacion del genotipo padre/madre contrario
	 * Se crea arreglo de booleans a manera de banderas para saber si el entero con el que se 
	 * desea llenar el siguiente espacio, ya está contenido en el nuevo genotipo.
	 * @param genotype El genotipo a modificar
	 * @param padre Arreglo con la información del padre
	 * @param madre Arreglo con la información de la madre
	 * @param index1 Indice donde comienza la subcadena fija
	 * @param index2 Indice donde termina la subcadena fija
	 */
	private void Crossover(Genotype<Integer> genotype, int[] padre, int[] madre, int index1, int index2) {
		boolean[] insert = new boolean[madre.length - 1];
		int posHijo = 1;

		insert[0] = true;

		/**
		 * Se cambia a verdadero las posiciones de la subcadena fija
		 */
		for(int i = index1 ; i <= index2; i++) {
			insert[madre[i] - 1] = true;
		}


		for(int i = 0; i< padre.length; i++) {
			if(insert[padre[i] - 1] ==  false) {
				for(int j = posHijo; j < padre.length - 1;) {
					if(!(j >= index1 && j <= index2)) {
						genotype.setGene(j, padre[i]);
						posHijo = j + 1;
						break;
					}else
						j++;
				}
			}
		}
	}
}