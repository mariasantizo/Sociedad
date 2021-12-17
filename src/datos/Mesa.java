/**
 * Representa cada mesa que se encuentra en la sociedad
 * @author mariasantizo
 * @version 1
 * @since 1
 */

package datos;

public class Mesa {
	private int codigoMesa;
	private int capacidad;
	
	public Mesa(int codigoMesa, int capacidad) {
		super();
		this.codigoMesa = codigoMesa;
		this.capacidad = capacidad;
	}
	
	public Mesa () {
		super();
	}

	public int getCodigoMesa() {
		return codigoMesa;
	}

	public void setCodigoMesa(int codigoMesa) {
		this.codigoMesa = codigoMesa;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	@Override
	public String toString() {
		return "codigoMesa";
		
	}
	
}
