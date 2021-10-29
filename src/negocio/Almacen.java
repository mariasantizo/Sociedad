/**
 * Representa el inventario de todos los productos que vamos a tener en la sociedad
 * @author malensanz
 * @version 1
 * @since 1
 */


package negocio;

import java.util.ArrayList;
import java.util.Calendar;

import datos.Producto;

public class Almacen {
	private int codigo;
	private Calendar fecha;
	private ArrayList<Producto> productos;
	private double valor;
	
	public Almacen(int codigo, Calendar fecha, ArrayList<Producto> productos, double valor) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.productos = productos;
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
