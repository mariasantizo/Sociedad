package negocio;

import java.util.ArrayList;

public interface Calculable <t>{
	public void calcularGrafico(ArrayList<t> array);
	public void calcularTabla(ArrayList<t> array);
	public void calcularResumen(ArrayList<t> array);
}
