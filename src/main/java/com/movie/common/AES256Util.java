package com.movie.common;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

public class AES256Util {

	private static volatile AES256Util INSTANCE;

    final static String secretKey = "HFAO38YFD1L9NA4TUYQAO8RYA4T89YAK"; 
    static String IV = ""; //16bit

    public static AES256Util getInstance() {
        if (INSTANCE == null) {
            synchronized (AES256Util.class) {
                if (INSTANCE == null)
                    INSTANCE = new AES256Util();
            }
        }
        return INSTANCE;
    }

    private AES256Util() {
        IV = secretKey.substring(0, 16);
    }

    //암호화
    public static String encode(String str) throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        byte[] keyData = secretKey.getBytes();

        SecretKey secureKey = new SecretKeySpec(keyData, "AES");

        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, secureKey, new IvParameterSpec(IV.getBytes()));

        byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
        String enStr = new String(Base64.encodeBase64(encrypted));
        
        enStr = enStr.replaceAll("\\+", "-");
        enStr = enStr.replaceAll("/", "_");

        return enStr;
    }

    //복호화
    public static String decode(String str) throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        byte[] keyData = secretKey.getBytes();
        SecretKey secureKey = new SecretKeySpec(keyData, "AES");
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.DECRYPT_MODE, secureKey, new IvParameterSpec(IV.getBytes("UTF-8")));

        str = str.replaceAll("-", "\\+");
        str = str.replaceAll("_", "/");
        
        byte[] byteStr = Base64.decodeBase64(str.getBytes());
        String deStr = new String(c.doFinal(byteStr), "UTF-8"); 

        return deStr;
    }
}
