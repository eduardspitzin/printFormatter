package de.ituvsoft.studentenprojekte;

public class DecimalNumber{

	public static String decimalNumber(double rundZahl, int nachStellen) {
		double value = rundZahl;
		int n = nachStellen;
		int rZahl = 1;
		if (n == 0) {
			return String.valueOf(Math.round(value));

		}
		for (int i = 0; i < n; i++) {
			rZahl *= 10;

		}

		value = Math.rint(rZahl * value) / rZahl;
		return String.valueOf(value);

	}

	public static String decimalNumber(float rundZahl, int nachStellen) {
		float value = rundZahl;
		int n = nachStellen;
		int rZahl = 1;
		if (n == 0) {
			return String.valueOf(Math.round(value));

		}
		for (int i = 0; i < n; i++) {
			rZahl *= 10;

		}

		value = (float) (Math.rint(rZahl * value) / rZahl);
		return String.valueOf(value);

	}

	public static void main(String[] args) {

		System.out.println(decimalNumber(1.0, 3));

	}

	

}
