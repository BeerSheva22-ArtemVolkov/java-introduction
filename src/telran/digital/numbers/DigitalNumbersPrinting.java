package telran.digital.numbers;

public class DigitalNumbersPrinting {
	
	private static final String SYMBOL = "*";

	public void displayDigitalNumber (int number, int width, int height) {
		//TODO
	}
	
	public static String line(int offset, int length) {
		return " ".repeat(offset) + SYMBOL.repeat(length);
	}
	
	public static String[] verticalLine(int offset, int height ) {
		String[] res = new String[height];
		for(int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL;
		}
		return res;
	}
}
