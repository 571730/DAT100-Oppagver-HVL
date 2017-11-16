package no.hvl.dat100.jpl9;

public class Laerer extends Person {
	private int maanedslonn;
	private int kontonummer;

	public Laerer() {
		super();
		maanedslonn = 123456;
		kontonummer = 123456;
	}

	public Laerer(String etternamn, String fornamn, long fodselsnummer, int maanedslonn, int kontonummer) {
		super(etternamn, fornamn, fodselsnummer);
		this.maanedslonn = maanedslonn;
		this.kontonummer = kontonummer;
	}

	public int getMaanedslonn() {
		return maanedslonn;
	}

	public void setMaanedslonn(int maanedslonn) {
		this.maanedslonn = maanedslonn;
	}

	public int getKontonummer() {
		return kontonummer;
	}

	public void setKontonummer(int kontonummer) {
		this.kontonummer = kontonummer;
	}

	@Override
	public String toString() {
		return "LAERER\n" + super.toString() + maanedslonn + "\n" + kontonummer +  "\n";
	}
}
