package CaesarCipher;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CaesarCipherTest {
	CaesarCipher encrypt;
	String test_1key;
	String test_2keys;
	
	@Before
	public void setUp() {
		encrypt=new CaesarCipher();
		test_1key="First Legion";
		test_2keys="First Legion";
	}

	@Test
	public void test() {
		
//		assertTrue("Test 1 key", encrypt.encrypt(test_1key, 17).equals("Wzijk Cvxzfe"));
		assertTrue("Test 2 keys", encrypt.encryptTwoKeys(test_2keys, 23, 17).equals("Czojq Ivdzle"));
	}

}
