package datos;

import java.util.ArrayList;

public class BubbleSort <t extends Comparable<t>> implements Ordenable<t> {
	
	@Override
	public ArrayList<t> ordenar(ArrayList<t> array, int low, int high) {
		if (high==0) {
		} else {
			for (int i=0; i<high; i++) {
				if (array.get(i).comparar(array.get(i+1))==1) {
					String aux = array.get(i).obtenerValorComparable();
					array.get(i).establecerValorComparable(array.get(i+1).obtenerValorComparable());
					array.get(i+1).establecerValorComparable(aux);
				}
			}
			ordenar(array, low, high-1);
		}
		/*for (int i=0; i<array.length-1; i++) {
			for (int j=0; j<array.length-1-i; j++) {
				if (array[j]>array[j+1]) {
					int temp = array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}*/
		return array;
	}
	
}


	