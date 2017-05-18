package com.miscellaneous;

public class NumberToWords {
	private static String[] ones = { "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN",
			"ELEVEN", "TWELVVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN" };
	private static String[] tens = { "TWENTY", "THIRTY", "FOURTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY" };
	private static StringBuffer result = new StringBuffer();

	private static final long CRORE = 10000000;
	private static final long LAKH = 100000;
	private static final long THOUSAND = 1000;
	private static final long HUNDERED = 100;

	private static String[] powerOfHunderedsStrings = { " HUNDERED ", " THOUSAND ", " MILLION ", " BILLION ",
	" TRILLION " };
	private static long[] powerOfHundereds = { (long) Math.pow(10, 2), (long) Math.pow(10, 3), (long) Math.pow(10, 6),
			(long) Math.pow(10, 9), (long) Math.pow(10, 12) };

	public static void main(String[] args) {
		long number = 123456789123456789l;

		// System.out.println(number + " : " + numberToWordIndian(number));
		System.out.println(number + " : " + numberToWordAmerican(number));
	}

	/**
	 * prints number in words in Indian system i.e., lakhs crores etc
	 * 
	 * @param n
	 *            - number
	 * @return representation of the number in words
	 */
	private static String numberToWordIndian(long n) {
		StringBuffer result = new StringBuffer();
		boolean hasAnd = n >= HUNDERED ? true : false;

		if (n > CRORE) {
			result.append(numberToWordIndian(n / CRORE));
			result.append(" CRORES ");
			n %= CRORE;

		}
		if (n > LAKH) {
			String twoWords = twoDigitToWord((int) (n / LAKH));
			result.append(twoWords);
			result.append(" LAKHS ");
			n %= LAKH;
		}
		if (n > THOUSAND) {
			result.append(twoDigitToWord((int) (n / THOUSAND)));
			result.append(" THOUSAND ");
			n %= THOUSAND;
		}
		if (n >= HUNDERED) {
			result.append(ones[(int) (n / HUNDERED - 1)]);
			result.append(" HUNDERED ");
			// hasAnd = true;
			n %= HUNDERED;
		}
		if (n > 0) {
			if (hasAnd)
				result.append(" AND ");
			result.append(twoDigitToWord((int) n));
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

	private static String numberToWordAmerican(double n) {

		boolean hasAnd = n > HUNDERED ? true : false;

		int suffix = powerOfHundereds.length - 1;

		while (n > 0) {
			if (n / powerOfHundereds[powerOfHundereds.length - 1] > 999) {
				result.append(numberToWordAmerican(n / powerOfHundereds[powerOfHundereds.length - 1]));
				result.append(powerOfHunderedsStrings[powerOfHundereds.length - 1]);
			} else {
				long divisor = powerOfHundereds[suffix];
				int threeDigitNum = n >= 1000 ? (int) (n / divisor) : (int) n;

				if (threeDigitNum > 0) {
					result.append(threeDigitToWord(threeDigitNum));

					if (n >= 1000)
						result.append(powerOfHunderedsStrings[suffix]);
				}
			}

			n = n >= 1000 ? n % powerOfHundereds[suffix--] : 0;
		}

		return result.toString();
	}

	private static String threeDigitToWord(int n) {
		StringBuffer result = new StringBuffer();

		if (n > 99) {
			result.append(ones[n / 100 - 1]);
			result.append(powerOfHunderedsStrings[0]);
			result.append(" AND ");
			n %= 100;
		}

		if(n > 0)
			result.append(twoDigitToWord(n));

		return result.toString();
	}
}
