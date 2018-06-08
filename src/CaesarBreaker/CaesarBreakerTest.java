package CaesarBreaker;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import CaesarCipher.CaesarCipher;

public class CaesarBreakerTest {

	CaesarBreaker cb = new CaesarBreaker();
	CaesarCipher cc = new CaesarCipher();
	String encryptedMessage = "kko oox oto.";
//	final String FILEPATH = "data/smallHamlet.txt";
	File file1, file2;
//	BufferedReader br;

	@Before
	public void setUp() throws FileNotFoundException {
//		br = new BufferedReader(new FileReader(FILEPATH));
		file1=new File("data/Test1.txt");
		file2=new File("data/smallHamlet.txt");
		
	}
	
	@Test
	public void test() throws IOException {
		assertTrue("decrypt 1 key 1 message", cb.decrypt(file1).equals("aae een eje.\n"));
//		assertTrue("Test decrypt 2 key 1 file",cb.decrypt2Keys(file).equals(anObject));
		System.out.println(cb.decrypt2Keys(file2));
	}
	

}
