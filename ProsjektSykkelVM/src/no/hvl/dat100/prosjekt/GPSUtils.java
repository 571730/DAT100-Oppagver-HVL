package no.hvl.dat100.prosjekt;

import static java.lang.Math.*;

import java.util.Locale;

public class GPSUtils {

	public GPSUtils() {
	
	}
	
	// konverter sekunder til string på formen hh:mm:ss
	public static String printTime(int secs) {
		
		String timestr = "";
		String TIMESEP = ":";
		
		
		// OPPGAVE - START
		timestr = String.format("%02d", secs/3600) + TIMESEP + String.format("%02d", (secs%3600)/60) + TIMESEP + 
				String.format("%02d", secs%60);
				
		// OPPGAVE - SLUTT
		
		return timestr;
	}
	
	// beregn maximum av en tabell av doubles med minnst et element
	public static double findMax(double[] da) {

		double max = da[0];

		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}

		return max;
	}

	// beregn minimum av en tabell av doubles med minnst et element
	public static double findMin(double[] da) {

		// fjern = "0.0" når metoden implementeres for ikke få forkert minimum
		double min = da[0]; 

		
		// OPPGAVE - START
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		
		// OPPGAVE - SLUT
		return min;
	}

	
	private static int R = 6371000; // jordens radius
	
	// Beregn avstand mellom to gps punkter ved bruk av Haversine formlen
	public static double distance(double latitude1, double longitude1, double latitude2, double longitude2) {

		double a,c,d; // fjern = 1.0
		
		
		// OPPGAVE - START
		
		double radLatEn = Math.toRadians(latitude1);
		double radLatTo = Math.toRadians(latitude2);
		double radLongEn = Math.toRadians(longitude1);
		double radLongTo = Math.toRadians(longitude2);
		double deltaLat = radLatTo - radLatEn;
		double deltaLong = radLongTo - radLongEn;
		
		a = (Math.pow(Math.sin(deltaLat/2), 2)) + (Math.cos(radLatEn) * Math.cos(radLatTo) *
				Math.pow(Math.sin(deltaLong/2), 2));
		c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		d = R * c;
		
		// OPPGAVE - SLUTT

		return d;
	}
	
	// beregn gjennomsnits hastighet i km/t mellom to gps punkter
	public static double speed(int secs, double latitude1, double longitude1, double latitude2, double longitude2) {

		double speed = 0.0;

		
		// OPPGAVE - START
		
		double dist = distance(latitude1, longitude1, latitude2, longitude2);
		//Konverterer til km/t
		speed = ((dist/secs)*60*60) / 1000;
		// OPPGAVE - SLUTT

		return speed;
	}
	
	private static int TEXTWIDTH = 10;
	
	// konverter double til string med 2 decimaler og streng lengde 10
	// eks. 1.346 konverteres til "      1.35" og enhet til slutt
	// Hint: se på String.format metoden
	
	public static String printDouble(double d) {
		
		String str = "";
		
		
		// OPPGAVE - START
		
		//Trenger Locale.US for at den skal bruke punktum og ikke komma
		str = String.format(Locale.US,"%10.2f", d);
		
		// OPPGAVE - SLUTT
		
		return str;
	}
}
