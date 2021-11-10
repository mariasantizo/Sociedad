package negocio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import datos.Producto;
import datos.TipoProducto;

public class AlmacenTest {

	Almacen almacen1;
	Producto p1;
	Producto p2;
	Producto p11;
	Producto p22;
	ArrayList<Producto> productos;
	
	@Before
	public void setUp() {
		Calendar fecha = new GregorianCalendar(2020,12,31);
		TipoProducto tipo = new TipoProducto("Frutas", 1);
		p1 = new Producto("limon", 1, tipo, 2);
		p11 = new Producto("limon", 3, tipo, 2);
		p2 = new Producto("naranja", 2, tipo, 3);
		p22 = new Producto("naranja", 4, tipo, 3);
		productos = new ArrayList<Producto>();
		productos.add(p1);
		productos.add(p11);
		productos.add(p2);
		productos.add(p22);
		almacen1 = new Almacen(1, fecha, productos);
	}
	
	@After
	public void tearDown() {
		almacen1 = null;
	}
	
	@Test
	public void calcularAlmacenTest() {
		almacen1.calcularAlmacen();
		double valor = 0;
		valor = (double) (p1.getPrecio()+p2.getPrecio()+p11.getPrecio()+p22.getPrecio());
		assert(almacen1.getValor()==valor);
	}
	
	@Test
	public void calcularAlmacenTest2() {
		almacen1.calcularAlmacen();
		double valor = 0;
		for (int i=0; i<productos.size(); i++) {
			valor=valor+productos.get(i).getPrecio();
		}
		assert(almacen1.getValor()==valor);
	}

}
