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
	
	@Disabled
	@Test
	void isAnagramTest() {
		String word = "yellow";
		assertTrue(Strings.isAnagramByYuri(word, "loweyl"));
		assertTrue(Strings.isAnagramByYuri(word, "elolyw"));
		assertTrue(Strings.isAnagramByYuri(word, "wolley"));
		assertTrue(Strings.isAnagramByYuri(word, "loleyw"));
		assertFalse(Strings.isAnagramByYuri(word,""));
		assertFalse(Strings.isAnagramByYuri(word, "yellob"));
		assertFalse(Strings.isAnagramByYuri(word,"yello"));
		assertFalse(Strings.isAnagramByYuri(word,"yelllo"));
		assertTrue(Strings.isAnagramByYuri("tom marvolo riddle","iam lord voldemort"));
	}
	
	@Disabled
	@Test
	void sortStringNumbersTest() {
		String[] array1 = {"5", "-37", "15", "2", "22", "120", "118", "-110", "5", "2", "1", "0", "127", "-128", "1", "5"};
		Strings.sortStringNumbersByYuri(array1);
		assertArrayEquals(new String[] {"-128", "-110", "-37", "0", "1", "1", "2", "2", "5", "5", "5", "15", "22", "118", "120", "127"}, array1);
	}

	@Disabled
	@Test
	void javaVariableTest() {
		assertTrue("java".matches(Strings.javaNameExp()) );	
		assertTrue("__".matches(Strings.javaNameExp()) );	
		assertTrue("java_1_2".matches(Strings.javaNameExp()) );	
		assertFalse("1java".matches(Strings.javaNameExp()) );
		assertFalse("_".matches(Strings.javaNameExp()) );
		assertTrue("$".matches(Strings.javaNameExp()) );
		assertFalse("$ _".matches(Strings.javaNameExp()) );
	}
	
	@Disabled
	@Test
	void octetTest() {
		assertTrue("255".matches(Strings.ip4Octet()) );	
		assertTrue("0".matches(Strings.ip4Octet()) );	
		assertTrue("007".matches(Strings.ip4Octet()) );	
		assertTrue("05".matches(Strings.ip4Octet()) );
		assertTrue("199".matches(Strings.ip4Octet()) );
		assertTrue("26".matches(Strings.ip4Octet()) );
		assertTrue("1".matches(Strings.ip4Octet()) );
		assertFalse("256".matches(Strings.ip4Octet()) );
		assertFalse("-1".matches(Strings.ip4Octet()) );
		assertFalse("0000".matches(Strings.ip4Octet()) );
	}
	
	
	@Test
	void ipV4Test() {
		assertTrue("1.0.0.1".matches(Strings.ipV4()) );	
		assertTrue("0.0.0.0".matches(Strings.ipV4()) );	
		assertTrue("255.255.255.255".matches(Strings.ipV4()) );	
		assertTrue("255.255.255.0".matches(Strings.ipV4()) );	
		assertTrue("255.255.0.0".matches(Strings.ipV4()) );
		assertTrue("255.0.0.0".matches(Strings.ipV4()) );
		assertFalse("256.0.0.0".matches(Strings.ipV4()) );
		assertFalse("1".matches(Strings.ipV4()) );
		assertFalse("256.256.256.256".matches(Strings.ipV4()) );
	}
}
