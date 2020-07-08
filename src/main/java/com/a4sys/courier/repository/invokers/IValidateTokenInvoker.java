package com.a4sys.courier.repository.invokers;

public interface IValidateTokenInvoker {
	
	public Long validateToken(String token);
	String decryptToken(String token) throws Exception ;
	byte[] getKeySecret();
	String decrypt(String encryptedText, byte[] rawkey) throws Exception;
	static final String PREFIX_CALLCENTER       							                			= "COURIER";
	static final String NEVER				       							                			= "never";
	static final String ONE					       							                			= "1";
	static final String REGEX_DOT       							                					= "[^.]*";
	static final String UTF_8       							                						= "UTF-8";

}
