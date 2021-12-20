package datos;

import java.util.ArrayList;

/**
 * Este método ordena un array utilizando el método de la burbuja
 * @author mariasantizo y malensanz
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
	
	public static Object searchBinary (ArrayList <Object> array, Object o){
			return null;
			}
	
	/**
	 * Busca un número concreto del array 
	 */
	public static int busquedaBinaria(int[] array, int x) {
		// Initial condition expects Array is sorted
		int start=0;
		int end=array.length-1;
		while (start<=end){
			int mid=(start+end)/2;
			if (array[mid]==x){
				System.out.println(mid);
				return mid;
			}else if (x<array[mid]) {
				end= mid-1;
			}else{
				start=mid+1;
			}
			}
		System.out.println("No esta ese numero en el array");
		return -1;
		}
	
	/**
	 * Coge un numero que se quede en medio. Los elementos de la izquierda serán menores y los de la derecha mayores.
	 */
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
	
	public static int[] quickSort(int[] array, int low, int high) {
		if (array.length==1) {
		} else {
			if (low<high) {
				//1. Llamar a pivot
				int p=0;
				p=pivot(array, low, high);
				//2. Llamar a quickSort con la parte izquierda del array
				quickSort(array, low, p);
				//3. Llamar a quickSort con la parte derecha del array
				quickSort(array, p+1, high);
			}
		}
		return array;
	}
	
	/**
	 * Combina dos arrays dejandolos ordenados
	 */
	public static void merge() {
		
	}
	
	public static int[] mergeSort(int[] array, int indiceInicial, int indiceFinal) {
		if (array.length==1) {
			
		} else {
			//1. Partir array en dos
			int index = (array.length)/2;
			//2. Llamar a mergeSort con la parte izquierda del array
			int[] l = mergeSort(array, 0, index);
			//3. Llamar a mergeSort con la parte derecha del array
			int[] r = mergeSort(array, index, array.length);
			//4. Llamar a función merge
			//Return merge (l, r)
			
		}
		return array;
	}
	
	public static void main(String[] args) {
		/*int[] array = {1, 8, 30, 4, 0};
		array=algoritmoBurbuja(array);
		for (int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}*/
		
		
		/*int[] array={1, 4, 8, 12, 25};
		busquedaBinaria(array, 0);*/
	}
}
