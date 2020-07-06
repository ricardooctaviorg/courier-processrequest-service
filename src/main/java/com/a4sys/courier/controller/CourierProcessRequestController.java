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
import org.apache.log4j.Logger;

@RestController
@RequestMapping("/")
public class CourierProcessRequestController implements ICourierProcessRequestController {
	final static Logger logger = Logger.getLogger(CourierProcessRequestController.class);
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
		runMe("Log de prueba");
		CourierProcessResponse courierProcessResponse = iCreateCourierRequestInvoker.createCourierRequest(courierProcessRequest);
		return courierProcessResponse;
	}
	
	private void runMe(String parameter){

		if(logger.isDebugEnabled()){
			logger.debug("This is debug : " + parameter);
		}

		if(logger.isInfoEnabled()){
			logger.info("This is info : " + parameter);
		}

		logger.warn("This is warn : " + parameter);
		logger.error("This is error : " + parameter);
		logger.fatal("This is fatal : " + parameter);

	}
}
