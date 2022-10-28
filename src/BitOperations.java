/**
 * Right nBit value [0, 63]
 * All methods will return -1 in the case of wrong nBit
 *
 */
public class BitOperations {
	
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
			long mask = 1 << nBit; //all bits are 0 except bit with number nBit
			if ((number & mask) == 0) {
				res = 0;
			} else {
				res = 1;
			}
		}
		return res;
	}
	
	/**
	 * 
	 * @param number - any number
	 * @param nBit - bit number
	 * @param value - true = 1 / false = 0
	 * @return new number which value of nBit'h bit will have a given value
	 */
	static public long setBitValue(long number, int nBit, boolean value) {
		if (checkNbit(nBit)) {
			long mask = 1 << nBit; //all bits are 0 except bit with number nBit
			if ((number & mask) == 0 && value == true) {
				return number + mask;
			} 
			else if ((number & mask) != 0 && value == false) {
				return number - mask;
			}
			else return number;
		}
		return -1;
	}
	
	/**
	 * 
	 * @param number - any number
	 * @param nBit - bit number
	 * @return new number in which nBit'h will be revert (old value - 1, new value - 0)
	 */
	static public long revertBitValue(long number, int nBit) {
		if (checkNbit(nBit)) {
			long mask = 1 << nBit; //all bits are 0 except bit with number nBit
			if ((number & mask) == 0) {
				return number + mask;
			} 
			else
				return number - mask;
		}
		return -1;
	}
	
	private static boolean checkNbit(int nBit) {
		return nBit <  64 && nBit > -1;
	}
}
