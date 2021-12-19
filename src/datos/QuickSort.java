package datos;

import java.util.ArrayList;
import java.util.Collections;

public class QuickSort <t extends Comparable<t>> implements Ordenable <t>{

	public int pivot(ArrayList<t> array, int low, int high) {
		t pivot = array.get(high);
		int leftwall = low-1;
		
		for (int i=low; i<=high-1; i++) {
			if (pivot.comparar(array.get(i))>=0) {
				leftwall += 1;
				Collections.swap(array, leftwall, i);
			}
		Collections.swap(array, leftwall+1, high);
		}
		return leftwall+1;
	}

	@Override
	public ArrayList<t> ordenar(ArrayList<t> array, int low, int high) {
		// TODO Auto-generated method stub
		if (array.size()==1 || array.size()==0) {
		} else {
			if (low<high) {
				int p = 0;
				//1. Llamar a pivot
				p=pivot(array, low, high);
				//2. Llamar a QuickSort con la parte izquierda del array
				ordenar(array, low, p-1);
				//3. Llamar a QuickSort con la parte derecha del array
				ordenar(array, p+1, high);
			}
		}
		return array;
	}

}
