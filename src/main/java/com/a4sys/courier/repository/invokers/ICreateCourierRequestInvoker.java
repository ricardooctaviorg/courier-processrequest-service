package com.a4sys.courier.repository.invokers;

public interface ICreateCourierRequestInvoker {
	
	 public String createCourierRequest(String courierProcessRequest);
	 public Long validateToken(String token);
	 
	static final String PREFIX_CALLCENTER       							                			= "COURIER";
	static final String NEVER				       							                			= "never";
	static final String ONE					       							                			= "1";
	static final String REGEX_DOT       							                					= "[^.]*";
	static final String UTF_8       							                						= "UTF-8";
}
