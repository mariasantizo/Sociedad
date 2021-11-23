package datos;

import java.util.ArrayList;

/**
 * Este método ordena un array utilizando el método de la burbuja
 * @author mariasantizo
 * @param Un array de enteros
 * @return El array ordenado
 */
public class Recursividad {
	public static int[] algoritmoBurbuja(int[] array) {
		for (int i=0; i<array.length-1; i++) {
			for (int j=0; j<array.length-1-i; j++) {
				if (array[j]>array[j+1]) {
					int temp = array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
		return array;
	}
	
	public static Object busquedaBinaria(ArrayList<Object> array) {
		
		return null;
	}
	
	public static void main(String[] args) {
		/*int[] array = {1, 8, 30, 4, 0};
		array=algoritmoBurbuja(array);
		for (int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}*/
	}
	
}
