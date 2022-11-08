
public class SportLotoAppl {

	/**
	 * Application displays out 6 random numbers from 1 to 49 inclusive
	 * numbers can not be repeated in the sequence of 6 random numbers
	 * no additional collections/arrays
	 */
	static long mask = 0; 
	public static void main(String[] args) {
		//long num = 0;
		for (int i = 0; i < 6; i++) {
			System.out.print(getUniqueRandomInt(1, 49) + " ");
		}		
	}
	
	public static int getUniqueRandomInt(int min, int max) {
		int res = 0;
		do {
			res = (int)((min + Math.random() * (max - min + 1)));
		} while (BitOperations.getBitValue(mask, res) == 1);
		mask = BitOperations.invertBitValue(mask, res);
		return res;
	}
}

