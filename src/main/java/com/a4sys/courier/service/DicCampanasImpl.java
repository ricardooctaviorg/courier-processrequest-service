package com.a4sys.courier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a4sys.courier.domain.dic.DicCampanas;
import com.a4sys.courier.repository.dicDao.IDicCampanas;

@Service
@Transactional(readOnly = true)
public class DicCampanasImpl implements IDicCampanasService{
	@Autowired
	private IDicCampanas iDicCampanas;
	
	@Override
	public int getIdExternalById(String idCampana) {
		
		return iDicCampanas.ExistCampaign(idCampana);
	}

}
