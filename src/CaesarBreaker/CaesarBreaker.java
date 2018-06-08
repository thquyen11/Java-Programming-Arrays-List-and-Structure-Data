package CaesarBreaker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import CaesarCipher.CaesarCipher;

public class CaesarBreaker {

	public String decrypt2Keys(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		StringBuilder sbOdd = new StringBuilder();
		StringBuilder sbEven = new StringBuilder();
		StringBuilder sbDecrypt = new StringBuilder();

		String encryptedMessage = br.readLine();
		while (encryptedMessage != null) {
			for (int i = 0; i < encryptedMessage.length(); i++) {
				if ((i + 1) % 2 != 0) {
					sbOdd.append(encryptedMessage.charAt(i));
				} else
					sbEven.append(encryptedMessage.charAt(i));
			}

			String decryptedOdd = decrypt(sbOdd.toString());
			String decryptedEven = decrypt(sbEven.toString());

			Queue<Character> queueOdd = new LinkedList<>();
			Queue<Character> queueEven = new LinkedList<>();
			for (Character ch : decryptedOdd.toCharArray()) {
				queueOdd.add(ch);
			}
			for (Character ch : decryptedEven.toCharArray()) {
				queueEven.add(ch);
			}

			for (int i = 0; i < encryptedMessage.length(); i++) {
				if ((i + 1) % 2 != 0) {
					sbDecrypt.append(queueOdd.poll());
				} else
					sbDecrypt.append(queueEven.poll());
			}
			sbDecrypt.append("\n");
			sbOdd=new StringBuilder();
			sbEven=new StringBuilder();
			encryptedMessage = br.readLine();
		}

		br.close();
		return sbDecrypt.toString();

	}

	public String decrypt(String encryptedMessage) throws IOException {
		CaesarCipher cc = new CaesarCipher();
		String decryptionKey = "abcdefghijklmnopqrstuvwxyz";
		String decryptedMessage = "";

		List<Integer> countLetters = new LinkedList<>();
		for (int i = 0; i < decryptionKey.length(); i++)
			countLetters.add(0);

		countLetters = CountLetters(encryptedMessage, countLetters);

		int maxIndex = IndexOfMax(countLetters);
//		int posAlphs = (char) decryptionKey.indexOf(maxIndex);

		if (maxIndex < 4) {
			decryptedMessage = cc.encrypt(encryptedMessage, 4 - maxIndex) + "\n";
		} else
			decryptedMessage = cc.encrypt(encryptedMessage, 26 - (maxIndex - 4)) + "\n";

		return decryptedMessage;
	}

	public String decrypt(File file) throws IOException {
		CaesarCipher cc = new CaesarCipher();
		String decryptionKey = "abcdefghijklmnopqrstuvwxyz";
		String decryptedMessage = "";
		// final String FILEPATH="";
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		List<Integer> countLetters = new LinkedList<>();
		for (int i = 0; i < decryptionKey.length(); i++)
			countLetters.add(0);

		countLetters = CountLetters(br, countLetters);

		int maxIndex = IndexOfMax(countLetters);
//		int posAlphs = (char) decryptionKey.indexOf(maxIndex);

		br = new BufferedReader(new FileReader(file));
		String encryptedMessage = br.readLine();
		while (encryptedMessage != null) {
			if (maxIndex < 4) {
				decryptedMessage = cc.encrypt(encryptedMessage, 4 - maxIndex) + "\n";
			} else
				decryptedMessage = cc.encrypt(encryptedMessage, 26 - (maxIndex - 4)) + "\n";
			encryptedMessage = br.readLine();
		}

		br.close();
		return decryptedMessage;
	}

	public int IndexOfMax(List<Integer> counts) {
		int maxIndex = 0;
		int maxValue = 0;

		for (Integer ite : counts) {
			if (ite > maxValue) {
				maxValue = ite;
				maxIndex = counts.indexOf(ite);
			}
		}

		return maxIndex;
	}

	public List<Integer> CountLetters(BufferedReader br, List<Integer> counts) throws IOException {
		String alphs = "abcdefghijklmnopqrstuvwxyz";
		String message;

		message = br.readLine().toLowerCase();
		while (message != null) {
			for (char ch : message.toCharArray()) {
				if (Character.isLetter(ch)) {
					int num = counts.get(alphs.indexOf(ch));
					counts.add(alphs.indexOf(ch), num + 1);
				}
			}
			message = br.readLine().toLowerCase();
		}
		return counts;
	}

	public List<Integer> CountLetters(String message, List<Integer> counts) throws IOException {
		String alphs = "abcdefghijklmnopqrstuvwxyz";
		message=message.toLowerCase();

		for (char ch : message.toCharArray()) {
			if (Character.isLetter(ch)) {
				int num = counts.get(alphs.indexOf(ch));
				counts.add(alphs.indexOf(ch), num + 1);
			}
		}
		return counts;
	}

	public List<Integer> CountWordLengths(BufferedReader br, List<Integer> counts) throws IOException {
		String alphs = "abcdefghijklmnopqrstuvwxyz";
		String message;

		message = br.readLine();
		while (message != null) {
			String[] words = message.split("\\s");
			for (String word : words) {
				char[] letters = word.toCharArray();
				for (int i = 0; i < letters.length; i++) {
					if ((i == 0 || i == letters.length - 1) && Character.isLetter(letters[i])) {
						counts.add(alphs.indexOf(letters[i]), alphs.indexOf(letters[i]) + 1);
					}
					counts.add(alphs.indexOf(letters[i]), alphs.indexOf(letters[i]) + 1);
				}
			}
		}
		return counts;
	}

}
