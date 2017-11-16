package no.hvl.dat100.jpl9.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import no.hvl.dat100.jpl9.*;
public class TestSamling {

	@Test
	public void testStandardConstructor() {
		PersonSamling samling = new PersonSamling();
		
		assertEquals(samling.getAntall(),0);
		assertEquals(samling.getSamling().length,20);
		
	}

	@Test
	public void testConstructor() {
		PersonSamling samling = new PersonSamling(40);
		
		assertEquals(samling.getAntall(),0);
		assertEquals(samling.getSamling().length,40);
	}
	
	
	@Test 
	public void testleggTil() {
		PersonSamling samling = new PersonSamling(40);
		
		Student student1 = new Student("Olsen", "Ole", 6,100,"1A");
		Student student2 = new Student("Olsen", "Oline", 7,101,"1A");
		
		Laerer laerer = new Laerer("Olsen", "Ole", 8,1000,7676);
		
		assertTrue(samling.leggTil(student1));
		assertTrue(samling.leggTil(laerer));
		
		assertEquals(samling.getAntall(),2);
		
		assertTrue(samling.finnPerson(student1) >= 0);
		assertTrue(samling.finnPerson(student2) < 0);
		
		assertTrue(samling.finnes(student1));
		assertTrue(samling.finnes(laerer));
		assertFalse(samling.finnes(student2));
		
	}
	
	@Test
	public void testledigPlass() {
		PersonSamling samling1 = new PersonSamling(40);
		PersonSamling samling2 = new PersonSamling(2);
		
		Student student = new Student("Olsen", "Ole", 6,100,"1A");
		Laerer laerer = new Laerer("Olsen", "Ole", 8,1000,7676);
		
		samling1.leggTil(student);
		samling1.leggTil(laerer);
		
		samling2.leggTil(student);
		samling2.leggTil(laerer);
		
		assertTrue(samling1.ledigPlass());
		assertFalse(samling2.ledigPlass());
	}
	
	@Test
	public void testutvid() {
		PersonSamling samling = new PersonSamling(2);
		
		Student student = new Student("Olsen", "Ole", 6,100,"1A");
		Laerer laerer = new Laerer("Olsen", "Ole", 8,1000,7676);

		samling.leggTil(student);
		samling.leggTil(laerer);
		
		assertEquals(samling.getAntall(),2);
		assertFalse(samling.ledigPlass());
		
		samling.utvid();
		
		assertTrue(samling.finnes(student));
		assertTrue(samling.finnes(laerer));
		assertEquals(samling.getAntall(),2);
		assertTrue(samling.ledigPlass());	
	}
	
	@Test
	public void testslett() {
	
		PersonSamling samling = new PersonSamling(2);
		
		Student student = new Student("Olsen", "Ole", 6,100,"1A");
		Laerer laerer = new Laerer("Olsen", "Ole", 8,1000,7676);

		samling.leggTil(student);
		samling.leggTil(laerer);
		
		assertEquals(samling.getAntall(),2);
		assertTrue(samling.finnes(student));
		assertTrue(samling.finnes(laerer));
		
		samling.slett(laerer);
		
		assertEquals(samling.getAntall(),1);
		assertTrue(samling.finnes(student));
		assertFalse(samling.finnes(laerer));
	}
	
	@Test
	public void testtoString() {
		PersonSamling samling = new PersonSamling(2);
		
		Student student = new Student("Olsen", "Ole", 6,100,"1A");
		Laerer laerer = new Laerer("Olsen", "Ole", 8,1000,7676);

		samling.leggTil(student);
		samling.leggTil(laerer);
		
		String str = "2\n" + "STUDENT\n6\nOlsen\nOle\n100\n1A\n" + 
				"LAERER\n8\nOlsen\nOle\n1000\n7676\n";
				
		assertEquals(samling.toString(),str);
		
	}
}
