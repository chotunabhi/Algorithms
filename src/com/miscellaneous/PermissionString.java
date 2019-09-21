package com.miscellaneous;

public class PermissionString {
	public static int symbolicToOctal(String permString) {
		int resultantNumber = 0;

		if(permString.length() != 9)
			throw new UnsupportedOperationException("Waiting to be implemented.");

		for(int i = 0 ; i < permString.length(); i++) {
			int charVal = characterValue(permString.charAt(i));
			
			if(charVal == -1)
				throw new UnsupportedOperationException("Waiting to be implemented.");
			
			resultantNumber += charVal;
			
			if((i+1) % 3 == 0 && (i+1) != permString.length())
				resultantNumber *= 10;
		}


		return resultantNumber;
	}

	private static int characterValue(char c) {
		int value = 0;

		switch (c) {
		case 'r':
			value = 4;
			break;
		case 'w':
			value = 2;
			break;
		case 'x':
			value = 1;
			break;
		case '-':
			value = 0;
			break;
		default:
			value = -1;
		}

		return value;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(PermissionString.symbolicToOctal("rwxr-x-w-"));
		System.out.println(PermissionString.symbolicToOctal("rwxr-x-w"));
	}

}
