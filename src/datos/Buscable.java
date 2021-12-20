package datos;

import java.util.ArrayList;

/**
 * Interfaz buscable
 * @author mariasantizo y malensanz
 * @version 1
 * @since 1
 */

public interface Buscable <t>{
	public Object buscar (ArrayList <t> array, t objeto);

}
