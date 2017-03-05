package com.miscellaneous;

public class NumberToWords {
	private static String[] ones = { "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN",
			"ELEVEN", "TWELVVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN" };
	private static String[] tens = { "TWENTY", "THIRTY", "FOURTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY" };
	private static StringBuffer result = new StringBuffer();

	private static final int CRORE = 10000000;
	private static final int LAKH = 100000;
	private static final int THOUSAND = 1000;
	private static final int HUNDERED = 100;

	public static void main(String[] args) {
		int number = Integer.MAX_VALUE;

		System.out.println(number +" : "+numberToWord(number));
	}

	private static String numberToWord(int n) {
		StringBuffer result = new StringBuffer();
		boolean hasAnd = n >= HUNDERED?true:false;
		
		if (n > CRORE) {
			result.append(numberToWord(n / CRORE));
			result.append(" CRORES ");
			n %= CRORE;
			
		}
		if (n > LAKH) {
			String twoWords = twoDigitToWord(n / LAKH);
			result.append(twoWords);
			result.append(" LAKHS ");
			n %= LAKH;
		}
		if (n > THOUSAND) {
			result.append(twoDigitToWord(n/ THOUSAND));
			result.append(" THOUSAND ");
			n %= THOUSAND;
		}
		if (n >= HUNDERED) {
			result.append(ones[n/HUNDERED - 1]);
			result.append(" HUNDERED ");
//			hasAnd = true;
			n%= HUNDERED;
		}
		if (n > 0) {
			if(hasAnd)
				result.append(" AND ");
			result.append(twoDigitToWord(n));
		}

		return result.toString();
	}

	/**
	 * 
	 * @param n
	 * @return two digit number related word
	 */
	private static String twoDigitToWord(int n) {
		StringBuffer result = new StringBuffer();

		if (n > 19) {
			result.append(tens[n / 10 - 2]);

			if (n % 10 > 0)
				result.append(ones[n % 10 - 1]);
		} else
			result.append(ones[n - 1]);

		return result.toString();
	}
}
