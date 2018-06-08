package quyen.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import CaesarBreaker.CaesarBreaker;
import CaesarCipher.CaesarCipher;

public class MainApp {

	public static void main(String[] args) throws IOException {
		CaesarBreaker cb = new CaesarBreaker();
		CaesarCipher cc = new CaesarCipher();
		String encryptedMessage = "kko oox oto.";
		File file1, file2, file3;
		
		file1=new File("data/Test1.txt");
		file2=new File("data/smallHamlet.txt");
		file3=new File("data/romeo.txt");
		BufferedReader br=new BufferedReader(new FileReader(file3));
		
		List<Integer> countLetters = new LinkedList<>();
		for (int i = 0; i < 30; i++)
			countLetters.add(0);
		
		//		System.out.println(cb.decrypt2Keys(file2));
		System.out.println(cb.CountWordLengths(br, countLetters));
//		System.out.println(cc.encrypt("aae een eje.", 10));

	}

}
