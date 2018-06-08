package CaesarCipher;

public class CaesarCipher {

	public String encryptTwoKeys(String input, int key1, int key2) {
		StringBuilder encryptString = new StringBuilder(input);
		
		for(int i=0;i<encryptString.length();i++) {
			if((i+1)%2!=0) {
				encryptString.setCharAt(i, shiftCharacter(encryptString.charAt(i), key1));
			} else encryptString.setCharAt(i, shiftCharacter(encryptString.charAt(i), key2));
		}
		
		return encryptString.toString();
	}
	
	public String encrypt(String input, int key) {
		StringBuilder encryptString = new StringBuilder(input);

		for (int i = 0; i < input.length(); i++) {
			
			if (encryptString.charAt(i) >= 65 && encryptString.charAt(i) <= 90) {
				encryptString.setCharAt(i, shiftCharacter(encryptString.charAt(i), key));
			} else if (encryptString.charAt(i) >= 97 && encryptString.charAt(i) <= 122) {
				encryptString.setCharAt(i, shiftCharacter(encryptString.charAt(i), key));
			}
		}

		return encryptString.toString();
	}

	private char shiftCharacter(char ch, int key) {
		// TODO Auto-generated method stub
		if (ch >= 65 && ch <= 90) {
			if (ch + key <= 90)
				ch = (char) (ch + key);
			else
				ch = (char) (64 + (ch + key - 90));
		} else if (ch >= 97 && ch <= 122) {
			if (ch + key <= 122)
				ch = (char) (ch + key);
			else
				ch = (char) (96 + (ch + key - 122));
		}

		return ch;
	}

	public String emphasize(String phrase, char ch) {
		StringBuilder sb = new StringBuilder(phrase);

		for (int i = 0; i < sb.length(); i++) {
			if (isVowel(sb.charAt(i)) && i % 2 != 0) {
				sb.setCharAt(i, '+');
			} else if (isVowel(sb.charAt(i)) && i % 2 == 0) {
				sb.setCharAt(i, '*');
			}
		}

		return sb.toString();
	}

	public String repalceVowels(String phrase, char ch) {
		StringBuilder sb = new StringBuilder(phrase);

		for (int i = 0; i < sb.length(); i++) {
			if (isVowel(sb.charAt(i))) {
				sb.setCharAt(i, ch);
			}
		}

		return sb.toString();
	}

	private boolean isVowel(char ch) {
		if (Character.toLowerCase(ch) == 'a' || Character.toLowerCase(ch) == 'e' || Character.toLowerCase(ch) == 'o'
				|| Character.toLowerCase(ch) == 'u' || Character.toLowerCase(ch) == 'i') {
			return true;
		} else
			return false;
	}
}
