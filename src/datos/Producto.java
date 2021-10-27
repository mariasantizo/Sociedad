<<<<<<< HEAD
/**
 * Son los diferentes productos que encontraremos en nuestra sociedad
 * @author malensanz
 * @version 1
 * @since 1
 */


=======
>>>>>>> a480201 (Add producto)
package datos;

public class Producto {
	private String nombre; 
	private int codigo; 
	private TipoProducto tipo;
<<<<<<< HEAD
	private double precio;
	
	
	public Producto(String nombre, int codigo, TipoProducto tipo, double precio) {
=======
	
	
	public Producto(String nombre, int codigo, TipoProducto tipo) {
>>>>>>> a480201 (Add producto)
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.tipo = tipo;
<<<<<<< HEAD
		this.precio=precio;
=======
>>>>>>> a480201 (Add producto)
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
	
<<<<<<< HEAD
=======
	
	

>>>>>>> a480201 (Add producto)

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public TipoProducto getTipo() {
		return tipo;
	}


	public void setTipo(TipoProducto tipo) {
		this.tipo = tipo;
	}
<<<<<<< HEAD


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}
=======
>>>>>>> a480201 (Add producto)
	
	
}
