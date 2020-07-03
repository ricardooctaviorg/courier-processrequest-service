package com.a4sys.courier.service;

import com.a4sys.courier.beans.CourierProcessRequest;
import com.a4sys.courier.beans.CourierProcessResponse;

public interface ICreateCourierRequestInvoker {
	public CourierProcessResponse createCourierRequest(CourierProcessRequest courierProcessRequest);
	static final String CHARSET_UTF8 						= ";charset=utf-8";
	static final Long CODE_800 								= 800L;
	static final Long CODE_200								= 200L;
	static final Long CODE_300 								= 300L;
	static final String INVALID_TOKEN 						= "Token Invalido";
	static final String EXPIRED_TOKEN 						= "Token Expirado";
	
}
