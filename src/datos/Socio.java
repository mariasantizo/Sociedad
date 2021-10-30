/**
 * Desciende de la clase Persona, representa cada socio de la sociedad
 * @author mariasantizo
 * @version 1
 * @since 1
 */


package datos;

public class Socio extends Persona{

	private int numeroSocio;
	private String tipoCuota;
	private int cuota;
	
	
	public Socio(String dni, String nombre, String apellido, int telefono, String direccion, int numeroSocio, String tipoCuota) {
		super(dni, nombre, apellido, telefono, direccion);
		this.numeroSocio=numeroSocio;
		this.tipoCuota=tipoCuota;
	}


	public int getNumeroSocio() {
		return numeroSocio;
	}


	public void setNumeroSocio(int numeroSocio) {
		this.numeroSocio = numeroSocio;
	}


	public String getTipoCuota() {
		return tipoCuota;
	}


	public void setTipoCuota(String tipoCuota) {
		this.tipoCuota = tipoCuota;
	}
	
	
	
	public int getCuota() {
		return cuota;
	}


	public void setCuota(int cuota) {
		this.cuota = cuota;
	}


	public void calcularCuota() {
		int cuotaAnual=960;
		switch (tipoCuota) {
		case "Anual": 
			this.cuota=cuotaAnual;
			break;
		case "Semestral":
			this.cuota=cuotaAnual/2;
			break;
		case "Trimestral":
			this.cuota=cuotaAnual/4;
			break;
		case "Mensual":
			this.cuota=cuotaAnual/12;
			break;
		}
	}
	
}
