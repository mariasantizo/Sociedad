package datos;

/**
 * DBusqueda binaria
 * @author mariasantizo y malensanz
 * @version 1
 * @since 1
 */

import java.util.ArrayList;

public class SearchBinary implements Buscable {

	@Override
	public Object buscar(ArrayList array, Object o) {
		/*int start=0;
		int end=array.size()-1;
		while (start<=end){
			int mid=(start+end)/2;
			if (array.get(mid)==o){
				System.out.println(mid);
				return mid;
			}else if (o<array.get(mid)) {
				end= mid-1;
			}else{
				start=mid+1;
			}
			}
		System.out.println("No esta ese elemento en el array");*/
		return -1;
	}
}
