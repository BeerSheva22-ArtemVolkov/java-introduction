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
//		for (int i = 0; i < arrayHelper.length; i++) {
//			while (arrayHelper[i] != 0) {
//				array[j] = Integer.toString(i - maxByte);
//				arrayHelper[i] = arrayHelper[i] - 1;
//				j++;
//			}
//		}
		for (int i = 0; i < arrayHelper.length; i++) {
			for(int l = 0; l < arrayHelper[i]; l++) {
				array[j++] = Integer.toString(i - maxByte);
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
		return "([01]?\\d\\d?|2([0-4]\\d|5[0-5]))";
	}
	
	public static String ipV4() {
		String octetExp = ip4Octet();
		return String.format("(%1$s\\.){3}%1$s", octetExp);
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
		names = getUpdatedNames(names);
		values = getUpdatedValues(values, names);
		if (isArithmeticExpression(expression) && checkBraces(expression)) {
			expression = expression.replaceAll("[\\s()]+", "");
			String[] operands = expression.split(operator());
			String[] operators = expression.split(operand());
			res = getOperandValue(operands[0], values, names);
			int index = 1;
			while(index < operands.length && !res.isNaN()) {
				double operandValue = getOperandValue(operands[index], values, names);
				res = computeOperation(res, operandValue, operators[index]);
				index++;
			}
		}
		return res;
	}
	
	private static double[] getUpdatedValues(double[] values, String[] names) {
		if (values == null) {
			values = new double[0];
		}
		else if (values.length != names.length) {
			values = Arrays.copyOf(values, names.length);
		}
		return values;		
	}

	private static String[] getUpdatedNames(String[] names) {
		return names == null ? new String[0] : names;
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
		String numberExp = numberExp();
		String variableExp = javaNameExp();
		return String.format("(\\(*(%s|%s)\\)*)", numberExp, variableExp);  //"((\\_+[\\w$]+)|(\\d+\\.?\\d*|\\.\\d+)|([a-zA-Z$]+\\d*))";
	}
	
	private static String numberExp() {
		return "(\\d+\\.?\\d*|\\.\\d+)";
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

	private static Double getOperandValue(String operand, double[] values, String[] names) {
		
		Double res = Double.NaN;
		if (operand.matches(numberExp())){
			res = Double.valueOf(operand);
		}
		else {
			int index = Arrays.binarySearch(names, operand);
			if (index > -1) {
				res = values[index];
			}
		}
		return res;
	}

	public static boolean checkBraces(String expression) {
		
		int bracesCount = 0, i = 0, expLength = expression.length();
		while (i < expLength && bracesCount > -1) {
			char letter = expression.charAt(i);
			if (letter == '(') {
				bracesCount++;
			}
			else if(letter == ')'){
				bracesCount--;
			}
			i++;
		}
		return bracesCount == 0;
	}
	
	
	
}
