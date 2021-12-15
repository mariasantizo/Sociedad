package datos;

public class QuickSort implements Ordenable{

	public static int pivot(int[] array, int low, int high) {
		int pivot = array[low];
		int leftwall = low;
		
		for (int i=low+1; i==high; i++) {
			if (array[i]<pivot) {
				int aux=0;
				aux=array[leftwall];
				array[leftwall]=array[i];
				array[i]=aux;
				leftwall += 1;
			}
		int aux=0;
		aux=pivot;
		pivot=array[leftwall];
		array[leftwall]=aux;
		}
		return leftwall;
	}
	
	
	@Override
	public int[] ordenar (int[] array, int low, int high) {
		if (array.length==1 || array.length==0) {
		} else {
			if (low<high) {
				//1. Llamar a pivot
				int p=0;
				p=pivot(array, low, high);
				//2. Llamar a quickSort con la parte izquierda del array
				ordenar(array, low, p);
				//3. Llamar a quickSort con la parte derecha del array
				ordenar(array, p+1, high);
			}
		}
		return array;
	}

}
