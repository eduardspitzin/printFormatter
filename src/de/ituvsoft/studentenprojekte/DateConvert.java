package de.ituvsoft.studentenprojekte;
import java.lang.IllegalArgumentException;
public class DateConvert {
	
	
	public static String dateConvert(String datum) {
		if (datum.indexOf('.') == 2 && datum.lastIndexOf('.') == 5 && datum.length() == 10) {
			return datum;
		}
		else if (datum.indexOf('-') == 4 && datum.lastIndexOf('-') == 7 && datum.length() == 10) {
			CharSequence tag = datum.substring(8);
			CharSequence monat = datum.substring(5, 7);
			CharSequence jahr = datum.substring(0,4);
			return datum.join(".", tag, monat, jahr);		
		}									//		2 0 0 1 1 2 1 4
											//		0 1 2 3 4 5 6 7
		else if (datum.length() == 8) {			//		1 4 1 2 2 0 0 1
			boolean mRichtig = Integer.parseInt(datum.substring(4, 6)) > 12;
			boolean mFalsch = Integer.parseInt(datum.substring(0, 2)) > 12;

			if (!mRichtig && !mFalsch) {
				throw new IllegalArgumentException("Formatierung funktioniert nur für Datümer, welche maximal 700 Jahre zurückliegen.");

			}

			if (mRichtig) {
				CharSequence tag = datum.substring(0, 2);
				CharSequence monat = datum.substring(2, 4);
				CharSequence jahr = datum.substring(4);
				return datum.join(".", tag, monat, jahr);
			}

			if (mFalsch) {
				CharSequence tag = datum.substring(6);
				CharSequence monat = datum.substring(4, 6);
				CharSequence jahr = datum.substring(0, 4);
				return datum.join(".", tag, monat, jahr);
			}
		}

		else if (datum.length() > 10) {
			String[] Monate = { "Januar", "Februar", "MÃ¤rz", "April", "Mai", "Juni", "Juli", "August", "September",
					"Oktober", "November", "Dezember" };
			for (int i = 0; i < 12; i++) {
				if (datum.contains(Monate[i])) {
					CharSequence monat = String.valueOf(i + 1);
					CharSequence tag = datum.substring(0, 2);
					CharSequence jahr = datum.substring(datum.length() - 4);
					return datum.join(".", tag, monat, jahr);
				}
				
			}
			
		}
		else {
			throw new IllegalArgumentException("Das Datum wurde falsch angegeben und konnte somit nicht konvertiert werden.");
			
		}	
		return "Es ist ein Fehler aufgetreten";
		
	}

	public static void main(String[] args) {
		System.out.println(dateConvert("13041503"));

	}

}
