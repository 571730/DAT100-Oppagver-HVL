package no.hvl.dat100.jpl9.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import no.hvl.dat100.jpl9.*;
public class TestLaerer {
	
	private int maanedslonn;
	private int kontonummer;
	
	@Test
	public void testConstructor() {
		Laerer laerer = new Laerer("Olsen", "Ole", 7,1000,7676);
		
		assertEquals(laerer.getEtternamn(),"Olsen");
		assertEquals(laerer.getFornamn(),"Ole");
		assertEquals(laerer.getFodselsnummer(),7);
		assertEquals(laerer.getMaanedslonn(),1000);
		assertEquals(laerer.getKontonummer(),7676);
	}

	@Test
	public void testSet() {
		Laerer laerer = new Laerer();
		
		laerer.setEtternamn("Olsen");
		laerer.setFornamn("Ole");
		laerer.setFodselsnummer(7);
		laerer.setMaanedslonn(1000);
		laerer.setKontonummer(7676);
		
		assertEquals(laerer.getEtternamn(),"Olsen");
		assertEquals(laerer.getFornamn(),"Ole");
		assertEquals(laerer.getFodselsnummer(),7);
		assertEquals(laerer.getMaanedslonn(),1000);
		assertEquals(laerer.getKontonummer(),7676);
	}

	@Test
	public void testToString() {
		Laerer laerer = new Laerer("Olsen", "Ole", 7,1000,7676);
		
		String str = "LAERER\n7\nOlsen\nOle\n1000\n7676\n";
		
		assertEquals(laerer.toString(),str);
	}
}
