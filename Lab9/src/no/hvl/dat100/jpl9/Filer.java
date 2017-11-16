package no.hvl.dat100.jpl9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Filer {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jpl9/";

	private static String STUDENT = "STUDENT";
	private static String LAERER = "LAERER";

	public boolean skriv(PersonSamling samling, String filnavn) {

		boolean skrevet = true;
		PrintWriter writer = null;

		try {
			File fil = new File(filnavn);
			writer = new PrintWriter(fil);
			Person[] liste = samling.getSamling();
			
			int antall = samling.getAntall();
			writer.println(antall);
			for(int i = 0; i<antall; i++) {
				writer.print(liste[i]);
			}
			return true;
			
		}catch(FileNotFoundException e) {
			System.out.println("Finner ikke filen" + e.getMessage());
			return false;
		}finally {
			writer.close();
		}

	}

	public PersonSamling les(String filnavn) {

		PersonSamling samling = null;
		Scanner sc = null;
		try {
			File fil = new File(filnavn);
			sc = new Scanner(fil);

	        int antallLinjer = Integer.parseInt(sc.nextLine());
	        samling = new PersonSamling(antallLinjer);

	        while (sc.hasNextLine()){
	            String linje = sc.nextLine();
	            if(linje.equals("STUDENT")) {
	            	long fodselsnummer = Long.valueOf(sc.nextLine());
	            	String etternamn = sc.nextLine();
	            	String fornamn = sc.nextLine();
	            	int studentnummer = Integer.valueOf(sc.nextLine());
	            	String klasse = sc.nextLine();
	            	Student student = new Student(etternamn, fornamn, fodselsnummer, studentnummer, klasse);
	            	samling.leggTil(student);
	            }else {
	            	long fodselsnummer = Long.valueOf(sc.nextLine());
	            	String etternamn = sc.nextLine();
	            	String fornamn = sc.nextLine();
	            	int maanedslonn = Integer.valueOf(sc.nextLine());
	            	int kontonummer = Integer.valueOf(sc.nextLine());
	            	Laerer laerer = new Laerer(etternamn, fornamn, fodselsnummer, maanedslonn, kontonummer);
	            	samling.leggTil(laerer);
	            }
	        }
	        sc.close();
		}catch(FileNotFoundException e) {
			System.out.println("Noe gikk galt" + e.getMessage());
		}finally {
			sc.close();
		}
		return samling;
		
	}
}
