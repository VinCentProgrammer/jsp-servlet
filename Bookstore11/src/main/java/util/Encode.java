package util;

import java.security.MessageDigest;

import org.apache.tomcat.util.codec.binary.Base64;

public class Encode {
	public static String encodingToSHA1(String toEncrypt) {
		String result = null;
		String salt = "jansndfalskdfa,sninvioawnfasdf1238AJNSjansdflNSFD";
		toEncrypt = toEncrypt + salt;
		try {
			byte[] dataBytes = toEncrypt.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA1");
			result = Base64.encodeBase64String(md.digest(dataBytes));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
