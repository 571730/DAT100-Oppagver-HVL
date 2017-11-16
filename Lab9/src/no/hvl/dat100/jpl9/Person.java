package no.hvl.dat100.jpl9;

public abstract class Person {
	protected long fodselsnummer;
	protected String etternamn;
	protected String fornamn;
	
	public Person() {
		fodselsnummer = 123456;
		etternamn = "N";
		fornamn = "N";
	}

	public Person(String etternamn, String fornamn, long fodselsnummer) {
		this.etternamn = etternamn;
		this.fornamn = fornamn;
		this.fodselsnummer = fodselsnummer;
	}

	public String getEtternamn() {
		return etternamn;
	}

	public void setEtternamn(String etternamn) {
		this.etternamn = etternamn;
	}

	public String getFornamn() {
		return fornamn;
	}

	public void setFornamn(String fornamn) {
		this.fornamn = fornamn;
	}

	public void setFodselsnummer(long fodselsnummer) {
		this.fodselsnummer = fodselsnummer;
	}

	public long getFodselsnummer() {
		return fodselsnummer;
	}

	public boolean erLik(Person person) {
		if(fodselsnummer == person.getFodselsnummer()) {
			return true;
		}else {
			return false;
		}
	}

	public boolean erKvinne() {
		String s = String.valueOf(fodselsnummer);
		int lengde = s.length();
		int tall = Character.getNumericValue(s.charAt(lengde-4));
		if(tall % 2 == 0) {
			return true;
		}else {
			return false;
		}
	}

	public boolean erMann() {
		String s = String.valueOf(fodselsnummer);
		int lengde = s.length();
		int tall = Character.getNumericValue(s.charAt(lengde-4));
		if(tall % 2 == 0) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public String toString() {
		return fodselsnummer + "\n" + etternamn + "\n" + fornamn + "\n";
	}
}
