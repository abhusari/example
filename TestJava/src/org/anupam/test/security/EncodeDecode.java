package org.anupam.test.security;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class EncodeDecode {
	
	private static final String ALGORITHM_AES = "AES";

	private static Key getKeySpec(String keyReffId) {
		//String token = System.getProperty("cbeyond.q2o.security.key");
		//cbeyond.q2o.security.key=I934PMjC23qbm4jl
		String token = "I934PMjC23qbm4jl";
		return new SecretKeySpec(token.getBytes(), ALGORITHM_AES);

	}
	
	/**
	 * @param args
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws InvalidKeyException 
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
		Base64 base64 = new Base64();
		Cipher cipher = Cipher.getInstance(ALGORITHM_AES);
		cipher.init(Cipher.ENCRYPT_MODE, getKeySpec("keyReffId"));
		// encrypt using the cypher
		byte[] raw = cipher.doFinal("Satya".getBytes());
		System.out.println(new String(raw));
		// converts to base64 for easier display.   
		//String encodedValue = Base64.encode(raw);
		cipher = Cipher.getInstance(ALGORITHM_AES);
		cipher.init(Cipher.DECRYPT_MODE, getKeySpec("keyReffId"));
		String encodedPass =Base64.encodeBase64String(raw);
		byte[] decodedValue = Base64.decodeBase64(encodedPass);
		raw = cipher.doFinal(decodedValue);	
		//String decodedPass = new String(Base64.decodeBase64(encodedPass));
		System.out.println("Final Pass word :--  "+new String(raw));
	}

}
