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
	private com.a4sys.courier.repository.invokers.IValidateTokenInvoker iValidateTokenInvoker;
	@Autowired
	private com.a4sys.courier.repository.invokers.ICreateCourierRequestInvoker iCreateCourierRequestInvoker;

	
	@Override
	public CourierProcessResponse createCourierRequest(CourierProcessRequest courierProcessRequest) {
		CourierProcessResponse response=null;
		Gson gson = new Gson();
		
		Long validateToken = iValidateTokenInvoker.validateToken(courierProcessRequest.getToken());
		if(validateToken==100) {
			//response= buildResponse(null,100, "EJECUCION EXITOSA");
			String courierProcessRequestString = gson.toJson(courierProcessRequest);
			String createCourierRequest = iCreateCourierRequestInvoker.createCourierRequest(courierProcessRequestString);
			response = gson.fromJson(createCourierRequest, CourierProcessResponse.class);
		}else if(validateToken==200){
			response= buildResponse(null,CODE_200, INVALID_TOKEN);
		}else if(validateToken==300){
			response= buildResponse(null,CODE_300, EXPIRED_TOKEN);
		}else{
			response= buildResponse(null,CODE_200, INVALID_TOKEN);
		}
		return response;
	}//fin de createCourierRequest
	

	private CourierProcessResponse buildResponse(Long 	folio, Integer responseCode,String 	responseDetail) {
		CourierProcessResponse courierProcessResponse= new CourierProcessResponse(folio,responseCode,responseDetail);
		return courierProcessResponse;
	}

	

}
