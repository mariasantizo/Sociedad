package datos;

import java.util.ArrayList;

/**
 * Desciende de la clase Persona, representa cada socio de la sociedad
 * @author mariasantizo y malensanz
 * @version 2
 * @since 1
 */
public class Socio extends Persona{

	private int numeroSocio;
	private String tipoCuota;
	private int cuota;
	
	
	public Socio(String dni, String nombre, String apellido, int telefono, String direccion, String contrasena, int numeroSocio, String tipoCuota) {
		super(dni, nombre, apellido, telefono, direccion, contrasena);
		this.numeroSocio=numeroSocio;
		this.tipoCuota=tipoCuota;
	}
	
	public Socio(String dni, String nombre, String apellido, int telefono, String direccion, String contrasena, int numeroSocio, String tipoCuota, int cuota) {
		super(dni, nombre, apellido, telefono, direccion, contrasena);
		this.numeroSocio=numeroSocio;
		this.tipoCuota=tipoCuota;
		this.cuota=cuota;
	}
	
	public Socio(String dni, String nombre, String apellido, int telefono, String direccion, int numeroSocio, String tipoCuota, int cuota) {
		super(dni, nombre, apellido, telefono, direccion);
		this.numeroSocio=numeroSocio;
		this.tipoCuota=tipoCuota;
		this.cuota=cuota;
	}

	public Socio(String tipoCuota) {
		super();
		this.tipoCuota=tipoCuota;
	}
	
	public Socio() {
		super();
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

	
	
/**
	 * Este método calcula la cuota a aportar de cada socio, dependiendo de la frecuencia del pago
	 * @author mariasantizo
	 * @version 2
	 * @since 2
 */
	@Override
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
	
	@Override
	public String toString() {
		return "numeroSocio";
		
	}
	
}
