package com.a4sys.courier.repository.invokers;

import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a4sys.courier.domain.cfg.TblRegistrosDiccionarios;
import com.a4sys.courier.service.IDicCampanasService;
import com.a4sys.courier.service.IDicDiccionariosService;
import com.google.gson.Gson;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@Repository
public class ValidateTokenInvoker implements IValidateTokenInvoker {
	@Autowired
	private IDicCampanasService iDicCampanasService;
	@Autowired
	private IDicDiccionariosService iDicDiccionariosService;

	@Override
	public Long validateToken(String token) {
		try {
			String decryptToken = decryptToken(token);
			// System.out.println("decryptToken:"+decryptToken);
			String tokenCurrent = new String(decryptToken.getBytes(), UTF_8);

			byte[] decodeBase64 = Base64.decodeBase64(tokenCurrent.getBytes());
			String decodedString = new String(decodeBase64);
			// System.out.println("decodedString:"+decodedString);

			String[] split = decodedString.split(Pattern.quote("."));
			String prefix = new String(Base64.decodeBase64(new String(split[0].getBytes(), UTF_8).getBytes()));
			String info = new String(Base64.decodeBase64(new String(split[1].getBytes(), UTF_8).getBytes()));
			com.a4sys.courier.beans.InfoToken infoToken = new Gson().fromJson(info,
					com.a4sys.courier.beans.InfoToken.class);
			System.out.println("prefix:" + prefix + ", info:" + info);

			int countgetIdExternalById = iDicCampanasService.getIdExternalById(infoToken.getIdExternal());
			System.out.println("info id external: " + countgetIdExternalById);

			if (infoToken.getExpiration().equals(NEVER) && countgetIdExternalById == 1) {
				if (PREFIX_CALLCENTER.equals(prefix)) {
					return new Long(100);// token exitoso
				}
			} else {
				return new Long(300);// tokeExpirado
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new Long(200);// Error interno
		}
		return new Long(200);// token invalido
	}

	@Override
	public String decryptToken(String token) throws Exception {
		return decrypt(token, getKeySecret());
	}

	@Override
	public byte[] getKeySecret() {
		String response = "";
		Long idTblRegistrosDiccionarios = 8L;
		TblRegistrosDiccionarios tblRegistrosDiccionarios = iDicDiccionariosService
				.getTblRegistrosDiccionariosById(idTblRegistrosDiccionarios);

		String responsetblRegistrosDiccionarios = tblRegistrosDiccionarios.getValor().toString();
		System.out.println("tblRegistros valor: " + responsetblRegistrosDiccionarios);
		return responsetblRegistrosDiccionarios.getBytes();
	}

	@Override
	public String decrypt(String encryptedText, byte[] rawkey) throws Exception {
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
	}

}
