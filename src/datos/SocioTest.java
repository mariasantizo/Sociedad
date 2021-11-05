package datos;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SocioTest {
	
	Socio socio1;
	
	@Before
	public void setUp() {
		socio1 = new Socio();
	}
	
	@After
	public void tearDown() {
		socio1 = null;
	}
	
	@Test
	public void calcularCuota() {
		Socio s = new Socio("Anual");
		s.calcularCuota();
		assertEquals(s.getCuota(), 960);
	}
	
}
