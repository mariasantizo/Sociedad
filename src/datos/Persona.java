/**
 * Representa cada persona (es una clase abstracta)
 * @author mariasantizo
 * @version 1
 * @since 1
 */


package datos;

public abstract class Persona {
	private String dni;
	private String nombre;
	private String apellido;
	private int telefono;
	private String direccion;
	private String contrasena;
	
	public Persona(String dni, String nombre, String apellido, int telefono, String direccion, String contrasena) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.direccion = direccion;
		this.contrasena= contrasena;
	}
	
	public Persona() {
		
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/**
	 * Utilizaremos este método para implementar el polimorfismo
	 * @author mariasantizo
	 */
	public void calcularCuota() {
		
	}
	
	
	
	
}
