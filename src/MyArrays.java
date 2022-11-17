import java.util.Arrays;
public class MyArrays {
	
	/**
	 * 
	 * @param array
	 * @param number
	 * @return new array with added number at the end
	 */
	public static int[] addsNumber(int[] array, int number) {
		int[] outArray = Arrays.copyOf(array, array.length + 1);
		outArray[outArray.length - 1] = number;
		array = outArray;
		return array;
	}
	
	/**
	 * 
	 * @param array
	 * @param index
	 * @return new array with no number at a given index in a given array
	 * if index doesn't exists in a given array, it returns the same array
	 */
	public static int[] removeNumber(int[] array, int index) {
			int[] outArray = array;
			if (index > -1 && index < array.length) {
				outArray = new int[array.length - 1];
		        System.arraycopy(array, 0, outArray, 0, index);
		        System.arraycopy(array, index + 1, outArray, index, array.length - index - 1);
		        // или
//				System.arraycopy(array, index + 1, outArray, index, outArray.length - index);
			}
		return outArray;
	}
	
	/**
	 * 
	 * @param arraySorted
	 * @param number
	 * @return new array with inserted number at an index for keeping array sorted
	 */
	public static int[] insertSorted(int[] arraySorted, int number) {
//		int[] outArray = new int[arraySorted.length+1];
//		int insertedPos = Math.abs(Arrays.binarySearch(arraySorted, number) + 1);
//		System.arraycopy(arraySorted, 0, outArray, 0, insertedPos);
//		System.arraycopy(arraySorted, insertedPos, outArray, insertedPos + 1, arraySorted.length - insertedPos);
//		outArray[insertedPos] = number;
//		return outArray;
		int index = Arrays.binarySearch(arraySorted, number);
		if (index < 0) {
			index = -(index + 1);
		}
		return insertAtIndex(arraySorted, number, index);
	}
	
	public static int[] insertAtIndex (int[] array, int number, int index) {
		int res[] = new int[array.length + 1];
		System.arraycopy(array, 0, res, 0, index);
		System.arraycopy(array, index, res, index + 1, array.length - index);
		res[index] = number;
		return res;
	}
	
	/**
	 * 
	 * @param arraySorted
	 * @param number
	 * @return index value if number exists otherwise -1
	 * O[N] - search number in unsorted array 
	 * O[LogN] - search number in sorted array (binary search)
	 * O - сложность
	 */
	public static int binarySearch(int[] arraySorted, int number) {
		int left = 0;
		int right = arraySorted.length - 1;
		int middle = right / 2;
		while (left <= right && arraySorted[middle] != number) {
			if (number < arraySorted[middle]) {
				right = middle - 1;
			}
			else {
				left = middle + 1;
			}
			middle = (right + left) / 2;
		}
		return left > right ? -1 : middle;
	}
	
	public static int binarySearchDuplicate(int[] arraySorted, int number) {
		int left = 0;
		int right = arraySorted.length - 1;
		int middle = arraySorted.length / 2; 
//		int middle = right / 2;
//		while (left <= right && arraySorted[left] != arraySorted[right] ) {
		while (left <= right && arraySorted[left] != number ) {
			if (number <= arraySorted[middle]) {
				right = middle;
			}
			else {
				left = middle + 1;
			}
			middle = (right + left) / 2;
		}
//		return left > right ? -(left + 1) : left;
		return left < arraySorted.length && arraySorted[left] == number ? left : -(left + 1);
	}
	
	public static boolean isOneSwapForSorted(int[] array) {
		boolean res = false;
		int indToSwap1 = -1;
		int indToSwap2 = -1;
		int SwapCount = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i-1]) {
				if (indToSwap1 == -1) {
					indToSwap1 = i-1;
				}
				indToSwap2 = i;
				SwapCount++;
			}
		}
		
		if (indToSwap1 >= 0 && indToSwap2 >= 0 && SwapCount < 3) {
			if (indToSwap1 - 1 > -1) {
				if (indToSwap2 + 1 < array.length) {
					if ((array[indToSwap1] >= array[indToSwap2 - 1] && array[indToSwap1] <= array[indToSwap2 + 1]
							&& array[indToSwap2] <= array[indToSwap1 + 1]
							&& array[indToSwap2] >= array[indToSwap1 - 1])) {
						res = true;
					}
				} else if (array[indToSwap1] >= array[indToSwap2 - 1] && array[indToSwap2] >= array[indToSwap1 - 1]
						&& array[indToSwap2] <= array[indToSwap1 + 1]) {
					res = true;
				}
			} else if (indToSwap2 + 1 < array.length) {
				if (array[indToSwap2] <= array[indToSwap1 + 1] && array[indToSwap1] >= array[indToSwap2 - 1]
						&& array[indToSwap1] <= array[indToSwap2 + 1]) {
					res = true;
				}
			} else if ((array[indToSwap1] >= array[indToSwap2 - 1] && array[indToSwap2] <= array[indToSwap1 + 1])) {
				res = true;
			} 
		}
		return res;
	}
	
	public static int[] myBubbleSort (int[] array) {
//		boolean sortIsDone = false;
//		while (!sortIsDone) {
//			sortIsDone = moveGreaterRight(array);
//		}
//		return array;
		int unsortedLength = array.length;
		do {
			unsortedLength = moveGreaterRight(array, unsortedLength - 1); 
		} while(unsortedLength != 0);
		return array;
	}
	
// private static boolean moveGreaterRight(int[] array) {
//		boolean isSorted = true;
//		for (int i = 0; i < array.length-1; i++) {
//			if (array[i] > array[i+1]) {
//				isSorted = false;
//				int bubble = array[i];
//				array[i] = array[i+1];
//				array[i+1] = bubble;
//			}	
//		}	
//		return isSorted;
	private static int moveGreaterRight(int[] array, int length) {
		int res = 0;
		for (int i = 0; i < length; i++) {
			if (array[i] > array[i+1]) {
				res = i + 1;
				swap(array, i, i + 1);
			}
		}
		return res;
	}
	
	public static int[] swap(int[] array, int i, int j) {
			int bubble = array[i];
			array[i] = array[j];
			array[j] = bubble;	
			return array;
	}
	
	/**
	 * 
	 * @param array of short positive numbers
	 * @param sum
	 * @return true if array contains two numbers, sun of which equals a given sum
	 */
	static public boolean isSum2(short[] array, short sum) {
		boolean res = false;
		int[] secondArray = new int[0];
		int i = 0;
		do {
			if (contains(secondArray, array[i])) {
				res = true;
			}
			secondArray = addsNumber(secondArray, sum - array[i]);
			i++;
		} while (i < array.length && !res);
		return res;
	}
	
	static public boolean isSum2ByYuri(short[] array, short sum) {
		boolean res = false;
		boolean[] helper = new boolean[sum >= 0 ? sum + 1 : 0x7fff + 1];
		int index = 0;
		while(index < array.length && !res) {
			short diff = (short) (sum - array[index]);
			if (diff >= 0) {
				if (helper[diff]) {
					res = true;
				}
				else {
					helper[array[index]] = true;
				}
			}
			index++;
		}
		return res;
	}
	
	public static boolean contains(int[] array, int val) {

        boolean res = false;
        for(int i = 0; i < array.length; i++){
            if(array[i] == val){
            	res = true;
                break;
            }
        }
        return res;
    }
}
