package datos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReservaTest {

	Reserva reserva;
	Producto p1;
	Producto p11;
	Producto p2;
	Producto p22;
	ArrayList<Producto> productos;
	
	@Before
	public void setUp() {
		Socio socio = new Socio();
		Mesa mesa = new Mesa();
		Calendar fecha = new GregorianCalendar(2021, 11, 1);
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
		reserva = new Reserva(1, socio, mesa, fecha, "Cena");
		reserva.setProductos(productos);
	}
	
	@After
	public void tearDown() {
		reserva = null;
	}
	
	@Test
	public void pagarTest() {
		reserva.pagar();
		double valor = 0;
		for (int i=0; i<productos.size(); i++) {
			valor = valor + productos.get(i).getPrecio();
		}
		assertTrue(valor==reserva.getPrecio());
	}
	
	@Test
	public void pagarTest2() {
		reserva.pagar();
		double valor = p1.getPrecio()+p11.getPrecio()+p2.getPrecio()+p22.getPrecio();
		assert(valor==reserva.getPrecio());
	}

}
