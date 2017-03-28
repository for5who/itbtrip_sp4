package com.itb.framework.common.util.crypto;

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

import org.apache.commons.codec.binary.Base64;

import lombok.extern.slf4j.Slf4j;

public class AES256Cipher {
	 
	 private static volatile AES256Cipher INSTANCE;
 
	 final static String secretKey   = "AHge@Ha^rK(hser8272E-8877BNOIU#9"; //32bit
	 static String IV                = ""; //16bit
 
	 public static AES256Cipher getInstance(){
	     if(INSTANCE==null){
	         synchronized(AES256Cipher.class){
	             if(INSTANCE==null)
	                 INSTANCE=new AES256Cipher();
	         }
	     }
	     return INSTANCE;
	 }
	 
	 private AES256Cipher(){
	     IV = secretKey.substring(0,16);  
	 }
 

	 public  String AES_Encode(String str) throws java.io.UnsupportedEncodingException,
	 													NoSuchAlgorithmException, 
	 													NoSuchPaddingException, 
	 													InvalidKeyException, 
	 													InvalidAlgorithmParameterException, 
	 													IllegalBlockSizeException, 
	 													BadPaddingException{
	     byte[] keyData = secretKey.getBytes();
	 
		 SecretKey secureKey = new SecretKeySpec(keyData, "AES");
		 
		 Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		 c.init(Cipher.ENCRYPT_MODE, secureKey, new IvParameterSpec(IV.getBytes()));
		 
		 byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
		 String enStr = new String(Base64.encodeBase64(encrypted));
		 
		 return enStr;
	 }
 
 
	 public String AES_Decode(String str) throws java.io.UnsupportedEncodingException,
	 											 NoSuchAlgorithmException, 
	 											 NoSuchPaddingException, 
	 											 InvalidKeyException, 
	 											 InvalidAlgorithmParameterException, 
	 											 IllegalBlockSizeException, 
		 										 BadPaddingException{
		  byte[] keyData = secretKey.getBytes();
		  SecretKey secureKey = new SecretKeySpec(keyData, "AES");
		  Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		  c.init(Cipher.DECRYPT_MODE, secureKey, new IvParameterSpec(IV.getBytes("UTF-8")));
		 
		  byte[] byteStr = Base64.decodeBase64(str.getBytes());
		 
		  return new String(c.doFinal(byteStr),"UTF-8");
	 }
	 
	
	 public static void main(String[] args) throws Exception {
		 
		 AES256Cipher a256 = AES256Cipher.getInstance();
		 
		 String str="jdbc:mysql://222.107.254.100:3306/test?characterSetResults=utf8&characterEncoding=utf8&autoReconnectForPools=true";//암호화 대상 문자열
		 
		 String encStr = a256.AES_Encode("@qwer123");
		 
		 System.out.println(encStr);

	 }
}