import java.util.Arrays;
public class MyArrays {
	/**
	 * 
	 * @param array
	 * @param number
	 * @return new array with added number at the end
	 */
	public static int[] addsNumber(int[] array, int number) {
		int[] outArray = Arrays.copyOf(array, array.length+1);
		outArray[outArray.length - 1] = number;
		return outArray;
	}
	
	/**
	 * 
	 * @param array
	 * @param index
	 * @return new array with no number at a given index in a given array
	 * if index doesn't exists in a given array, it returns the same array
	 */
	public static int[] removeNumber(int[] array, int index) {
        int[] outArray = new int[array.length-1];
        System.arraycopy(array, 0, outArray, 0, index);
        System.arraycopy(array, index + 1, outArray, index, array.length - index - 1);
		return outArray;
	}
	
	/**
	 * 
	 * @param arraySorted
	 * @param number
	 * @return new array with inserted number at an index for keeping array sorted
	 */
	public static int[] insertSorted(int[] arraySorted, int number) {
		int[] outArray = new int[arraySorted.length+1];
		int insertedPos = Math.abs(Arrays.binarySearch(arraySorted, number) + 1);
		System.arraycopy(arraySorted, 0, outArray, 0, insertedPos);
		System.arraycopy(arraySorted, insertedPos, outArray, insertedPos + 1, arraySorted.length - insertedPos);
		outArray[insertedPos] = number;
		return outArray;
	}
}
