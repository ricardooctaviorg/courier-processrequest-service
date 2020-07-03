package com.a4sys.courier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a4sys.courier.beans.CourierProcessRequest;
import com.a4sys.courier.beans.CourierProcessResponse;
import com.google.gson.Gson;

@Service
@Transactional(readOnly = false)
public class CourierProcessRequestService implements ICreateCourierRequestInvoker {
	
	@Autowired
	private com.a4sys.courier.repository.invokers.ICreateCourierRequestInvoker iCreateCourierRequestInvoker;
	
	@Override
	public CourierProcessResponse createCourierRequest(CourierProcessRequest courierProcessRequest) {
		CourierProcessResponse response;
		Gson gson = new Gson();
		
		Long validateToken = iCreateCourierRequestInvoker.validateToken(courierProcessRequest.getToken());
		
		String courierProcessRequestString = gson.toJson(courierProcessRequest);
		String createCourierRequest = iCreateCourierRequestInvoker.createCourierRequest(courierProcessRequestString);
		response = gson.fromJson(createCourierRequest, CourierProcessResponse.class);
		
		return response;
	}

}
