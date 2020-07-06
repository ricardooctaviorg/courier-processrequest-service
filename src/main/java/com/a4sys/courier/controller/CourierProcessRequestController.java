package com.a4sys.courier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.a4sys.courier.beans.CourierProcessRequest;
import com.a4sys.courier.beans.CourierProcessResponse;
import com.a4sys.courier.domain.cfg.DicDiccionarios;
import com.a4sys.courier.service.ICreateCourierRequestInvoker;
import com.a4sys.courier.service.IDicDiccionariosService;


@RestController
@RequestMapping("/")
public class CourierProcessRequestController implements ICourierProcessRequestController {
	
	@Autowired
	//inyecccion de dependencia
	private IDicDiccionariosService iDicDiccionariosService;
	@Autowired
	private ICreateCourierRequestInvoker iCreateCourierRequestInvoker;

	public CourierProcessRequestController() {
	}
	
	@PostMapping
	@RequestMapping(value = "/courierProcessRequest", method = RequestMethod.POST)
	public CourierProcessResponse courierProcessRequest(@RequestBody CourierProcessRequest courierProcessRequest){
		CourierProcessResponse courierProcessResponse = iCreateCourierRequestInvoker.createCourierRequest(courierProcessRequest);
		return courierProcessResponse;
	}
}
