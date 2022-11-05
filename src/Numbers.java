
public class Numbers {
	
	private static final int N_BITS = 64;
	
	static public int getNdigits(long number) {
		int res = 0;
		do {
			number /= 10; 
			res++;
		} while (number != 0);
		return res;
	}
	/**
	 * 
	 * @param number
	 * @return true only if number comprise of 6 digits
	 * and sum of first three digits equals sum of last three digits
	 */
	static public boolean isHappyNumber(int number) {
		boolean res = false;
		if (Numbers.getNdigits(number) == 6){
			int FirstThird = 0, LastThird = 0;
			for (int pos = 1; pos <= 6; pos++) {
				FirstThird = (pos <= 3) ? FirstThird + (number % 10) : FirstThird + 0;
				LastThird = (pos <= 3) ? LastThird + 0 : LastThird + (number % 10);
				number /= 10;
			}
			res = (FirstThird == LastThird) ? true : false;
		}	
		return res;
	}
	
	static public int leadingZeros(long number) {
		int res = 0;
		int nBit = N_BITS - 1;
		long mask = BitOperations.getMask(nBit);
		while (((number & mask) == 0) && (nBit >= 0)) {
			res++;
			nBit--;
			mask = BitOperations.getMask(nBit);
		}
		return res;
	}
}
