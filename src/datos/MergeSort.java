package datos;

import java.util.ArrayList;
import java.util.LinkedList;

public class MergeSort implements Busqueda {

	public int[] merge(int[] array, int low1, int high1, int low2, int high2)	{
		int[] arrayResultado = new int [(high1-low1)+(high2-low2)];
		int index=0;
		while (low1<=high1 && low2<=high2) {
			if (array[low1]>array[low2]) {
				arrayResultado[index]=array[low2];
				low2 += 1;
			} else {
				arrayResultado[index] = array[low1];
				low1 += 1;
			}
			index += 1;
		}
		while (low1<=high1) {
			arrayResultado[index]=array[low1];
			low1 += 1;
			index += 1;
		}
		while (low2<=high2) {
			arrayResultado[index]=array[low2];
			low2 += 1;
			index += 1;
		}
		return arrayResultado;	
	}
	
	//trivial: array.lenght==0 or ==1
	//no trivial: partir, m izq, m der, mezclar
	
	@Override
	public int[] buscar(int[] array, int low, int high) {
		// TODO Auto-generated method stub
		int[] arrayResultado = new int[array.length];
		if (array.length==1 || array.length==0) {
		} else {
			buscar(array, low, high/2);
			buscar(array, (high/2)+1, high);
			arrayResultado=merge(array, low, high/2, (high/2)+1, high);
		}
		return arrayResultado;
	}
}
