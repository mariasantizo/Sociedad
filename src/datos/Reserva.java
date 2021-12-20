/**
 * Representa cada reserva de la sociedad (recogerá el socio, la mesa y la fecha de la reserva)
 * @author mariasantizo y malensanz
 * @version 1
 * @since 1
 */

package datos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Reserva implements Comparable <Reserva> {
	private int codigo;
	private Socio socio;
	private Mesa mesa;
	private Calendar fecha;
	private String horario;
	private ArrayList<Producto> productos;
	private double precio;
	
	public Reserva(int codigo, Socio socio, Mesa mesa, Calendar fecha, String horario) {
		super();
		this.codigo=codigo;
		this.socio = socio;
		this.mesa = mesa;
		this.fecha = fecha;
		this.horario = horario;
	}
	
	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public void pagar () {
		double precio = 0;
		for (int i=0; i<this.productos.size(); i++) {
			precio = precio + productos.get(i).getPrecio();
		}
		this.precio=precio;		
	}

	@Override
	public int comparar(Reserva objeto2) {
		// TODO Auto-generated method stub
		int resultado=0;
		if (this.fecha.after(objeto2.getFecha())) {
			resultado=1;
		} 
		else if (this.fecha.before(objeto2.getFecha())) {
			resultado=-1;
		}
		return resultado;
	}
	
	@Override
	public String obtenerValorComparable() {
		return this.getFecha().toString();
	}
	
	@Override
	public String toString() {
		return " - Mesa: " + mesa.getCodigoMesa()+" - " +fecha.get(Calendar.YEAR) +" / " + fecha.get(Calendar.MONTH) +" / " + fecha.get(Calendar.DATE);	
	}

	@Override
	public void establecerValorComparable(String valor) {
		// TODO Auto-generated method stub
		String[] array = valor.split("/");
		Calendar c = new GregorianCalendar(Integer.parseInt(array[0]), Integer.parseInt(array[1]), Integer.parseInt(array[2]));
		this.fecha=c;
	}
	
}
