package de.ituvsoft.studentenprojekte;

public class DecimalNumber {

	public static String tTrennZeichen(String zahl) {

		StringBuffer zahlB = new StringBuffer(zahl);
		int j = 1;

		if (zahl.contains(",")) {
			for (int i = zahl.indexOf(","); i > 0; i--) {

				if (j % 3 == 1 && j != 1) {
					zahlB.insert(i, '.');
				}
				j++;
			}
			return zahlB.toString();

		} else {
			for (int i = zahl.length(); i >= 0; i--) {

				if (j % 3 == 1 && j != 1) {
					zahlB.insert(i, '.');
				}
				j++;
			}
			return zahlB.toString();
		}

	}

	public static String decimalNumber(double rundZahl, int nachStellen) {
		double value = rundZahl;
		int n = nachStellen;
		int rZahl = 1;
		if (n == 0) {
			return tTrennZeichen(String.valueOf(Math.round(value)));

		}
		for (int i = 0; i < n; i++) {
			rZahl *= 10;

		}

		value = Math.rint(rZahl * value) / rZahl;
		return tTrennZeichen(String.valueOf(value).replace('.', ','));

	}

	public static String decimalNumber(float rundZahl, int nachStellen) {
		float value = rundZahl;
		int n = nachStellen;
		int rZahl = 1;
		if (n == 0) {
			return tTrennZeichen(String.valueOf(Math.round(value)));

		}
		for (int i = 0; i < n; i++) {
			rZahl *= 10;

		}

		value = (float) (Math.rint(rZahl * value) / rZahl);
		return tTrennZeichen(String.valueOf(value).replace('.', ','));

	}

	public static void main(String[] args) {

		System.out.println(decimalNumber(43453234, 1));
		// System.out.println(ttrennZeichen("43383954,35786"));
	}

}
