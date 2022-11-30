package telran.digital.numbers.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static telran.digital.numbers.DigitalNumbersPrinting.*;

public class DigitalPaintingTest {
	
	@Disabled
	@Test
	void lineTest() {
		System.out.println(line(10, 30));
	}
	
	@Disabled
	@Test
	void verticalLineTest() {
		displayStrings(verticalLine(30, 10));
	}
	
	@Disabled
	@Test
	void twoVerticalLinesTest() {
		displayStrings(twoVerticalLines(30, 10, 5));
	}
	
	@Disabled
	@Test
	void zeroTest() {
		displayStrings(zero(30, 5, 5));
	}
	
	@Disabled
	@Test
	void oneTest() {
		displayStrings(one(30, 5, 5));
	}
	
	@Disabled
	@Test
	void twoTest() {
		displayStrings(two(30, 5, 9));
	}
	
	@Disabled
	@Test
	void threeTest() {
		displayStrings(three(30, 7, 7));
	}
	
	@Disabled
	@Test
	void fourTest() {
		displayStrings(four(30, 7, 3));
	}
	
	@Disabled
	@Test
	void fiveTest() {
		displayStrings(five(30, 7, 5));
	}
	
	@Disabled
	@Test
	void sixTest() {
		displayStrings(six(30, 7, 9));
	}
	
	@Disabled
	@Test
	void sevenTest() {
		displayStrings(seven(30, 7, 9));
	}
	
	@Disabled
	@Test
	void eightTest() {
		displayStrings(eight(30, 7, 9));
	}
	
	@Disabled
	@Test
	void nineTest() {
		displayStrings(nine(30, 7, 5));
	}
	
	
	@Test
	void displayDigitalNumberTest() {
		displayDigitalNumber(1234567890, 2, 5, 9);
		displayDigitalNumber(1087654320, 2, 7, 5);
	}
}
