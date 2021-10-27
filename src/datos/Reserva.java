/**
 * Representa cada reserva de la sociedad (recogerá el socio, la mesa y la fecha de la reserva)
 * @author mariasantizo
 * @version 1
 * @since 1
 */

package datos;

import java.util.Calendar;

public class Reserva {
	private Socio socio;
	private Mesa mesa;
	private Calendar fecha;
	private String horario;
	
	public Reserva(Socio socio, Mesa mesa, Calendar fecha, String horario) {
		super();
		this.socio = socio;
		this.mesa = mesa;
		this.fecha = fecha;
		this.horario = horario;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	
	
}
