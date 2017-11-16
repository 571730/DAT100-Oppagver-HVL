package no.hvl.dat100.jpl9.tests;

import no.hvl.dat100.jpl9.Person;

public class TPerson extends Person {
	
	public TPerson() {
		super();
	}
	
	public TPerson(String etternamn, String fornamn, long fodselsnummer) {
		super(etternamn,fornamn,fodselsnummer);
	}
	// klasse for å gjøre den abstrake klasse Person testbars
}
