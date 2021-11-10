package datos;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Administrador a1 = new Administrador("72456413H", "Maria", "Santizo", 673893521, "Mundaiz 3");
		Socio s1 = new Socio("72451111R", "Ana", "Garcia", 673111111, "Mundaiz 3", 1, "Semestral");
		Mesa m1 = new Mesa(1, 10);
		Calendar f1 = new GregorianCalendar (2021,10,30);
		Reserva r1 = new Reserva (1, s1, m1, f1, "Comida");
		s1.calcularCuota();
		System.out.println(s1.getCuota());
		
		
		
		
		
		
		
	}

}
