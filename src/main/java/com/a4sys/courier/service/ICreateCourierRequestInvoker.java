package com.a4sys.courier.service;

import com.a4sys.courier.beans.CourierProcessRequest;
import com.a4sys.courier.beans.CourierProcessResponse;

public interface ICreateCourierRequestInvoker {
	public CourierProcessResponse createCourierRequest(CourierProcessRequest courierProcessRequest);
	
	static final Integer CODE_800 							= 800;
	static final Integer CODE_200							= 200;
	static final Integer CODE_300 							= 300;
	static final String INVALID_TOKEN 						= "Invalid Token";
	static final String EXPIRED_TOKEN 						= "Expired token";
	
}
