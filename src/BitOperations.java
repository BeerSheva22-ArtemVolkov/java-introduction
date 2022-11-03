/**
 * Right nBit value [0, 63]
 * All methods will return -1 in the case of wrong nBit
 *
 */
public class BitOperations {
	
	private static final int N_BITS = 64;

	/**
	 * 
	 * @param number - any number
	 * @param nBit - number of bit
	 * @param value - true = 1 / false = 0
	 * @return value of bit with number nBit
	 */
	static public int getBitValue(long number, int nBit) {
		int res = -1;
		if (checkNbit(nBit)) {
			long mask = getMask(nBit); //all bits are 0 except bit with number nBit
			res = (number & mask) == 0 ? 0 : 1; // (1)
//			if ((number & mask) == 0) {
//				res = 0;
//			} else {
//				res = 1;
//			} // (2)
			// (1) <=> (2)
		}
		return res;
	}

	private static long getMask(int nBit) {
		return 1L << nBit;
	}
	
	/**
	 * 
	 * @param number - any number
	 * @param nBit - bit number
	 * @param value - true = 1 / false = 0
	 * @return new number which value of nBit'h bit will have a given value
	 */
	static public long setBitValue(long number, int nBit, boolean value) {
		long res = -1;
		if (checkNbit(nBit)) {
			long mask = getMask(nBit); //all bits are 0 except bit with number nBit
//			if ((number & mask) == 0 && value == true) {
//				return number + mask;
//			} 
//			else if ((number & mask) != 0 && value == false) {
//				return number - mask;
//			}
//			else return number;
			res = value ? number | mask : number & ~mask;
		}
		return res;
	}
	
	/**
	 * 
	 * @param number - any number
	 * @param nBit - bit number
	 * @return new number in which nBit'h will be inverted (old value - 1, new value - 0)
	 */
	static public long invertBitValue(long number, int nBit) {
		long res = -1;
		if (checkNbit(nBit)) {
			long mask = getMask(nBit); //all bits are 0 except bit with number nBit
//			if ((number & mask) == 0) {
//				return number + mask;
//			}
//			else
//				return number - mask;
			res = number ^ mask; 
		}
		return res;
	}
	
	private static boolean checkNbit(int nBit) {
		return nBit <  64 && nBit > -1;
	}
	
	static public int leadingZeros(long number) { // количество незначащих нулей
		int res = 0;
		int nBit = N_BITS - 1;
		while(nBit >= 0 && getBitValue(number, nBit) == 0) {
			nBit--;
			res++;
		}
		return res;
	}
	
	static public int onesInNumber(long number) {
		int res = 0;
		for (int i = 0; i < N_BITS; i++) {
			//res += getBitValue(number, i);
			if (getBitValue(number, i) == 1) {
				res++;
			}
		}
		return res;
	}
}
