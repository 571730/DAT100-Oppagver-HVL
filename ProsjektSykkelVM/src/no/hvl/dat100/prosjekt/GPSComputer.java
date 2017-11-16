package no.hvl.dat100.prosjekt;

import java.util.Locale;

public class GPSComputer {
	
	public GPSComputer(GPSData gpsdata) {

		GPSDataConverter converter = new GPSDataConverter(gpsdata);
		converter.convert();

		this.times = converter.times;
		this.latitudes = converter.latitudes;
		this.longitudes = converter.longitudes;
		this.elevations = converter.elevations;
	}

	// tabeller for GPS datapunkter
	public int[] times;
	public double[] latitudes;
	public double[] longitudes;
	public double[] elevations;
	
	// beregn total distances (i meter)
	public double totalDistance() {

		double distance = 0;

		
		// OPPGAVE - START
		for(int i=0; i<(times.length-1); i++) {
			double delDist = GPSUtils.distance(latitudes[i], longitudes[i], latitudes[i+1], longitudes[i+1]);
			distance = distance + delDist;
		}

		// Hint: bruk distance-metoden fra GPSUtils.
		
		// OPPGAVE - SLUTT

		return distance;
	}

	// beregn totale høydemeter (i meter)
	public double totalElevation() {

		double elevation = 0;

		
		// OPPGAVE - START
		for(int i=0; i<(times.length-1); i++) {
			if((elevations[i+1]-elevations[i])>0) {
				elevation = elevation + (elevations[i+1]-elevations[i]);
			}
		}

		// OPPGAVE - SLUTT
		return elevation;
	}

	// beregn total tiden for hele turen (i sekunder)
	public int totalTime() {
		
		int totaltime = 0;
		
		
		// OPPGAVE START
		totaltime = times[times.length-1] - times[0];
		// OPPGAVE SLUTT
		
		return totaltime;
	}
		
	// beregn gjennomsnitshastighets mellom hver av gps punktene
	public double[] speeds() {

		double[] speeds = new double[times.length-1];
		
		
		// OPPGAVE - START
		for(int i=0; i<speeds.length; i++) {
			speeds[i] = GPSUtils.speed(times[i+1]-times[i], latitudes[i], longitudes[i], latitudes[i+1], 
					longitudes[i+1]);
		}
		// OPPGAVE - SLUTT
		return speeds;
	}

	// beregn maximum hastighet km/t
	public double maxSpeed() {
		
		double maxspeed = 0;
		
		
		// OPPGAVE - START
		double[] speedsArray = speeds();
		
		//Kan ikke bruke (speed : speedsArray), vet ikke hvorfor
		for(int i=0; i<speedsArray.length; i++) {
			if(speedsArray[i] > maxspeed) {
				maxspeed = speedsArray[i];
			}
		}
		
//		for(int i=0; i<(times.length-1); i++) {
//			double tempSpeed = GPSUtils.speed(times[i+1]-times[i], latitudes[i], longitudes[i], latitudes[i+1], 
//					longitudes[i+1]);
//			if(tempSpeed > maxspeed) {
//				maxspeed = tempSpeed;
//			}
//		}
				
		// OPPGAVE - SLUTT
		
		return maxspeed;
	}
	
	// beregn gjennomsnittshasitiget for hele turen km/t
	public double averageSpeed() {

		double average = 0;
		
		
		// OPPGAVE - START
		average = totalDistance()/totalTime();
		//fra m/s til km/t
		average = average*3.6;
				
		// OPPGAVE - SLUTT
		
		return average;
	}


	// conversion factor kph (km/t) to miles per hour (mph)
	public static double MS = 0.62;

	// beregn kcal gitt weight og tid der kjøres med en gitt hastighet
	public double kcal(double weight, int secs, double speed) {

		double kcal = 0;

		// MET: Metabolic equivalent of task angir (kcal x kg-1 x h-1)
		double met = 0;		
		double speedmph = speed * MS;

		// TODO
		// OPPGAVE START
		if(0<speedmph && speedmph<10) {
			met = 4.0;
		}
		else if(speedmph<12){
			met = 6.0;
		}
		else if(speedmph<14){
			met = 8.0;
		}
		else if(speedmph<15){
			met = 10.0;
		}
		else if(speedmph<20){
			met = 12.0;
		}
		else {
			met = 16.0;
		}
		
		double time = (double)secs/3600;
		
		kcal = met * weight * time;

		// OPPGAVE SLUTT
		
		return kcal;
	}

	public double totalKcal(double weight) {

		double totalkcal = 0;

		
		// OPPGAVE - START 
		
		//lager speeds tabell med bruk av metode
		double[] speedsArray = speeds();
		
		for(int i=0; i<speedsArray.length; i++) {
			// TODO
			//kcal blir 0 hver gang
			totalkcal = totalkcal + kcal(weight, times[i+1]-times[i], speedsArray[i]);
		}
		
		// Hint: hent hastigheter i speeds tabellen og tider i timestabellen
		// disse er definer i toppen av klassen og lese automatisk inn
		
		// OPPGAVE - SLUTT
		
		return totalkcal;
	}
	
	private static double WEIGHT = 80.0;
	
	// skriv ut statistikk for turen
	public void print() {
		
		// TODO
		// OPPGAVE - START
				
		System.out.format(Locale.US,"%-15s:%10s%n", "Total Time", GPSUtils.printTime(totalTime()));
		System.out.format(Locale.US,"%-15s:%10.2f km%n", "Total distance", totalDistance()/1000);
		System.out.format(Locale.US,"%-15s:%10.2f m%n", "Total elevation", totalElevation());
		System.out.format(Locale.US,"%-15s:%10.2f km/t%n", "Max speed", maxSpeed());
		System.out.format(Locale.US,"%-15s:%10.2f km/t%n", "Average speed", averageSpeed());
		System.out.format(Locale.US,"%-15s:%10.2f kcal%n", "Energy", totalKcal(WEIGHT));
		// OPPGAVE - SLUT
	}
	
	// ekstraoppgaver
	public void climbs() {
		
	}
	
	public void maxClimb() {
		
	}
}
