package no.hvl.dat100ptc.oppgave3;

import static java.lang.Double.parseDouble;
import static java.lang.Math.*;
import static javax.swing.JOptionPane.showInputDialog;
import java.text.DecimalFormat;
import java.math.RoundingMode;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		// TODO - START

		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		
		return min;

		// TODO - SLUT

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// TODO - START
		
		double[] tab = new double[gpspoints.length];
		
		for (int i = 0; i < gpspoints.length; i++) {
			
			tab[i] = gpspoints[i].getLatitude();
		} 
		
		return tab;
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START

		double[] tab = new double[gpspoints.length];
		
		for (int i = 0; i < gpspoints.length; i++) {
			
			tab[i] = gpspoints[i].getLongitude();
		} 
		
		return tab;
		
		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d, c, a;
		double latitude1, longitude1, latitude2, longitude2;

		// TODO - START

        latitude1 = toRadians (gpspoint1.getLatitude());
        longitude1 = toRadians (gpspoint1.getLongitude());
        
        latitude2 = toRadians (gpspoint2.getLatitude());
        longitude2 = toRadians (gpspoint2.getLongitude());
        
        double deltaLat = latitude2 - latitude1;
        double deltaLong = longitude2 - longitude1;
        
        
        a = (Math.pow(Math.sin(deltaLat / 2), 2 )) + (Math.cos(latitude1) * Math.cos(latitude2)) * (Math.pow(Math.sin(deltaLong / 2), 2));

        c = 2 * (Math.atan2 (Math.sqrt(a), Math.sqrt(1 - a)));
        
        d = R * c;
        
        return d;
		// TODO - SLUTT

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		// TODO - START


        secs = gpspoint2.getTime() - gpspoint1.getTime();
        
        double distance = GPSUtils.distance(gpspoint1, gpspoint2);
        speed = (distance/secs)*3.6;
        
        
        return speed;

		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";
		int timer, minutter, sekunder;

		// TODO - START

		
		timer = secs / 3600;
		minutter = (secs % 3600) / 60;
		sekunder = (secs % 3600) % 60;
		
		timestr = formatTimeNumber(timer) + TIMESEP + formatTimeNumber(minutter) + TIMESEP + formatTimeNumber(sekunder);
		
		return timestr;
		
		// TODO - SLUTT

	}
	private static int TEXTWIDTH = 10;
	
	//Gjør tid om til tekst 
	public static String formatTimeNumber(int n) {
		
		String FormatTime;
		
		if (n < TEXTWIDTH) {
	    	
	    	FormatTime = "0" + n;
	        return FormatTime;
	        
	    } else {
	    	
	    	FormatTime = Integer.toString(n);
	        return FormatTime;
	    }
	}

	public static String formatDouble(double d) {

		DecimalFormat df = new DecimalFormat("#.##");
		String str;
		
		// TODO - START
		
		df.setRoundingMode(RoundingMode.CEILING);
		str = df.format(d);
		
		return str;
		
		// TODO - SLUTT
		
	}
}
