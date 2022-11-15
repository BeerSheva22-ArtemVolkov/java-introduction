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
	
	@Disabled
	@Test
	void digitsNumberTest() {
		long number = 12351364626123L;
		assertEquals(14, Numbers.getNdigits(number));
		number = 123;
		assertEquals(3, Numbers.getNdigits(number));
	}
	
	@Disabled
	@Test
	void leadingZerosTest() {
		long number = 0x3ab7f5; //0011_1010_1011_0111_1111_0101
		assertEquals(42, Numbers.leadingZeros(number));
		number = 1;
		assertEquals(2, Numbers.getNdigits(number));
	}
	
	@Disabled
	@Test
	void isHappyNumberTest() {
		int expectedTrue = 343811;
		int expectedFalse = 143822;
		assertTrue(Numbers.isHappyNumber(expectedTrue));		
		assertFalse(Numbers.isHappyNumber(expectedFalse));
	}
	
	@Disabled
	@Test
	void getDigitsTest() {
		int expected[] = {1,2,3,4};
		assertArrayEquals(expected, Numbers.getDigits(1234));
	}
	
	@Disabled
	@Test
	void getNumberFromDigitsTest() {
		int expectedNumber = 1234;
		assertEquals(expectedNumber, Numbers.getNumberFromDigits(new int[] {1,2,3,4}));
	}
	
	@Disabled
	@Test
	void IsraelIdentityTest() {
		int expectedTrue = 584216485;
		int expectedFalse = 143822;
		assertTrue(IsraelIdentity.verify(expectedTrue));	
		assertFalse(IsraelIdentity.verify(expectedFalse));
		expectedTrue = IsraelIdentity.generateRandom();
		assertTrue(IsraelIdentity.verify(expectedTrue));
	}
	
	@Disabled
	@Test
	void MyArrayTest() {
		assertArrayEquals(new int[] {5,7,8,4,3,9,1,0,5,4,22}, MyArrays.addsNumber(new int[] {5,7,8,4,3,9,1,0,5,4}, 22));
		
		assertArrayEquals(new int[] {7,8,4,3,9,1,0,5,4}, MyArrays.removeNumber(new int[] {5,7,8,4,3,9,1,0,5,4}, 0));
		
		assertArrayEquals(new int[] {5,7,8,4,3,1,0,5,4}, MyArrays.removeNumber(new int[] {5,7,8,4,3,9,1,0,5,4}, 5));
		
		assertArrayEquals(new int[] {5,10,20,30,40,50,60,70}, MyArrays.insertSorted(new int[] {10,20,30,40,50,60,70}, 5));
		
		assertArrayEquals(new int[] {10,20,30,40,50,55,60,70}, MyArrays.insertSorted(new int[] {10,20,30,40,50,60,70}, 55));
	}
	
	
	@Test
	void ArraysSearchTest() {
		assertEquals(-16, MyArrays.binarySearchDuplicate(new int[] {4, 5, 7, 9, 9, 9, 9, 13, 13, 18, 22, 26, 29, 44, 59}, 60));
	}

	@Disabled
	@Test
	void isOneSwapTestFalse() {
		int ar1[] = { 1, 2, 3, 10, -1, 5, 6 };
		int ar2[] = { 1, 2, 3, 4, 5, 10 };
		int ar3[] = { 5, 1, 2, 4, 6, 10 };
		int ar4[] = { 1, 5, 2, 4, 3, 10 };
		int ar5[] = { 1, 3, 2, 5, 4, 10, 8 };
		int ar6[] = { 1, 3, 20, 4, 5, 6, 10};
		int ar7[] = { 1, 3, 20, 4, 5, 11, 2};
		assertFalse(MyArrays.isOneSwapForSorted(ar1));
		assertFalse(MyArrays.isOneSwapForSorted(ar2));
		assertFalse(MyArrays.isOneSwapForSorted(ar3));
		assertFalse(MyArrays.isOneSwapForSorted(ar4));
		assertFalse(MyArrays.isOneSwapForSorted(ar5));
		assertFalse(MyArrays.isOneSwapForSorted(ar6));
		assertFalse(MyArrays.isOneSwapForSorted(ar7));
	}
	
	@Disabled
	@Test
	void isOneSwapTestTrue() {
		int ar1[] = { 10, 2, 3, 4, 1 };
		int ar2[] = { 1, 2, 4, 3, 5, 10 };
		int ar3[] = { 1, 2, 3, 10, 5, 4 };
		int	ar4[] = { 1, 5, 3, 4, 2, 10 };
		int ar5[] = { 1, 2, 3, 4, 10, 5 };
		int ar6[] = { 2, 1, -3, 4, 5, 10 };
		int ar7[] = { 3, 2, 1, 4, 5, 6 };
		assertTrue(MyArrays.isOneSwapForSorted(ar1));
		assertTrue(MyArrays.isOneSwapForSorted(ar2));
		assertTrue(MyArrays.isOneSwapForSorted(ar3));
		assertTrue(MyArrays.isOneSwapForSorted(ar4));
		assertTrue(MyArrays.isOneSwapForSorted(ar5));
		assertTrue(MyArrays.isOneSwapForSorted(ar6));
		assertTrue(MyArrays.isOneSwapForSorted(ar7));
	}
	
	@Disabled
	@Test
	void bubbleSortTest() {
		assertArrayEquals(new int[] {10,20,30,40,50,60,70}, MyArrays.myBubbleSort(new int[] {10,30,20,40,50,70,60}));
	}
	

	@Test
	void isSum2Test() {
		short[] array = new short[] {1,2,3,4,5,6};
		assertTrue(MyArrays.isSum2(array, (short)10));
		array = new short[] {1,2,3,4,5,6};
		assertFalse(MyArrays.isSum2(array, (short)17));
		array = new short[] {2,4,6,7,8};
	}
}
