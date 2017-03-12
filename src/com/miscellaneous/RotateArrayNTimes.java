package com.miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotateArrayNTimes {

	// Oracle is hiring
	// [4, 2, 1]
	// acleOr is ghirin

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter the string : ");
		String[] strings = reader.readLine().split(" ");

		int[] rotations = new int[strings.length];
		System.out.println("Enter rotations for each string");

		for(int i = 0;i < rotations.length;i++)
			rotations[i] = Integer.parseInt(reader.readLine());
		
		StringBuffer result = new StringBuffer();

		for (int i = 0; i < strings.length; i++) {
			int rotation = rotations[i];
			String string = strings[i];
			String rotatedString = "";
			
			if(rotation >= 0)
				rotatedString = rotateArrayNTimes(string, rotation);
			else if(rotation < 0){
				while(rotation < 0){
					rotation += string.length();
				}
				rotatedString = rotateArrayNTimes(string, string.length() + rotation);
			}
			
			result.append(rotatedString);
			result.append(" ");
		}

		System.out.println(result.toString().trim());
	}

	public static String rotateArrayNTimes(String str, int n) {
		char[] chars = str.toCharArray();
		int rotation = n % chars.length;
		char[] temp = new char[rotation];

		// storing in temporary array
		for (int i = 0; i < rotation; i++)
			temp[i] = chars[chars.length - rotation + i];

		// shifting characters to right
		for (int i = chars.length - 1 - rotation; i >= 0; i--)
			chars[i + rotation] = chars[i];

		// filling chars from temp
		for (int i = 0; i < rotation; i++)
			chars[i] = temp[i];

		return new String(chars);
	}
}
