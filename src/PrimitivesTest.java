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
	private int getFirstDigit(int number) {
		return number = number / 100;
	};
	private int getSecondDigit(int number) {
		return number = number / 10 % 10;
	};
	private int getThirdDigit(int number) {
		return number = number % 10;
	};
	
	@Disabled
	@Test
	void getBitValueTest() {				   
		long number = 0x3ab7f5; //0011_1010_1011_0111_1111_0101
		assertEquals(1, BitOperations.getBitValue(number, 4));
		assertEquals(-1, BitOperations.getBitValue(number, 100));
		assertEquals(-1, BitOperations.getBitValue(number, -2));
	}
	
	@Disabled
	@Test
	void setBitValueTest () {
		long number = 0x3ab7f5; //0011_1010_1011_0111_1111_0101
		assertEquals(0x3ab7e5, BitOperations.setBitValue(number, 4, false));
		assertEquals(0x3ab7f5, BitOperations.setBitValue(number, 4, true));
	}
	
	@Disabled
	@Test
	void revertBitValueTest () {
		//long number = -1;
		//assertEquals(1, BitOperations.getBitValue(number, 63));
		//number = BitOperations.revertBitValue(number, 63);
		//System.out.println(number);
		//assertEquals(0, BitOperations.getBitValue(number, 63));
		
		long number = 0x3ab7f5; //0011_1010_1011_0111_1111_0101
		assertEquals(0x3ab7e5, BitOperations.invertBitValue(number, 63));
		assertEquals(0x3ab7f4, BitOperations.invertBitValue(number, 0));
	}
	
	@Test
	void digitsNumberTest() {
		//TODO
	}
	
	@Test
	void leadingZerosTest() {
		//TODO
	}
	
	@Test
	void isHappyNumberTest() {
		//TODO
	}
}
