package de.ituvsoft.studentenprojekte;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ConverterTest {
	
	Formatter f;
	
	@BeforeEach
	void init() {
		f = new Formatter();
	}
	
	@Test
	void testValidConvert() {
		String s = f.printf("Hallo %s, heute ist der %D. Meine Name ist %S. Meine Lieblingszahlen sind %n und %f2", "du", "04112020", "lucy", 7, 18.54676);
		assertTrue(s.equals("Hallo du, heute ist der 04.11.2020. Meine Name ist LUCY. Meine Lieblingszahlen sind 7 und 18,55"));
	}
	
	@Test
	void testValidDatum() {
		String s = f.printf("%D  %D %D %D %D", "20201028", "28102020", "2020-10-28", "28.Oktober 2020", "28.10.2020");
		assertTrue(s.equals("28.10.2020 28.10.2020 28.10.2020 28.10.2020 28.10.2020"));		
	}
	
	@Test
	void testWrongDatum() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			f.printf("%D", 05112020);	
		});
		assertTrue(e.getMessage().equals("Das Datum muss in einem String angegeben werden"));
	}
	
	@Test
	void testValidGanzzahl() {
		String s = f.printf("%n  %n %n %n", 5, 5.67, "4", "4.67");
		assertTrue(s.equals("5 6 4 5"));
	}
	
	@Test
	void testWrongGanzzahl() {
		java.awt.Point i = new java.awt.Point(4,5);
		Exception e = assertThrows(IllegalArgumentException.class, () -> {			
			f.printf("%n", i);	
		});
		assertTrue(e.getMessage().equals("Ganzzahlen dürfen nur von Typ Integer sein"));
	}
	
	@Test
	void testValidDezimal() {
		String s = f.printf("%f2 %f5 %f3",4.2345, 56.433221, 45678.34566);
		assertTrue(s.equals("4,23 56,43322 45.678,346"));
	}
	
	@Test
	void testWrongDezimal() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			f.printf("%f2", 3);	
		});
		assertTrue(e.getMessage().equals("Für Ganzzahlen dürfen nur Zahlen vom Typ Float oder Double übergeben werden"));
	}
	
	@Test
	void testValidString() {
		String s = f.printf("%s %s %s", "HALLO WeLt", "gieofibgndfobvgidfnmofdfjnfo", "123");
		assertTrue(s.equals("HALLO WeLt gieofibgndfobvgidfnmofdfjnfo 123"));
	}
	
	@Test
	void testWrongString() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			f.printf("%s", 3);	
		});
		assertTrue(e.getMessage().equals("Strings dürfen nur vom Typ String sein"));
	}
	
	@Test
	void testValidSTRING() {
		String s = f.printf("%S %S", "HaLLo dU", "123455");
		assertTrue(s.equals("HALLO DU 123455"));
	}
	
	@Test
	void testWrongSTRING() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			f.printf("%S", 3);	
		});
		assertTrue(e.getMessage().equals("Strings dürfen nur vom Typ String sein"));
	}
	
	@Test
	void testToLessArguments() {
		String s = f.printf("%S haaloo %n", "Hallo", 5, "test", 345);
		assertTrue(s.equals("HALLO haaloo 5"));
	}
	
	@Test 
	void testToLessParamter() {
		String s = f.printf("%s geht %D geht %n", "Hallo", "20201104");
		assertTrue(s.equals("Hallo geht 04.11.2020 geht "));
	}
	
	@Test
	void testBackslash() {
		String s = f.printf("\\%s blah %n blah \\%D", 5);
		assertTrue(s.equals(" %s blah 5 blah %D"));
	}
	
	@Test
	void testSpace() {
		String s = f.printf("%s    hallo  %D", "hallo", "04112020");
		assertTrue(s.equals("hallo hallo 04.11.2020" ));
	}

	
}
