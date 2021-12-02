/**
 * Son los diferentes productos que encontraremos en nuestra sociedad
 * @author malensanz
 * @version 1
 * @since 1
 */

package datos;

import java.util.ArrayList;

public class Producto {
	private String nombre; 
	private int codigo; 
	private TipoProducto tipo;
	private double precio;
	private int tipoAux;
	
	public Producto(String nombre, int codigo, TipoProducto tipo, double precio) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.tipo = tipo;
		this.precio=precio;
	}

	public Producto(String nombre, int codigo, int tipo, double precio) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.tipoAux = tipo;
		this.precio=precio;
		
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public TipoProducto getTipo() {
		return tipo;
	}


	public void setTipo(TipoProducto tipo) {
		this.tipo = tipo;
	}

	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public void convertirTipo (ArrayList<TipoProducto> tipos) {
		for (TipoProducto t: tipos) {
			if (t.getCodigo()==this.tipoAux) {
				this.tipo=t;
			}
		}
	}
	
}
