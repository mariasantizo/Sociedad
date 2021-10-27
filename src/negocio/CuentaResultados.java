/**
 * Representa todos los gastos e ingresos de la sociedad
 * @author malensanz
 * @version 1
 * @since 1
 */

package negocio;

import java.util.Calendar;

public class CuentaResultados {
	private int codigo;
	private Calendar fecha;
	private double ingresoCuota;
	private double ingresoReservas;
	private double gastoCompras;
	private double otrosGastos;
	
	public CuentaResultados(int codigo, Calendar fecha, double ingresoCuota, double ingresoReservas, double gastoCompras,
			double otrosGastos) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.ingresoCuota = ingresoCuota;
		this.ingresoReservas = ingresoReservas;
		this.gastoCompras = gastoCompras;
		this.otrosGastos = otrosGastos;
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

	public double getIngresoCuota() {
		return ingresoCuota;
	}

	public void setIngresoCuota(double ingresoCuota) {
		this.ingresoCuota = ingresoCuota;
	}

	public double getIngresoReservas() {
		return ingresoReservas;
	}

	public void setIngresoReservas(double ingresoReservas) {
		this.ingresoReservas = ingresoReservas;
	}

	public double getGastoCompras() {
		return gastoCompras;
	}

	public void setGastoCompras(double gastoCompras) {
		this.gastoCompras = gastoCompras;
	}

	public double getOtrosGastos() {
		return otrosGastos;
	}

	public void setOtrosGastos(double otrosGastos) {
		this.otrosGastos = otrosGastos;
	}

}