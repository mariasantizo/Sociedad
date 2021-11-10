package negocio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import datos.Producto;

public class BalanceTest {

	Balance balance1;
	
	@Before
    public void setUp() {
		Calendar fecha1 = new GregorianCalendar(2020,12,31);
		ArrayList<Producto> productos = new ArrayList();
		CuentaResultados resultado1 = new CuentaResultados(1, fecha1, 2000, 1000, 500, 500);	
		resultado1.calcularResultado();
		Almacen almacen1 = new Almacen (1, fecha1, productos, 1000);
        balance1 = new Balance(1, fecha1, 1000, 1000, almacen1, 1000, 1000, 5000, 5000, resultado1, 2000, 1000);
    }

    @After
    public void tearDown() {
        balance1 = null;
    }

    @Test  
    public void calcularValorBalanceTest (){
    	balance1.calcularValorBalance();
    	assertTrue(balance1.getValorBalance()==10000.0);
    	
    }
        
    @Test  
    public void calcularValorBalanceTest1 (){
    	balance1.calcularValorBalance();
    	assertTrue(balance1.getValorBalance()==balance1.getMobiliario()+balance1.getEquipos()+balance1.getClientes()+balance1.getAlmacen().getValor()+balance1.getBancos()+balance1.getCaja());
    	
    }
    
    @Test  
    public void comprobarValorBalanceTest (){
    	balance1.calcularValorBalance();
    	assertEquals(balance1.comprobarValor(), true);	
    }
}