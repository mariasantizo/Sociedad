/**
 * Representa el balance de la sociedad, lo usaremos para llevar la contabilidad
 * @author malensanz
 * @version 2
 * @since 1
 */

package negocio;

import java.util.ArrayList;
import java.util.Calendar;

public class Balance implements Calculable <Balance> {
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
	private double valorBalance;
	
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
	
	
	
	
	public double getValorBalance() {
		return valorBalance;
	}


	public void setValorBalance(double valorBalance) {
		this.valorBalance = valorBalance;
	}


	/**
	 * Calcula el valor del balance, sumamos todas las cuentas del activo y lo cargamos en el atributo valorBalance
	 * @author malensanz
	 * @version 2
	 * @since 2
	 */
	public void calcularValorBalance (){
		this.valorBalance=this.mobiliario+this.equipos+this.clientes+this.almacen.getValor()+this.caja+this.bancos;
		
	}

	/**
	 * Comprueba que el valor total del balance calculado anteriormente coincide con el valor del pasivo y patrimonio neto
	 * @author malensanz
	 * @version 2
	 * @since 2
	 */
	public boolean comprobarValor(){
		if (this.valorBalance==(this.capitalSocial+this.resultado.getResultado()+this.credito+this.proveedores)){
		return true;
		}else{
		return false;
		}
	}


	@Override
	public void calcularGrafico(ArrayList<Balance> array) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void calcularTabla(ArrayList<Balance> array) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void calcularResumen(ArrayList<Balance> array) {
		// TODO Auto-generated method stub
		
	}
}
