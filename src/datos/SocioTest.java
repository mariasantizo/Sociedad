package datos;

public class SocioTest{
	@Before
	public void setUp() {
		Socio s = new Socio("Anual");
	}
	
	@After
	public void tearDown() {
		Socio s = null;
	}
	
	@Test
	public void calcularCuota() {
		Socio s = new Socio("Anual");
		s.calcularCuota();
		assertEquals(s.getCuota(), 960);
	}
	
}
