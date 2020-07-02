package com.a4sys.courier.service;

import com.a4sys.courier.beans.CourierProcessRequest;
import com.a4sys.courier.beans.CourierProcessResponse;

public interface ICreateCourierRequestInvoker {
	public CourierProcessResponse createCourierRequest(CourierProcessRequest courierProcessRequest);
}
