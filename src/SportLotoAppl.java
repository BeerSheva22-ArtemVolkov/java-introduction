
public class SportLotoAppl {

	/**
	 * Application displays out 6 random numbers from 1 to 49 inclusive
	 * numbers can not be repeated in the sequence of 6 random numbers
	 * no additional collections/arrays
	 */
	public static void main(String[] args) {
		int n1 = 0, n2 = 0, n3 = 0, n4 = 0, n5 = 0, n6 = 0, res;
		for (int i = 0; i < 6; i++) {
			res = getRandomInt(1, 49, n1, n2, n3, n4, n5, n6);
			if (i == 0) {n1 = res;}
			if (i == 1) {n2 = res;}
			if (i == 2) {n3 = res;}
			if (i == 3) {n4 = res;}
			if (i == 4) {n5 = res;}
			if (i == 5) {n6 = res;}
			System.out.print(res+ " ");
		}		
	}
	
	public static int getRandomInt(int min, int max, int n1, int n2, int n3, int n4, int n5, int n6) {
		int res = 0;
		do {
			res = (int)((min + Math.random() * (max - min + 1)));
		} while ((res == n1) || (res == n2) || (res == n3) || (res == n4) || (res == n5) || (res == n6));
		return res;
	}
}
