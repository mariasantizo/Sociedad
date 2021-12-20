package datos;

import java.util.ArrayList;

/**
 * MergeSort genérico
 * @author mariasantizo y malensanz
 * @version 1
 * @since 1
 */
import java.util.LinkedList;

public class MergeSort <t extends Comparable<t>> implements Ordenable <t> {

	public ArrayList<t> merge(ArrayList<t> arrayIzquierda, ArrayList<t> arrayDerecha)	{
		ArrayList<t> arrayResultado = new ArrayList<t>();
		while (arrayIzquierda.size()>0 && arrayDerecha.size()>0) {
			//Comparar la primera posición
			if (arrayIzquierda.get(0).comparar(arrayDerecha.get(0))==1){
				//Si valor de arrayDerecha es menor, pasa el elemento de arrayDerecha 
				arrayResultado.add(arrayDerecha.get(0));
				//Eliminamos ese elemento del array original para compararlo con el siguiente
				arrayDerecha.remove(0);
			} else {
				//Si valor de arrayIzquierda es menor o si son iguales, pasa el elemento de arrayIzquierda
				arrayResultado.add(arrayIzquierda.get(0));
				//Eliminamos ese elemento del array original para compararlo con el siguiente
				arrayIzquierda.remove(0);
			}
		}
		//Añadir los elementos restantes que no se han comparado
		while (arrayIzquierda.size()>0) {
			arrayResultado.add(arrayIzquierda.get(0));
			arrayIzquierda.remove(0);
		}
		while (arrayDerecha.size()>0) {
			arrayResultado.add(arrayDerecha.get(0));
			arrayDerecha.remove(0);
		}
		return arrayResultado;	
	}

	
	//trivial: array.lenght==1
	//no trivial: partir, m izq, m der, mezclar
	
	@Override
	public ArrayList<t> ordenar(ArrayList<t> array, int low, int high) {
		// TODO Auto-generated method stub
		ArrayList<t> arrayIzquierda = new ArrayList<t>();
		ArrayList<t> arrayDerecha = new ArrayList<t>();
		if (array.size()==1) {
		} else {
			int index =0;
			for (t elemento: array) {
				if(index<array.size()/2) {
					arrayIzquierda.add(elemento);
				} else {
					arrayDerecha.add(elemento);
				}
				index += 1;
			}
			arrayIzquierda=ordenar(arrayIzquierda, low, high/2);
			arrayDerecha=ordenar(arrayDerecha, (high/2)+1, high);
			array=merge(arrayIzquierda, arrayDerecha);
		}
		return array;
	}
	
}
