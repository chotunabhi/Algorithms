package com.techgig.hard;

import java.util.Scanner;

public class OddNumber0SubstringInBinary {

	private static void setOfBinaryNumber(String binaryString){
		int odd0Count = 0;
		int odd1Count = 0;
		
		for(int i = 0 ; i < binaryString.length();i++) {
			for(int j = i ; j < (binaryString.length()); j++) {
				int count[] = numberOf1s0s(binaryString.substring(i, j+1));
				
				// has odd 0
				if(count[0] %2 != 0) {
					odd0Count++;
				}
				if(count[1] % 2 != 0) {
					odd1Count++;
				}
			}
		}

		System.out.println(odd0Count+" "+odd1Count);
	}
	
	private static int[] numberOf1s0s(String binaryString) {
		int count[] = new int[2];
		
		for(int i = 0; i<binaryString.length();i++) {
			if(binaryString.charAt(i) == '0')
				count[0]++;
			else
				count[1]++;
		}
		return count;
	}
	private static String convertNumberToBinaryString(double n) {
		StringBuffer binaryString = new StringBuffer();
		double intermediateNumber = n;
		
		while(intermediateNumber > 0.0d) {
			binaryString.append(intermediateNumber%2);
			intermediateNumber /= 2d;
		}
		System.out.println(binaryString.toString());
		return binaryString.reverse().toString();
		
	}
	public static void main (String[] args) { 
//		System.out.println(Long.MAX_VALUE+"\n8470634074737128636070224");
		Double d = 17d;
		
		Double d2 = Double.valueOf(Double.toString(Math.floor(d)));
		
		System.out.println(d+" "+d2);
		System.out.println(Long.toBinaryString(Double.doubleToRawLongBits(d2)));
//		convertNumberToBinaryString(1);
//		Scanner input = new Scanner(System.in);
		
//		byte testCases = input.nextByte();
//		double[] inputs = new double[testCases];
//
//		for(byte i = 0 ; i < testCases; i++) {
//			inputs[i] = input.nextDouble();
//		}
//		
//		for(byte i = 0 ; i < testCases; i++) {
//			setOfBinaryNumber(convertNumberToBinaryString(inputs[i]));	
//		}
//		
//		long startTime = System.currentTimeMillis();
//		
//		System.out.println((System.currentTimeMillis() - startTime));

	} 
}
