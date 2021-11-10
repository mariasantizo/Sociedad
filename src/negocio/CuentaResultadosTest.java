package negocio;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CuentaResultadosTest {
	
	CuentaResultados cuentaResultado1;
	
	@Before
    public void setUp() {
		Calendar fecha1 = new GregorianCalendar(2020,12,31);
        cuentaResultado1 = new CuentaResultados(1,fecha1, 76800, 50000, 43000, 30000);
    }

    @After
    public void tearDown() {
        cuentaResultado1 = null;
    }

    @Test
    public void getCodigoCuentaResultados() {
        int codigo = 1;
        cuentaResultado1.setCodigo(codigo);  
        assertEquals(cuentaResultado1.getCodigo(), codigo);
    }
    
    @Test  
    public void calcularResultadoTest (){
    	cuentaResultado1.calcularResultado();
    	assertTrue(cuentaResultado1.getResultado()==53800.0);
    }  
    
    @Test  
    public void calcularResultadoTest1 (){
    	cuentaResultado1.calcularResultado();
    	assertTrue(cuentaResultado1.getResultado()==cuentaResultado1.getIngresoCuota()+cuentaResultado1.getIngresoReservas()-cuentaResultado1.getGastoCompras()-cuentaResultado1.getOtrosGastos());
    }
}
