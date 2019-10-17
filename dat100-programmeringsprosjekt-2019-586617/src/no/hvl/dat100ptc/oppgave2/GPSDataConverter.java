package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import static java.lang.Integer.*;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	// konverter tidsinformasjon i gps data punkt til antall sekunder fra midnatt
	// dvs. ignorer information om dato og omregn tidspunkt til sekunder
	// Eksempel - tidsinformasjon (som String): 2017-08-13T08:52:26.000Z
    // skal omregnes til sekunder (som int): 8 * 60 * 60 + 52 * 60 + 26 
	
	private static int TIME_STARTINDEX = 11; // startindex for tidspunkt i timestr

	public static int toSeconds(String timestr) {
		
		int secs;
		int hr, min, sec;
		
		// TODO
		// OPPGAVE - START
		
		hr = parseInt(timestr.substring(TIME_STARTINDEX, timestr.indexOf(':')));
		min = parseInt(timestr.split(":")[1]);;
		sec = parseInt(timestr.substring(17, timestr.indexOf('.')));
				
		secs = (hr * 60*60) + (min*60) + sec;
		
		return secs;

		// OPPGAVE - SLUTT
		
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		GPSPoint gpspoint;
		int time;
		double latitude, longitude, elevation;

		// TODO - START ;
		
		time = toSeconds(timeStr);
		latitude = Double.parseDouble(latitudeStr);
		longitude = Double.parseDouble(longitudeStr);
		elevation = Double.parseDouble(elevationStr);
		
		gpspoint = new GPSPoint (time, latitude, longitude, elevation);
				
		return gpspoint;

		// OPPGAVE - SLUTT ;
	    
	}
	
}
