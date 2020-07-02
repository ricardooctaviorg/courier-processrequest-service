package com.a4sys.courier.repository.invokers;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

@Repository
public class CreateCourierRequestInvoker implements ICreateCourierRequestInvoker {
	
	private static final String SCHEMA_NAME 						= "";
	private static final String PACKAGE_NAME 						= "IMPORTENGINE";
	private static final String METHOD_OR_PROCEDURE_NAME 			= "CREATECOURIERREQUEST";
	
	private static final String INPUT_PROCEDURE_PARAMETER_NAME		= "IN_REQUESTCOURIER";
	private static final String OUTPUT_PROCEDURE_PARAMETER_NAME 	= "OUT_RESPOSECOURIER";
	
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;
	
	public String createCourierRequest(String courierProcessRequest) {
		final String  response;
		StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery(PACKAGE_NAME + "." + METHOD_OR_PROCEDURE_NAME);
		storedProcedureQuery.registerStoredProcedureParameter(INPUT_PROCEDURE_PARAMETER_NAME, String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(OUTPUT_PROCEDURE_PARAMETER_NAME, String.class, ParameterMode.OUT);
        storedProcedureQuery.setParameter(INPUT_PROCEDURE_PARAMETER_NAME, courierProcessRequest);
        storedProcedureQuery.execute();
        response = (String) storedProcedureQuery.getOutputParameterValue(OUTPUT_PROCEDURE_PARAMETER_NAME);
		return response;
	}

}
