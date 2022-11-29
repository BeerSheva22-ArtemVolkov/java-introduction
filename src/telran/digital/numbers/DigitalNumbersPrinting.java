package telran.digital.numbers;

import static telran.digital.numbers.DigitalNumbersPrinting.displayStrings;
import static telran.digital.numbers.DigitalNumbersPrinting.one;

public class DigitalNumbersPrinting {
	
	private static final String SYMBOL = "*";

	// offset - пробел
	public static void displayDigitalNumber (int number, int offset, int width, int height) {
		int length = String.valueOf(number).length();
		String[] res = emptyArray(height);
		for (int i = length; i > 0; i--) {
			switch ((int) (number / Math.pow(10, i - 1))) {
				case 0:
					res = unitArrays(res, zero(offset, width, height), width, offset) ;
					break;
				case 1:
					res = unitArrays(res, one(offset, width, height), width, offset) ;
					break;
				case 2:
					res = unitArrays(res, two(offset, width, height), width, offset) ;
					break;
				case 3:
					res = unitArrays(res, three(offset, width, height), width, offset) ;
					break;
				case 4:
					res = unitArrays(res, four(offset, width, height), width, offset) ;
					break;
				case 5:
					res = unitArrays(res, five(offset, width, height), width, offset) ;
					break;
				case 6:
					res = unitArrays(res, six(offset, width, height), width, offset) ;
					break;
				case 7:
					res = unitArrays(res, seven(offset, width, height), width, offset) ;
					break;
				case 8:
					res = unitArrays(res, eight(offset, width, height), width, offset) ;
					break;
				case 9:
					res = unitArrays(res, nine(offset, width, height), width, offset) ;
					break;					
			}
			number = number % (int)Math.pow(10, i - 1);			
		}
		displayStrings(res);	
	}
	
	private static String[] emptyArray (int length) {
		String[] res = new String[length];
		for (int i = 0; i < length; i++) {
			res[i] = "";
		}
		return res;
	}
	
	private static String[] unitArrays (String[] firstArray, String[] secondArray, int width, int offset) {
		String[] res = new String[secondArray.length];
		int max = 0;
		for (int i = 0; i < firstArray.length; i++) {
			max = max < secondArray[i].length() ? secondArray[i].length() : max;
			res[i] = firstArray[i] + " " + secondArray[i] + " ".repeat(max - secondArray[i].length());
		}
		return res;
	}
	
	public static String line(int offset, int height) {
		return " ".repeat(offset) + SYMBOL.repeat(height);
	}
	
	public static String[] verticalLine(int offset, int height ) {
		String[] res = new String[height];
		for(int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL;
		}
		return res;
	}
	
	public static String[] twoVerticalLines (int offset, int width, int height) {
		String[] res = new String[height];
		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width - 2) + SYMBOL;
		}
		return res;
	}
	
	public static String[] zero(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String[] lines = twoVerticalLines(offset, width, height - 2);
		System.arraycopy(lines, 0, res, 1, lines.length);
		res[height - 1] = line(offset, width);
		return res;
	}
	
	public static String[] one(int offset, int width, int height) {
		return verticalLine(offset + width - 1, height);
	}
	
	public static String[] two(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String[] lines = verticalLine(offset + width - 1, height/2 );
		System.arraycopy(lines, 0, res, 1, lines.length);
		res[height/2] = line(offset, width);
		String[] lines2 = verticalLine(offset, height/2);
		System.arraycopy(lines2, 0, res, height/2 + 1, lines2.length - 1);
		res[height - 1] = line(offset, width);
		return res;
	}

	
	public static String[] three(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String[] lines = verticalLine(offset + width - 1, height/2 );
		System.arraycopy(lines, 0, res, 1, lines.length);
		res[height/2] = line(offset, width);
		String[] lines2 = verticalLine(offset + width - 1, height/2 );
		System.arraycopy(lines2, 0, res, height/2 + 1, lines2.length - 1);
		res[height - 1] = line(offset, width);
		return res;
	}
	
	public static String[] four(int offset, int width, int height) {
		String[] res = new String[height];
		String[] lines = twoVerticalLines(offset, width, height/2);
		System.arraycopy(lines, 0, res, 0, lines.length);
		res[height/2] = line(offset, width);
		String[] lines2 = verticalLine(offset + width - 1, height/2);
		System.arraycopy(lines2, 0, res, height/2 + 1, height - lines2.length - 1);
		return res;
	}
	
	public static String[] five(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String[] lines = verticalLine(offset, height/2 - 1 );
		System.arraycopy(lines, 0, res, 1, lines.length);
		res[height/2] = line(offset, width);
		String[] lines2 = verticalLine(offset + width - 1, height/2 );
		System.arraycopy(lines2, 0, res, height/2 + 1, lines2.length - 1);
		res[height - 1] = line(offset, width);
		return res;
	}
	
	public static String[] six(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String[] lines = verticalLine(offset, height/2 - 1 );
		System.arraycopy(lines, 0, res, 1, lines.length);
		res[height/2] = line(offset, width);
		String[] lines2 = twoVerticalLines(offset, width, height/2 );
		System.arraycopy(lines2, 0, res, height/2 + 1, lines2.length - 1);
		res[height - 1] = line(offset, width);
		return res;
	}
	
	public static String[] seven(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String[] lines = verticalLine(offset + width - 1, height-1 );
		System.arraycopy(lines, 0, res, 1, lines.length);
		return res;
	}
	
	public static String[] eight(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String[] lines = twoVerticalLines(offset, width, height/2 );
		System.arraycopy(lines, 0, res, 1, lines.length);
		res[height/2] = line(offset, width);
		System.arraycopy(lines, 0, res, height/2 + 1, lines.length - 1);
		res[height - 1] = line(offset, width);
		return res;
	}
	
	public static String[] nine(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);
		String[] lines = twoVerticalLines(offset, width, height/2 );
		System.arraycopy(lines, 0, res, 1, lines.length);
		res[height/2] = line(offset, width);
		String[] lines2 = verticalLine(offset + width - 1, height/2 - 1 );
		System.arraycopy(lines2, 0, res, height/2 + 1, lines.length - 1);
		res[height - 1] = line(offset, width);
		return res;
	}
	
	public static void displayStrings(String[] strings) {
		for (int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
	}
}
