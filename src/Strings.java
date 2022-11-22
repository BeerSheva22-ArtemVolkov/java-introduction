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
	
	public static boolean isAnagramByYuri(String str1, String str2) {
		boolean res = false;
		if (str1.length() == str2.length()) {
			int[] helper = new int[Byte.MAX_VALUE];
			res = true;
			fillHelper(helper, str1);
			int index = 0;
			int length = str1.length();
			while(index < length && res) {
				int indSymb = str2.charAt(index);
				if (helper[indSymb] == 0) {
					res = false;
				} 
				else {
					helper[indSymb]--;
					index++;
				}
			}
		}		
		return res;
	}
	
	private static void fillHelper(int[] helper, String str1) {
		
		int length = str1.length();
		for (int i = 0; i < length; i++) {
			int ind = str1.charAt(i);
			helper[ind]++;
		}
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
	
	public static String[] sortStringNumbersByYuri(String[] array) {
		int offset = Byte.MAX_VALUE + 1;
		int[] helper = new int[offset * 2];
		fillHelper(helper, array, offset);
		sortFromHelper(array, helper, offset);
		return array;
	}

	private static void fillHelper(int[] helper, String[] array, int offset) {
		for (int i = 0; i < array.length; i++) {
			int index = getIndexFromString(array[i], offset);
			helper[index]++;
		}
	}

	private static int getIndexFromString(String string, int offset) {
		int number = Integer.parseInt(string);
		return number + offset;
	}

	private static void sortFromHelper(String[] array, int[] helper, int offset) {
		int arrayInd = 0;
		for (int i = 0; i < helper.length; i++) {
			for (int j = 0; j < helper[i]; j++) {
				array[arrayInd++] = getStringNumberFromIndex(i, offset);
			}
		}
	}

	private static String getStringNumberFromIndex(int index, int offset) {
		int number = index - offset;
		return Integer.toString(number);
	}

	public static String javaNameExp() {
		return "[a-zA-Z$][\\w$]*|_[\\w$]+";
	}
	
	public static String ip4Octet() {
		return "25[0-5]|2[0-4]\\d|[01]\\d{1,2}|0{1,3}|\\d{1,2}|0{1,2}\\d";
	}
	
	public static String ipV4() {
		return "(25[0-5]|2[0-4]\\d|[01]\\d{1,2}|0{1,3}|\\d{1,2}|0{1,2}\\d)\\.(25[0-5]|2[0-4]\\d|[01]\\d{1,2}|0{1,3}|\\d{1,2}|0{1,2}\\d)\\.(25[0-5]|2[0-4]\\d|[01]\\d{1,2}|0{1,3}|\\d{1,2}|0{1,2}\\d)\\.(25[0-5]|2[0-4]\\d|[01]\\d{1,2}|0{1,3}|\\d{1,2}|0{1,2}\\d)";
	}
}
