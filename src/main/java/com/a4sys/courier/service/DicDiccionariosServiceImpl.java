package com.a4sys.courier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a4sys.courier.domain.cfg.DicDiccionarios;
import com.a4sys.courier.domain.cfg.TblRegistrosDiccionarios;
import com.a4sys.courier.repository.cfgDao.IDicDiccionarios;
import com.a4sys.courier.repository.cfgDao.ITblRegistrosDiccionarios;

@Service
@Transactional(readOnly = true)
public class DicDiccionariosServiceImpl implements IDicDiccionariosService {
	
	@Autowired
	private IDicDiccionarios iDicDiccionarios;
	@Autowired 
	private ITblRegistrosDiccionarios iTblRegistrosDiccionarios;
	
	public DicDiccionariosServiceImpl() {
	}

	@Override
	public List<DicDiccionarios> getAll() {
		return iDicDiccionarios.findAll();
	}

	@Override
	public DicDiccionarios getDicDiccionarioById(Long idDiccionario) {
		return iDicDiccionarios.findById(idDiccionario).orElse(null);
	}

	@Override
	public TblRegistrosDiccionarios getTblRegistrosDiccionariosById(Long idTblRegistrosDiccionarios) {
		
		return iTblRegistrosDiccionarios.findById(idTblRegistrosDiccionarios).orElse(null);
	
	}

}
