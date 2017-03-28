package com.itb.framework.common.util.dbcrypto;

import org.apache.commons.dbcp.BasicDataSource;

import com.itb.framework.common.util.crypto.AES256Cipher;


public class BasicCryptoDataSource extends BasicDataSource{
	AES256Cipher a256 = AES256Cipher.getInstance();
    
	@Override
	public void setUrl(String url){
	
		try {
			super.setUrl(a256.AES_Decode(url));
			
		} catch (Exception e) {
		
			e.printStackTrace();
		} 
	}
	@Override
	public void setUsername(String username){
		
		try {
			super.setUsername(a256.AES_Decode(username));
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}
	@Override
	public void setPassword(String password){
	
		try {
			super.setPassword(a256.AES_Decode(password));
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}
}
