/**
 * Desciende de la clase Persona, representa cada administrador de la sociedad
 * Representa cada persona (es una clase abstracta)
 * @author mariasantizo
 * @version 1
 * @since 1
 */


package datos;

public class Administrador extends Persona {

	private double salario;
	
	public Administrador(String dni, String nombre, String apellido, int telefono, String direccion, String contrasena) {
		super(dni, nombre, apellido, telefono, direccion, contrasena);
		// TODO Auto-generated constructor stub
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	/**
	 * Calcula el salario de cada administrador
	 * @author mariasantizo
	 */
	@Override
	public void calcularCuota() {
		int salarioAnual = 18000;
		this.salario=salarioAnual/14;
	}
	
}
