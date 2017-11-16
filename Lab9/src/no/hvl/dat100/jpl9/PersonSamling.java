package no.hvl.dat100.jpl9;

public class PersonSamling {
	private int antall;
	private Person[] liste;

	public PersonSamling() {
		liste = new Person[20];
		antall = 0;
	}

	public PersonSamling(int lengde) {
		liste = new Person[lengde];
		antall = 0;
	}

	public int getAntall() {
		return antall;
	}

	public Person[] getSamling() {
		return liste;
	}

	public int finnPerson(Person p) {
		for (int i = 0; i<antall; i++) {
			if(p.erLik(liste[i])) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Person p) {
		for (int i = 0; i<antall; i++) {
			if(p.erLik(liste[i])) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		String s = antall + "\n";
		for(int i = 0; i<antall; i++) {
			s += liste[i].toString();
		}
		return s;
	}

	public void utvid() {
		Person[] utvidetListe = new Person[liste.length * 2];
        System.arraycopy(liste, 0, utvidetListe, 0, antall);
        liste = utvidetListe;
	}

	public boolean ledigPlass() {
		if(liste.length == antall) {
			return false;
		}
		return true;
	}

	public boolean leggTil(Person p) {
		if(finnes(p)) {
			System.out.println("Personen finnes allerede i systemet");
			return false;
		}else {
			if(liste.length == antall) {
				utvid();
			}
			liste[antall] = p;
			antall++;
			return true;
		}
	}

	public boolean slett(Person p) {
		if(!finnes(p)) {
			System.out.println("Personen finnes ikke i samlingen..");
			return false;
		}else {
			int plass = finnPerson(p);
			if(plass == antall - 1) {
				liste[plass] = null;
			}else {
				liste[plass] = liste[antall - 1];
				liste[antall] = null;
			}
			antall--;
			return true;
		}
	}
}