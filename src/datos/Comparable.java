package datos;

/**
 * Interfaz comparable que implementaremos en otras clases
 * @author mariasantizo y malensanz
 * @version 1
 * @since 1
 */

public interface Comparable <t> {
	public int comparar(t objeto2);
	public String obtenerValorComparable();
	public void establecerValorComparable(String valor);
}
