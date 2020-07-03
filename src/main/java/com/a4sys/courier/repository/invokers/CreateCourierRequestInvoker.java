package com.a4sys.courier.repository.invokers;

import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.StoredProcedureQuery;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a4sys.courier.domain.cfg.TblRegistrosDiccionarios;
import com.a4sys.courier.service.IDicDiccionariosService;
import com.google.gson.Gson;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@Repository
public class CreateCourierRequestInvoker implements ICreateCourierRequestInvoker {
	
	private static final String SCHEMA_NAME 						= "";
	private static final String PACKAGE_NAME 						= "IMPORTENGINE";
	private static final String METHOD_OR_PROCEDURE_NAME 			= "CREATECOURIERREQUEST";
	
	private static final String INPUT_PROCEDURE_PARAMETER_NAME		= "IN_REQUESTCOURIER";
	private static final String OUTPUT_PROCEDURE_PARAMETER_NAME 	= "OUT_RESPOSECOURIER";
	
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;
	@Autowired
	private IDicDiccionariosService iDicDiccionariosService;
	
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

	public Long validateToken(String token){
		
    	try {
			String decryptToken = decryptToken(token);
			System.out.println("decryptToken:"+decryptToken);
			String tokenCurrent = new String(decryptToken.getBytes(),UTF_8);
			
			byte[] decodeBase64 = Base64.decodeBase64(tokenCurrent.getBytes());
			String decodedString = new String(decodeBase64);
			System.out.println("decodedString:"+decodedString);
			
			String[] split = decodedString.split(Pattern.quote("."));
			String prefix = new String(Base64.decodeBase64(new String(split[0].getBytes(),UTF_8).getBytes()));
			String info = new String(Base64.decodeBase64(new String(split[1].getBytes(),UTF_8).getBytes()));
			com.a4sys.courier.beans.InfoToken infoToken = new Gson().fromJson(info, com.a4sys.courier.beans.InfoToken.class);
			System.out.println("prefix:"+prefix+", info:"+info);
			/*
			String existCampaign= getExistCampaign(infoToken.getIdExternal());
			System.out.println("prefix:"+prefix+", info:"+info+",existCampaign:"+existCampaign);
			*/
	/*
			//System.out.println("info token date: "+infoToken.getCurrentDate()+", strDate:"+strDate);
			if(infoToken.getExpiration().equals(NEVER)) {
				if( PREFIX_CALLCENTER.equals(prefix)&&existCampaign.equals(ONE)) {
					return new Long(100);
				}
			}else {
				return new Long(300);//tokeExpirado
			}
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return new Long(200);//token invalido
	}
	
	private String decryptToken(String token) throws Exception {
		return decrypt(token, getKeySecret());
	}//fin de decryptToken
	
    private byte[] getKeySecret(){
    	String response = "";
    	/*
        ALQueryResult resultQuery = new ALQueryResult();
        try {
        	resultQuery = sqlQueryExecutor.executeQueryUsingQueryString(QuerysDB.COURIER_VISITMANAGEMENT_GET_KEYTOKEN);
        	response =  (String) resultQuery.get(0, HEADER_KEYTOKEN).toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	return response.getBytes();
    	*/
    	Long idTblRegistrosDiccionarios=8L;
    	TblRegistrosDiccionarios tblRegistrosDiccionarios= iDicDiccionariosService.getTblRegistrosDiccionariosById(idTblRegistrosDiccionarios);
    	//tblRegistrosDiccionarios.getValor().getBytes();
    	String responsetblRegistrosDiccionarios= tblRegistrosDiccionarios.getValor().toString();
    	System.out.println("tblRegistros valor: "+responsetblRegistrosDiccionarios);
    	return responsetblRegistrosDiccionarios.getBytes();
    }//fin de getKeySecret	
    
	private String decrypt(String encryptedText, byte[] rawkey) throws Exception {
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(rawkey, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] decrypted = cipher.doFinal((new BASE64Decoder()).decodeBuffer(encryptedText));
            return (new BASE64Encoder()).encode(decrypted);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw e;
        }
    }//fin de decrypt

}
