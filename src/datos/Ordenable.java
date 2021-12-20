package datos;

/**
 * Interfaz ordenable
 * @author mariasantizo y malensanz
 * @version 1
 * @since 1
 */

import java.util.ArrayList;

public interface Ordenable <t> {
	public ArrayList<t> ordenar (ArrayList<t> array, int low, int high);

}
