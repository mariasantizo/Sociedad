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
	private float ingresoCuota;
	private float ingresoReservas;
	private float gastoCompras;
	private float otrosGastos;
	
	public CuentaResultados(int codigo, Calendar fecha, float ingresoCuota, float ingresoReservas, float gastoCompras,
			float otrosGastos) {
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

	public float getIngresoCuota() {
		return ingresoCuota;
	}

	public void setIngresoCuota(float ingresoCuota) {
		this.ingresoCuota = ingresoCuota;
	}

	public float getIngresoReservas() {
		return ingresoReservas;
	}

	public void setIngresoReservas(float ingresoReservas) {
		this.ingresoReservas = ingresoReservas;
	}

	public float getGastoCompras() {
		return gastoCompras;
	}

	public void setGastoCompras(float gastoCompras) {
		this.gastoCompras = gastoCompras;
	}

	public float getOtrosGastos() {
		return otrosGastos;
	}

	public void setOtrosGastos(float otrosGastos) {
		this.otrosGastos = otrosGastos;
	}

}
