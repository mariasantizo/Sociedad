package datos;

import java.util.ArrayList;
import java.util.LinkedList;

public class MergeSort <t extends Comparable<t>> implements Ordenable <t> {

	public ArrayList<t> merge(ArrayList<t> array, int low1, int high1, int low2, int high2)	{
		ArrayList<t> arrayResultado = new ArrayList<t>();
		while (low1<=high1 && low2<=high2) {
			if (array.get(low1).comparar(array.get(low2))==1){
				arrayResultado.add(array.get(low2));
				low2 += 1;
			} else {
				arrayResultado.add(array.get(low1));
				low1 += 1;
			}
		}
		while (low1<=high1) {
			arrayResultado.add(array.get(low1));
			low1 += 1;
		}
		while (low2<=high2) {
			arrayResultado.add(array.get(low2));
			low2 += 1;
		}
		return arrayResultado;	
	}

	
	//trivial: array.lenght==0 or ==1
	//no trivial: partir, m izq, m der, mezclar
	
	@Override
	public ArrayList<t> ordenar(ArrayList<t> array, int low, int high) {
		// TODO Auto-generated method stub
		ArrayList<t> arrayResultado = new ArrayList<t>();
		if (array.size()==1 || array.size()==0) {
		} else {
			ordenar(array, low, high/2);
			ordenar(array, (high/2)+1, high);
			arrayResultado=merge(array, low, high/2, (high/2)+1, high);
		}
		return arrayResultado;
	}
	
}
