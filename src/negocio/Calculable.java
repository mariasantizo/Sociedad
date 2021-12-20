/**
 * Interfaz calculable
 * @author mariasantizo y malensanz
 * @version 1
 * @since 1
 */

package negocio;

import java.util.ArrayList;

public interface Calculable <t>{
	public void calcularGrafico(ArrayList<t> array);
	public void calcularTabla(ArrayList<t> array);
	public void calcularResumen(ArrayList<t> array);
}
