package datos;

import java.util.ArrayList;

public interface Ordenable <t> {
	public ArrayList<t> ordenar (ArrayList<t> array, int low, int high);

}
