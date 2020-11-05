package de.ituvsoft.studentenprojekte;

import java.lang.IllegalArgumentException;

public class Formatter {
	public static String printf(String s, Object... Arguments) {
		return((formatter(s, Arguments)));
	}

	public static void printef(String s, Object... Arguments) {
		System.err.println(formatter(s, Arguments));
	}

	public static String formatter(String s, Object... Arguments) {
		StringBuffer sb = new StringBuffer(s);
		int i = 0;

		int posBS = 0;
		while (s.contains("%") && sb.lastIndexOf("%") != posBS - 1 && Arguments.length > i) {
			char plHalterArt = sb.charAt(sb.indexOf("%", posBS) + 1);
			if (sb.indexOf("%") != 0 && (sb.charAt(sb.indexOf("%", posBS) - 1) == '\\')) {				
					posBS = sb.indexOf("%") + 1;				
		}
		
			else if (plHalterArt == 'D') {
				if (!(Arguments[i] instanceof String)) {
					throw new IllegalArgumentException("Das Datum muss in einem String angegeben werden");
				}
				sb.replace(sb.indexOf("%",posBS), sb.indexOf("%", posBS) + 2, DateConvert.dateConvert(Arguments[i].toString()));
				i++;

			}

			else if (sb.charAt(sb.indexOf("%", posBS) + 1)== 'f') {
				if (!(Arguments[i] instanceof Float || Arguments[i] instanceof Double)) {
					throw new IllegalArgumentException("F�r Ganzzahlen d�rfen nur Zahlen vom Typ Float oder Double �bergeben werden");
				}

				int nKStellen = Character.getNumericValue(sb.charAt(sb.indexOf("%") + 2));
				System.out.println(Arguments[i].toString());
				String dbl = Arguments[i].toString();
				double zahl = Double.parseDouble(dbl);
				sb.replace(sb.indexOf("%", posBS), sb.indexOf("%", posBS) + 3, DecimalNumber.decimalNumber(zahl, nKStellen));
				i++;

			}

			else if (plHalterArt == 'n') {

				if (Arguments[i] instanceof Integer 
					|| Arguments[i] instanceof Double 
					|| Arguments[i] instanceof String 
					|| Arguments[i] instanceof Float 
					|| Arguments[i] instanceof Short 
					|| Arguments[i] instanceof Byte 
					|| Arguments[i] instanceof Long)


				{
					sb.replace(sb.indexOf("%", posBS), sb.indexOf("%",posBS) + 2, WholeNumber.numberConvert(Arguments[i]));
					i++;
				}
				else { throw new IllegalArgumentException("Ganzzahlen d�rfen nur von Typ Integer sein");
				}

			} else if (plHalterArt == 's') {
				if(Arguments[i] instanceof String) {
				sb.replace(sb.indexOf("%", posBS), sb.indexOf("%", posBS) + 2, Arguments[i].toString());
				i++;
				}
				else {
					throw new IllegalArgumentException("Strings d�rfen nur vom Typ String sein");
				}

			} else if (plHalterArt== 'S') {
				if (Arguments[i] instanceof String) {
				sb.replace(sb.indexOf("%", posBS), sb.indexOf("%", posBS) + 2, BigLetters.blMaker(Arguments[i].toString()));
				i++;
				}
				else {
					throw new IllegalArgumentException("Strings d�rfen nur vom Typ String sein");
				}
					

			} else {
				throw new IllegalArgumentException("Der angegebene Platzhalter exisitiert nicht");
			}
			
			s = sb.toString();
		}
		int r = 0;
		while (r < s.length() && sb.indexOf("%") != -1) {
			if (sb.charAt(sb.indexOf("%", posBS) - 1) == '\\') {
				posBS = sb.indexOf("%") + 1;
				r++;
			} else {
				sb.replace(sb.indexOf("%", posBS), sb.indexOf("%", posBS) + 2, " ");

			}
	}

		s = sb.toString().replace('\\', ' ');

		while (s.contains("  ")) {
			s = s.replace("  ", " ");
		}
		s.trim();
		return s;

	}

	public static void main(String[] args) {
		System.out.println(printf("%s    hallo  %D", "hallo", "04112020"));
	}

}
