import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PrimitivesTest {

	@Test
	@Disabled
	void dataTypesTest() {
		int b = 10;
		short a = 20; //коммент
		char c = 'd';
		long l = (long) 10.1;
		byte b1 = (byte) 1000;
		a=(short) l;
		float f = 10.2f;
		int b2 = 0xfffffffe; // = -1 0xfffffffe = -2
		assertEquals(-2, b2);
		
	}
	@Test
	@Disabled
	void operTest() {
		int number = 123;
		assertEquals(1, getFirstDigit(number));
		assertEquals(2, getSecondDigit(number));
		assertEquals(3, getThirdDigit(number));
		
	}
	private int getFirstDigit(int number) {return number = number / 100;};
	private int getSecondDigit(int number) {return number = number / 10 % 10;};
	private int getThirdDigit(int number) {return number = number % 10;};
	
}
