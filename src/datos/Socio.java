package datos;

public class Socio extends Persona{

	private int numeroSocio;
	
	
	public Socio(String dni, String nombre, String apellido, int telefono, String direccion, int numeroSocio) {
		super(dni, nombre, apellido, telefono, direccion);
		this.numeroSocio=numeroSocio;
	}


	public int getNumeroSocio() {
		return numeroSocio;
	}


	public void setNumeroSocio(int numeroSocio) {
		this.numeroSocio = numeroSocio;
	}
	
	
}
