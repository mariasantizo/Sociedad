/**
 * Representa el inventario de todos los productos que vamos a tener en la sociedad
 * @author malensanz and mariasantizo
 * @version 2
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
	
	public Almacen(int codigo, Calendar fecha, ArrayList<Producto> productos) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.productos = productos;
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
	

/**
	 * Este método calcula el valor del almacén, sumando todos los precios de todos los productos
	 * @author mariasantizo
	 * @version 2
	 * @since 2
 */
	public void calcularAlmacen() {
		double valor = 0;
		for (int i=0; i<this.productos.size(); i++) {
			valor=valor+productos.get(i).getPrecio();
		}
		this.valor=valor;
	}
	
}
