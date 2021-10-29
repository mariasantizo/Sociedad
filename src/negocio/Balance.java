/**
 * Representa el balance de la sociedad, lo usaremos para llevar la contabilidad
 * @author malensanz
 * @version 1
 * @since 1
 */

package negocio;

import java.util.Calendar;

public class Balance {
	private int codigo;
	private Calendar fecha;
	
	private double mobiliario;
	private double equipos;
	private Almacen almacen;
	private double clientes;
	private double caja;
	private double bancos;
	private double capitalSocial;
	private CuentaResultados resultado;
	private double credito;
	private double proveedores;
	
	public Balance(int codigo, Calendar fecha, double mobiliario, double equipos, Almacen almacen, double clientes,
			double caja, double bancos, double capitalSocial, CuentaResultados resultado, double credito, double proveedores) {

		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.mobiliario = mobiliario;
		this.equipos = equipos;
		this.almacen = almacen;
		this.clientes = clientes;
		this.caja = caja;
		this.bancos = bancos;
		this.capitalSocial = capitalSocial;
		this.resultado = resultado;
		this.credito = credito;
		this.proveedores = proveedores;
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


	public double getMobiliario() {
		return mobiliario;
	}


	public void setMobiliario(double mobiliario) {
		this.mobiliario = mobiliario;
	}

	public double getEquipos() {
		return equipos;
	}

	public void setEquipos(double equipos) {
		this.equipos = equipos;
	}


	public Almacen getAlmacen() {
		return almacen;
	}


	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}


	public double getClientes() {
		return clientes;
	}


	public void setClientes(double clientes) {
		this.clientes = clientes;
	}

	public double getCaja() {
		return caja;
	}


	public void setCaja(double caja) {
		this.caja = caja;
	}


	public double getBancos() {
		return bancos;
	}


	public void setBancos(double bancos) {
		this.bancos = bancos;
	}


	public double getCapitalSocial() {
		return capitalSocial;
	}


	public void setCapitalSocial(double capitalSocial) {
		this.capitalSocial = capitalSocial;
	}


	public CuentaResultados getResultado() {
		return resultado;
	}


	public void setResultado(CuentaResultados resultado) {
		this.resultado = resultado;
	}


	public double getCredito() {
		return credito;
	}


	public void setCredito(double credito) {
		this.credito = credito;
	}

	public double getProveedores() {
		return proveedores;
	}


	public void setProveedores(double proveedores) {
		this.proveedores = proveedores;
	}

}
