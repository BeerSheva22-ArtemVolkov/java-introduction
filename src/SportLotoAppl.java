
public class SportLotoAppl {

	/**
	 * Application displays out 6 random numbers from 1 to 49 inclusive
	 * numbers can not be repeated in the sequence of 6 random numbers
	 * no additional collections/arrays
	 */
	public static void main(String[] args) {
		long num = 0;
		int res;
		for (int i = 0; i < 6; i++) {
			res = getRandomInt(1, 49, num);
			num = BitOperations.invertBitValue(num, res);
			System.out.print(res+ " ");
		}		
	}
	
	public static int getRandomInt(int min, int max, long num) {
		int res = 0;
		do {
			res = (int)((min + Math.random() * (max - min + 1)));
		} while (BitOperations.getBitValue(num, res) != 0);
		return res;
	}
}
