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
	private float mobiliario;
	private float equipos;
	private Almacen almacen;
	private float clientes;
	private float caja;
	private float bancos;
	private float capitalSocial;
	private CuentaResultados resultado;
	private float credito;
	private float proveedores;
	
	public Balance(int codigo, Calendar fecha, float mobiliario, float equipos, Almacen almacen, float clientes,
			float caja, float bancos, float capitalSocial, CuentaResultados resultado, float credito, float proveedores) {
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


	public float getMobiliario() {
		return mobiliario;
	}


	public void setMobiliario(float mobiliario) {
		this.mobiliario = mobiliario;
	}


	public float getEquipos() {
		return equipos;
	}


	public void setEquipos(float equipos) {
		this.equipos = equipos;
	}


	public Almacen getAlmacen() {
		return almacen;
	}


	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}


	public float getClientes() {
		return clientes;
	}


	public void setClientes(float clientes) {
		this.clientes = clientes;
	}


	public float getCaja() {
		return caja;
	}


	public void setCaja(float caja) {
		this.caja = caja;
	}


	public float getBancos() {
		return bancos;
	}


	public void setBancos(float bancos) {
		this.bancos = bancos;
	}


	public float getCapitalSocial() {
		return capitalSocial;
	}


	public void setCapitalSocial(float capitalSocial) {
		this.capitalSocial = capitalSocial;
	}


	public CuentaResultados getResultado() {
		return resultado;
	}


	public void setResultado(CuentaResultados resultado) {
		this.resultado = resultado;
	}


	public float getCredito() {
		return credito;
	}


	public void setCredito(float credito) {
		this.credito = credito;
	}


	public float getProveedores() {
		return proveedores;
	}


	public void setProveedores(float proveedores) {
		this.proveedores = proveedores;
	}

}
