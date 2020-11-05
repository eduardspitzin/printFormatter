package de.ituvsoft.studentenprojekte;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class FormatterTest {
	
	@Test
	void testValidConvert() {
		String s = Formatter.printf("Hallo %s, heute ist der %D. Meine Name ist %S. Meine Lieblingszahlen sind %n und %f2", "du", 04112020, "lucy", 7, 18.54676);
		assertTrue(s.equals("Hallo du, heute ist der 04.11.2020. Meine Name ist LUCY. Meine Lieblingszahlen sind 7 und 18.55"));
	}
	
	@Test
	void testValidDatum() {
		String s = Formatter.printf("%D  %D %D %D %D", "20201028", "28102020", "2020-10-28", "28.Oktober 2020", "28.10.2020");
		assertTrue(s.equals("28.10.2020 28.10.2020 28.10.2020 28.10.2020 28.10.2020"));		
	}
	
	@Test
	void testValidGanzzahl() {
		String s = Formatter.printf("%n  %n %n %n", 5, 5.67, "4", "4.67");
		assertTrue(s.equals("5 6 4 5"));
	}
	
	@Test
	void testValidDezimal() {
		String s = Formatter.printf("%f2 %f5 %f2 %f5 %f3", "12.3456", "12.345678", 4.2345, 56.433221, 3);
		assertTrue(s.equals("12.35 12.34568 4.23 56.43322 3.000"));
	}
	
	@Test
	void testValidString() {
		String s = Formatter.printf("%s %s", "HALLO WeLt", "gieofibgndfobvgidfnmofdfjnfo");
		assertTrue(s.equals("HALLO WeLt gieofibgndfobvgidfnmofdfjnfo"));
	}
	
	@Test
	void testValidSTRING() {
		String s = Formatter.printf("%S %S", "HaLLo dU", "123455");
		assertTrue(s.equals("HaLLo dU 123455"));
	}
	
	@Test
	void testToLessArguments() {
		String s = Formatter.printf("%S haaloo %n", "Hallo", 5, "test", 345);
		assertTrue(s.equals("Hallo haaloo 5"));
	}
	
	@Test 
	void testToLessParamter() {
		String s = Formatter.printf("%s geht %D geht %n", "Hallo", "20201104");
		assertTrue(s.equals("Hallo geht 04.11.2020 geht "));
	}
	
//	@Test
//	void testBackslash() {
//		String s = f.printf("\%s blah %n blah \%D", 5);
//		assertTrue(s.equals("%s blah 5 blah %D"));
//	}
//	
	@Test
	void testSpace() {
		String s = Formatter.printf(" %s    hallo  %D", "hallo", "04112020");
		assertTrue(s.equals("hallo hallo 04.11.2020" ));
	}

	
}
