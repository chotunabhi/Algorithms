package com.miscellaneous.oracle;

/**
 * 
 * @author abhi
 * @Description
 * Givena sentence and an int array, write a program to rotate individual wordsof the sentence
 * the ith word should be rotated by number of characters equal to ith element of an array. 
 * Size of array be assumed to be number of words in sentence
 * e.g.
 * String = Oracle commerce is hiring java experienced candidates
 * Array = {2, 5, 0, 1, 2, 3, 4}
 * Output = leOrac mercecom is ghirin vaja cedexperien atescandid
 */
public class RotateEveryWord {

	public static String rotate(String str, int[] rotateIndexes) {
		String[] strArr = str.split(" ");
		str = "";
		for(int index = 0; index < rotateIndexes.length; index++) {
			if(rotateIndexes[index] < 0) {
				rotateIndexes[index] = strArr[index].length() - ((rotateIndexes[index] * -1) % strArr[index].length());
			}
			if(rotateIndexes[index] > strArr[index].length()) {
				rotateIndexes[index] %= strArr[index].length();
			}
			str += strArr[index].substring(strArr[index].length() - rotateIndexes[index])
					+ strArr[index].substring(0, strArr[index].length() - rotateIndexes[index]) + " ";
		}
		return str;
	}
	
	public static void main(String... ar) {
		String str = "Oracle commerce is hiring java experienced candidates";
		int[] rotateIndexes = {2, 5, 0, 1, 2, 3, 4};
		System.out.println(rotate(str, rotateIndexes));
	}
}
