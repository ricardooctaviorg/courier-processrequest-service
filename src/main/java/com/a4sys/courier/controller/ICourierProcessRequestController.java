package com.a4sys.courier.controller;

import com.a4sys.courier.beans.CourierProcessRequest;
import com.a4sys.courier.beans.CourierProcessResponse;

public interface ICourierProcessRequestController {
	
	public CourierProcessResponse courierProcessRequest(CourierProcessRequest courierProcessRequest);

}
