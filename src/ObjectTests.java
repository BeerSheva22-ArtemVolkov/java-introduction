import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ObjectTests {

	@Disabled
	@Test
	void wrapperTest() {
		// конверты от -128 до 127
		Integer a = 11;
		Integer b = 11;
		assertEquals(a, b); // сравнивает конверты (содержимое)
		
		Integer c = 201;
		Integer d = 201; // d ссылка на объект где будет храниться 201
		assertEquals(c, d);
		
		assertTrue(a == b);
		assertFalse(c == d); // сравнивает ссылки
		assertTrue(c.equals(d));
	}
	
	@Disabled
	@Test
	void stringTest() {
		String hello = "hello";
		char[] helloArray = hello.toCharArray();
		assertEquals('h', helloArray[0]);
		System.out.println((byte)' ');
		assertEquals(hello.length(), 5);
	}
	

	@Test
	void isAnagramTest() {
		String word = "yellow";
		assertTrue(Strings.isAnagram(word, "loweyl"));
		assertTrue(Strings.isAnagram(word, "elolyw"));
		assertTrue(Strings.isAnagram(word, "wolley"));
		assertTrue(Strings.isAnagram(word, "loleyw"));
		assertFalse(Strings.isAnagram(word,""));
		assertFalse(Strings.isAnagram(word, "yellob"));
		assertFalse(Strings.isAnagram(word,"yello"));
		assertFalse(Strings.isAnagram(word,"yelllo"));
		assertTrue(Strings.isAnagram("tom marvolo riddle","iam lord voldemort"));
	}
	
	
	@Test
	void sortStringNumbersTest() {
		String[] array1 = {"5", "-37", "15", "2", "22", "120", "118", "-110", "5", "2", "1", "0", "127", "-128", "1", "5"};
		Strings.sortStringNumbers(array1);
		assertArrayEquals(new String[] {"-128", "-110", "-37", "0", "1", "1", "2", "2", "5", "5", "5", "15", "22", "118", "120", "127"}, array1);
	}
}
