import java.util.Arrays;

public class Strings {
	
	static int maxByte = Byte.MAX_VALUE + 1;
	
	/**
	 * 
	 * @param str
	 * @param anagram
	 * @return true if str2 is an anagram of str1
	 * complexity O[N] two passes
	 * 1. The same length
	 * 2. The same symbols just in different order
	 * *  Use only one array
	 * 
	 */
	public static boolean isAnagram(String str1, String str2) {
		boolean res = false;
		
		char[] char1 = str1.toCharArray();
		char[] char2 = str2.toCharArray();
		
		if (char1.length == char2.length) {
			char[] arrayHelper = new char[maxByte * 2];
			for (int i = 0; i < char1.length; i++) {
				arrayHelper[char1[i]] = (char) (arrayHelper[char1[i]] + char1[i]);
				arrayHelper[char2[i]] = (char) (arrayHelper[char2[i]] - char2[i]);
			}
			res = isNullArray(arrayHelper);
		}
		return res; 
	}

	private static boolean isNullArray(char[] arrayHelper) {
		int i = 0;
		boolean res = true;
		while (i < arrayHelper.length && res) {
			if ((char)(arrayHelper[i]) != 0) {
				res = false;
			}
			i++;
		}
		return res;
	}
	
	public static String[] sortStringNumbers(String[] array) {
		int[] arrayHelper = new int[maxByte * 2];
		for (int i = 0; i < array.length; i++) {
			int x = Integer.valueOf(array[i]);
			arrayHelper[x + maxByte] = arrayHelper[x + maxByte] + 1;
		}
		int j = 0;
		for (int i = 0; i < arrayHelper.length; i++) {
			while (arrayHelper[i] != 0) {
				array[j] = Integer.toString(i - maxByte);
				arrayHelper[i] = arrayHelper[i] - 1;
				j++;
			}
		}
		return array;
	}
}
