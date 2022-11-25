package telran.text;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
		//return "2(5[0-5]|[0-4]\\d)|([01]?\\d\\d?)";
		return "([01]?\\d\\d?|2([0-4]\\d|5[0-5]))";
		//return "25[0-5]|2[0-4]\\d|[01]\\d{1,2}|0{1,3}|\\d{1,2}|0{1,2}\\d";
	}
	
	public static String ipV4() {
		String octetExp = ip4Octet();
		return String.format("(%1$s\\.){3}%1$s", octetExp);
		//return "((25[0-5]|2[0-4]\\d|[01]\\d{1,2}|0{1,3}|\\d{1,2}|0{1,2}\\d)\\.){3}(25[0-5]|2[0-4]\\d|[01]\\d{1,2}|0{1,3}|\\d{1,2}|0{1,2}\\d)";
	}
	
	/**
	 * 
	 * @param expression
	 * @param values
	 * @param namesSorted - variable names sorted by strings
	 * @return computed value of a given expression or Double.NaN 
	 */
	public static Double computeArithmeticExpression(String expression, double[] values, String[] names) {
		Double res = Double.NaN;
		if (isArithmeticExpression(expression) && checkBraces(expression)) {
			expression = expression.replaceAll("[\\s()]+", "");
			String[] operands = expression.split(operator());
			String[] operators = expression.split(operand());
			res = getOperandValue(operands[0], values, names);
			int index = 1;
			int operatorIndex = 0;
			while(index < operands.length && !res.isNaN()) {
				double operandValue = getOperandValue(operands[index], values, names);
				while (operators[operatorIndex] == "") {
					operatorIndex++;
				}
				res = computeOperation(res, operandValue, operators[operatorIndex]);
				operatorIndex++;
				index++;
			}
		}
		return res;
	}
	
	public static boolean isArithmeticExpression(String expression) {
		expression = expression.replaceAll("\\s+", ""); // заменяет белые символы на пустоту
		return expression.matches(arithmeticExpression());
	}
	
	private static String arithmeticExpression() {
		String operatorExp = operator();
		String operandExp = operand();
		
		return String.format("\\(*%1$s(%2$s\\)*\\(*%1$s\\)*)*", operandExp, operatorExp); // %1$s = operandExp, %2$s = operatorExp
	}

	public static String operand() {
		return "((\\d+\\.?\\d*|\\.\\d+)|([a-zA-Z]*))";
	}

	private static String operator() {
		return "([-+*/])";
	}

	private static Double computeOperation(Double operand1, double operand2, String operator) {
		
		Double res = Double.NaN;
		if (!Double.isNaN(operand2)) {
			switch(operator) {
				case "+": res = operand1 + operand2;
				break;
				case "-": res = operand1 - operand2;
				break;
				case "/": res = operand1 / operand2;
				break;
				case "*": res = operand1 * operand2;
				break;
				default: res = Double.NaN;
			}
		}
		return res;
	}

	public static Double getOperandValue(String operand, double[] values, String[] names) {
		
		Double res = null;
		if (operand.matches("(\\d+\\.?\\d*|\\.\\d+)")){
			res = Double.parseDouble(operand);
		}
		else {
			int idx = 0;
			while (res == null) {
				if (names[idx].equals(operand)) {
					res = values[idx];
				}
				idx++;
			}
		}
		return res;
	}

	public static boolean checkBraces(String expression) {
		
		boolean res = false;
		int bracesCount = 0, i = 0;
		while (bracesCount >= 0 && i < expression.length()) {
			char letter = expression.charAt(i);
			if (letter == '(') {
				bracesCount++;
			}
			else if(letter == ')'){
				bracesCount--;
			}
			i++;
		}
		if (bracesCount == 0) {
			res = true;
		}
		else {
			res = false;
		}
		return res;
	}
	
	
	
}
