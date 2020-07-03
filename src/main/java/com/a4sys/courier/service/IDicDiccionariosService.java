package com.a4sys.courier.service;

import java.util.List;

import com.a4sys.courier.domain.cfg.DicDiccionarios;
import com.a4sys.courier.domain.cfg.TblRegistrosDiccionarios;
public interface IDicDiccionariosService {
	
	public List<DicDiccionarios> getAll();
	public DicDiccionarios getDicDiccionarioById(Long idDiccionario);
	public TblRegistrosDiccionarios getTblRegistrosDiccionariosById(Long idTblRegistrosDiccionarios);
}
