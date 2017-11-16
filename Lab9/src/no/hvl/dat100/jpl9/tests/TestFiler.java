package no.hvl.dat100.jpl9.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import no.hvl.dat100.jpl9.*;

public class TestFiler {

	private static String FILNAVN = "personer.dat";
	
	@Test
	public void testskriv() {
		Filer filer = new Filer();
		
		Student student = new Student("Olsen", "Ole", 7,100,"1A");
		Laerer laerer = new Laerer("Olsen", "Ole", 8,1000,7676);
		
		PersonSamling samling = new PersonSamling();
		
		samling.leggTil(student);
		samling.leggTil(laerer);
		
		filer.skriv(samling, FILNAVN);
	}

	@Test
	public void testles() {
		Filer filer = new Filer();
		
		PersonSamling samling = filer.les(FILNAVN);
		Student student = new Student("Olsen", "Ole", 7,100,"1A");
		Laerer laerer = new Laerer("Olsen", "Ole", 8,1000,7676);
		
		assertEquals(samling.getAntall(),2);
		assertTrue(samling.finnes(student));
		assertTrue(samling.finnes(laerer));
	}
	
}
