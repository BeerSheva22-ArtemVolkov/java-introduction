import java.util.Random;

public class IsraelIdentity {
	
	public static final int N_OF_DIGITS = 9;
	
	/**
	 * 
	 * @param id
	 * @return true for right id otherwise false number control sum should be
	 *         multiple of 10 (sum % 10 = 0) for even indexes (0,2,4,6,8) digits as
	 *         is for odd indexes (1,3,5,7,9) = digit * 2, if > 9 then sum of inner
	 *         digits is taken EXAMPLE: 123456782 => 1 + 2*2 + 3 + 4*2 + 5 + 3
	 *         (6*2=12=>1+2) + 7 + 7 (8*2=16=>1+6) + 2 = 40 => true
	 */
	public static boolean verify(int id) {
		
		int[] numArray = Numbers.getDigits(id);
		boolean res = false;
		if (id > 0) {
			if (numArray.length == N_OF_DIGITS) {
				int sum = 0;
				for (int i = 0; i < numArray.length; i++) {
					// System.out.println(array[i]);
					if (i % 2 == 0) {
						sum += numArray[i];
					} else if (numArray[i] * 2 > 9) {
						sum += (numArray[i] * 2) / 10 + (numArray[i] * 2) % 10;
					} else {
						sum += numArray[i] * 2;
					}
				}
				res = (sum % 10 == 0) ? true : false;
			}
		}
		return res;
	}

	/**
	 * 
	 * @return random number of 9 digits matching right Israel id cycle not more
	 *         than 9 iterations
	 */
	public static int generateRandom() {
//		Random rand = new Random();
//		int res = rand.nextInt(9) + 1, randNum;
//		int sum = res;
//		for (int i = 1; i < N_OF_DIGITS - 1; i++) {	
//			randNum = rand.nextInt(10);
//			if (i % 2 == 0) {
//				sum += randNum;
//			} else if (randNum * 2 > 9) {
//				sum = sum + (randNum * 2) / 10 + (randNum * 2) % 10;
//			} else {
//				sum = sum + randNum * 2;
//			}
//			res = res * 10 + randNum;
//		}
//		res = res * 10 + (int)Math.ceil((double)sum / 10) * 10 - sum;
//		return res;
		int[] digits = new int [N_OF_DIGITS - 1];
		fillRandomDigits(digits);
		int controlSum = getControlSum(digits);
		int lastDigit = getLastDigit(controlSum);
		int res = Numbers.getNumberFromDigits(digits);
		res = res * 10 + lastDigit;
		return res;
	}
	
	private static int getLastDigit(int controlSum) {
		int rem = controlSum % 10;
		int res = 0;
		if (rem != 0 ) {
			res = 10 - rem;
		}
		return res;
	}

	private static void fillRandomDigits(int[] digits) {
		digits[0] = (int) Numbers.getRandomNumber(1,9);
		for (int i = 1; i < digits.length; i++) {
			digits[i] = (int) Numbers.getRandomNumber(0,9);
		}
	}

	private static int getControlSum (int[] digits) {
		return sumEvenIndexes(digits) + sumOddIndexes(digits);
	}

	private static int sumOddIndexes(int[] digits) {
		int res = 0;
		for (int i = 1; i < digits.length; i += 2) {
			int digit = digits[i] * 2;
			if (digit > 9) {
				digit -= 9;
			}
			res += digit;
		}
		return res;
	}

	private static int sumEvenIndexes(int[] digits) {
		int res = 0;
		for (int i = 0; i < digits.length; i += 2) {
			int digit = digits[i] * 2;
			res += digit;
		}
		return res;
	}
}
