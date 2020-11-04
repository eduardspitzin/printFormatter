package de.ituvsoft.studentenprojekte;

public class WholeNumber {

	public static String numberConvert(int number) {
		int i = number;
		return String.valueOf(i);

	}

	public static String numberConvert(long number) {
		long l = number;
		return String.valueOf(l);

	}

	public static String numberConvert(String number) {
		return number;

	}

	public static String numberConvert(float number) {
		int f = (int) Math.round(number);
		return String.valueOf(f);

	}

	public static String numberConvert(short number) {
		int s = number;
		return String.valueOf(s);

	}

	public static String numberConvert(double number) {
		int d = (int) Math.round(number);
		return String.valueOf(d);

	}

	public static String numberConvert(byte number) {
		int i = (int) number;
		return String.valueOf(i);

	}

	public static void main(String[] args) {
		byte f = 10;
		System.out.println(numberConvert(15));

	}

}
