package datos;

import java.util.ArrayList;

public class QuickSort <t extends Comparable<t>> implements Ordenable <t>{

	public int pivot(ArrayList<t> array, int low, int high) {
		t pivot = array.get(low);
		int leftwall = low;
		
		for (int i=low+1; i==high; i++) {
			if (pivot.comparar(array.get(i))==1) {
				t aux=array.get(leftwall);
				array.set(leftwall, array.get(i));
				array.set(i, aux);
				leftwall += 1;
			}
		t aux=pivot;
		pivot=array.get(leftwall);
		array.set(leftwall, aux);
		}
		return leftwall;
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
				ordenar(array, low, p);
				//3. Llamar a QuickSort con la parte derecha del array
				ordenar(array, p+1, high);
			}
		}
		return array;
	}

}
