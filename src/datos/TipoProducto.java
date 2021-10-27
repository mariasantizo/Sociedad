/**
 * Representa los tipos de productos que tendremos en el almacén
 * @author malensanz
 * @version 1
 * @since 1
 */



package datos;

public class TipoProducto {
	private String nombre;
	private int codigo;
	
	public TipoProducto(String nombre, int codigo) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
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
	
	

}
