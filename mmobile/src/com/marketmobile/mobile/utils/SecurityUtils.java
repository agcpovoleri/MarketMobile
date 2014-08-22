package com.marketmobile.mobile.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe para prover metodos responsáveis por garantir a segurança 
 * 
 * @author augusto
 * @since 10/07/2012
 */
public class SecurityUtils {

	/**
	 * Retorna a string criptografada de acordo com o algoritmo de criptografia utilizado
	 * 
	 * @param str - String a ser criptografada
	 * @param algoritmoUtilizado -  MD5, SHA-1 ou SHA-256
	 * @return string
	 */
	public static String getStringCriptografada(String str, String algoritmoUtilizado){
		return getStringHexa(gerarHash(str, algoritmoUtilizado));
	}
	
	private static byte[] gerarHash(String frase, String algoritmo) {
		try {
			MessageDigest md = MessageDigest.getInstance(algoritmo);
			md.update(frase.getBytes());
			return md.digest();
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

	private static String getStringHexa(byte[] bytes) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
			int parteBaixa = bytes[i] & 0xf;
			if (parteAlta == 0) s.append('0');
			s.append(Integer.toHexString(parteAlta | parteBaixa));
		}
		return s.toString();
	}
	
}
