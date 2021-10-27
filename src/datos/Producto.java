package datos;

public class Producto {
	private String nombre; 
	private int codigo; 
	private TipoProducto tipo;
	
	
	public Producto(String nombre, int codigo, TipoProducto tipo) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.tipo = tipo;
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
	
	
}
