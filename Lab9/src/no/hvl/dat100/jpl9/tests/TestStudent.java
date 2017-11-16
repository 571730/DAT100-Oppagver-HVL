package no.hvl.dat100.jpl9.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import no.hvl.dat100.jpl9.*;
public class TestStudent {
	
	@Test
	public void testConstructor() {
		Student student = new Student("Olsen", "Ole", 7,100,"1A");
		
		assertEquals(student.getEtternamn(),"Olsen");
		assertEquals(student.getFornamn(),"Ole");
		assertEquals(student.getFodselsnummer(),7);
		assertEquals(student.getStudentnummer(),100);
		assertEquals(student.getFodselsnummer(),7);
	}

	@Test
	public void testSet() {
		Student student = new Student();
		
		student.setEtternamn("Olsen");
		student.setFornamn("Ole");
		student.setFodselsnummer(7);
		student.setStudentnummer(100);
		student.setKlasse("1A");
		
		assertEquals(student.getEtternamn(),"Olsen");
		assertEquals(student.getFornamn(),"Ole");
		assertEquals(student.getFodselsnummer(),7);
		assertEquals(student.getStudentnummer(),100);
		assertEquals(student.getKlasse(),"1A");
	}
	
	@Test
	public void testToString() {
		Student student = new Student("Olsen", "Ole", 7,100,"1A");
		
		String str = "STUDENT\n7\nOlsen\nOle\n100\n1A\n";
		
		assertEquals(student.toString(),str);
	}
	
}
