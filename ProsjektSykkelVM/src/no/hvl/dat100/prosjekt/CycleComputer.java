package no.hvl.dat100.prosjekt;

import javax.swing.JOptionPane;

import easygraphics.*;

public class CycleComputer extends EasyGraphics {

	private static int[] times;
	private static double[] latitudes;
	private static double[] longitudes;
	private static double[] elevations;

	private static int SPACE = 20;
	private static int MARGIN = 50;
	private static int ROUTEMAPXSIZE = 800; 
	private static int ROUTEMAPYSIZE = 400;
	private static int HEIGHTSIZE = 300;
	private static int TEXTHEIGHT = 80;

	private static GPSComputer gpscomputer;
	private int N = 0;

	private double minlon, minlat, maxlon, maxlat;

	private double xstep, ystep;

	public CycleComputer() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");

		GPSData gpsdata = GPSDataReaderWriter.readGPSFile(filename);

		gpscomputer = new GPSComputer(gpsdata);

		times = gpscomputer.times;
		latitudes = gpscomputer.latitudes;
		longitudes = gpscomputer.longitudes;
		elevations = gpscomputer.elevations;
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		N = times.length; // number of gps points

		minlon = GPSUtils.findMin(longitudes);
		minlat = GPSUtils.findMin(latitudes);

		maxlon = GPSUtils.findMax(longitudes);
		maxlat = GPSUtils.findMax(latitudes);

		xstep = xstep();
		ystep = ystep();

		makeWindow("Cycle Computer", 2 * MARGIN + ROUTEMAPXSIZE,
				TEXTHEIGHT + MARGIN + ROUTEMAPYSIZE + HEIGHTSIZE + 2 * SPACE);

		bikeRoute();

	}

	// løp igjennom punkter på uten og visualiser løpende høyde, position og
	// statisikk
	public void bikeRoute() {

		setColor(0, 255, 0); // green
		//Tegner opp ruten
		drawRoute();
		setColor(0, 0, 255); // blue;
		int x,y = 0;

		// make a circle in the first point
		x = MARGIN + (int) ((longitudes[0] - minlon) * xstep);
		y = ROUTEMAPYSIZE + (int) ((latitudes[0] - minlat) * ystep);
		
		int movingcircle = fillCircle(x, y, 7);
		int timescaling = Integer.parseInt(getText("Tidsskalering"));
		int pauseTid = 0;
		for(int i=0; i<N-1; i++) {
			showCurrent(i);
			showHeight(HEIGHTSIZE,i);
			showPosition(i, movingcircle);
			pauseTid = times[i];
			pause(pauseTid/timescaling);
		}
	}

	public double xstep() {

		double xstep = 0.0;

		double maxlon = GPSUtils.findMax(longitudes);
		double minlon = GPSUtils.findMin(longitudes);

		xstep = ROUTEMAPXSIZE / (Math.abs(maxlon - minlon));

		return xstep;
	}

	public double ystep() {

		double ystep = 0.0;

		// TODO
		double maxlat = GPSUtils.findMax(latitudes);
		double minlat = GPSUtils.findMin(latitudes);

		ystep = ROUTEMAPYSIZE / (Math.abs(maxlat - minlat));

		return ystep;
	}

	// beregn og vis statistikk eks. hastighet nå vi er kommet til punkt i på
	// ruten
	public void showCurrent(int i) {
		//tegner en hvit rute over forige verdier for � hjemme dem
		setColor(255,255,255);
		fillRectangle(0, 0, 300, 150);
		
		//Tegner strenger
		setColor(0, 0, 0);

		double[] speeds = gpscomputer.speeds();
		int speedInt = (int) speeds[i];
		String speed = "Hastighet:" + String.valueOf(speedInt) + " km/t";
		int tidSek = 0;
		//legger sammen sekunder saa langt
		for(int n=0;n<i; n++) {
			tidSek += times[n+1] - times[n];
		}
		int[] tider = toHourMinSek(tidSek);
		String tid = "Tid brukt: " + String.valueOf(tider[0] + " timer " + String.valueOf(tider[1]) + " minutter og "
				+ String.valueOf(tider[2]) + " sekunder");
		String sekunder = "Sekunder:" + String.valueOf(tidSek);
		//Distanse
		int distInt = 0;
		//Hopper over foerste punkt, siden han ikke har beveget seg der
		if(i>0) {
			//Legger sammen alle distnseverdiene saa langt
			for(int n=1; n<=i; n++) {
				distInt += (int) GPSUtils.distance(latitudes[n-1], longitudes[n-1], latitudes[n], longitudes[n]);
			}
			
		}
		String distanse = "Distanse: " + distInt + " m";
		
		drawString(tid, MARGIN, SPACE);
		drawString(sekunder, MARGIN, SPACE*2);
		drawString(speed, MARGIN, SPACE*3);
		drawString(distanse, MARGIN, SPACE*4);

	}
	
	public int[] toHourMinSek(int secs) {
		int[] timeListe = new int[3];
		timeListe[0] = secs/3600;
		timeListe[1] = (secs%3600)/60;
		timeListe[2] = secs % 60;
		
		return timeListe;
	}

	// tegn høydepunkt nr. i
	public void showHeight(int ybase, int i) {

		// TODO
		setColor(0, 0, 255);	

		int x1, y1, x2, y2; // koordinator søylen 

		int bredde = 1;
		int hoyde = ((int) elevations[i]);
		if(hoyde<0) {
			hoyde = 0;
		}
		y1 = ybase - hoyde;
		x1 = 10 +((bredde*2) * i);
		x2 = bredde;
		y2 = hoyde;
		fillRectangle(x1,y1,x2,y2);

	}

	// tegn punkt nr. i på kartet/vinduet
	public void showPosition(int i, int movingcircle) {

		// TODO
		setColor(0, 0, 255); // blue;
		int x,y = 0;

		//Hopper over foerste runde, siden det punktet er allerede tegnet
		if(i>0) {
			double[] speeds = gpscomputer.speeds();
			int speed = (int) speeds[i-1];
			//skalerer ned hastighet med faktor paa 10 siden setSpeed bare tar tall 1-10
			speed = speed/10;
			//Om fart er under 1, blir den 1, siden setSpeed trenger 1-10
			if(speed<1) {
				speed = 1;
			}
			//Justerer hatighet om den er over 10
			else if(speed>10) {
					speed = 10;
			}
			setSpeed(speed);
			x = MARGIN + (int) ((longitudes[i] - minlon) * xstep);
			y = ROUTEMAPYSIZE + (int) ((latitudes[i] - minlat) * ystep);
			moveCircle(movingcircle,x,y);
		}
	}
	
	//Lagde egen metode for � bare tegne ruten, ble penere slik
	public void drawRoute() {
		for (int i = 0; i < latitudes.length; i++) {

			int x,y;

			int radius = 3;
			x = MARGIN + (int) ((longitudes[i] - minlon) * xstep);
			y = ROUTEMAPYSIZE + (int) ((latitudes[i] - minlat) * ystep);
			fillCircle(x,y,radius);
			
			int x2, y2;
			//Forhindrer at loopen gaar ut av range ved siste punkt
			if(i == (latitudes.length - 1)) {
				drawLine(x,y,x,y);
			}
			else {
			x2 = MARGIN + (int) ((longitudes[i+1] - minlon) * xstep);
			y2 = ROUTEMAPYSIZE + (int) ((latitudes[i+1] - minlat) * ystep);
			drawLine(x,y,x2,y2);
			}
			
		}
	}
}
