package no.hvl.dat100.jpl9.tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPerson {

	@Test
	public void testConstructor() {
	
		long fnummer = 10069418300L;
		
		TPerson person = new TPerson("Olsen", "Ole", fnummer);
		
		assertEquals(person.getEtternamn(),"Olsen");
		assertEquals(person.getFornamn(),"Ole");
		assertEquals(person.getFodselsnummer(),fnummer);
	}

	@Test
	public void testSet() {
		TPerson person = new TPerson();
		long fnummer = 10069418300L;
		
		person.setEtternamn("Olsen");
		person.setFornamn("Ole");
		person.setFodselsnummer(fnummer);
		
		assertEquals(person.getEtternamn(),"Olsen");
		assertEquals(person.getFornamn(),"Ole");
		assertEquals(person.getFodselsnummer(),fnummer);
	}
	
	@Test
	public void testKjonn1() {
		long fnummer = 10069418300L;
		
		TPerson person = new TPerson("Olsen", "Ole", fnummer);
		
		assertTrue(person.erMann());
		assertFalse(person.erKvinne());
	}
	
	@Test
	public void testKjonn2() {
		long fnummer = 10069418200L;
		
		TPerson person = new TPerson("Olsen", "Oline", fnummer);
		
		assertFalse(person.erMann());
		assertTrue(person.erKvinne());
	}
	
	@Test
	public void testerLik() {
		TPerson person1 = new TPerson("Olsen", "Oline", 8);
		TPerson person2 = new TPerson("Olsen", "Oline", 8);
		TPerson person3 = new TPerson("Olsen", "Oline", 7);
		
		assertFalse(person1.erLik(person3));
		assertTrue(person1.erLik(person2));
	}
}
