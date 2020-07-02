package com.a4sys.courier.domain.cfg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DICDICCIONARIOS")
public class DicDiccionarios implements Serializable {

	private static final long serialVersionUID = -8392450208734038924L;
	
	@Id
    @Basic(optional = false)
    @Column(name = "IDDICCIONARIO")
	@SequenceGenerator(name = "sqIdDiccionario", sequenceName = "SEQIDDICCIONARIO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sqIdDiccionario")
	private Long 	idDiccionario;
	@Column(name = "DICCIONARIO")
	private String 	diccionario;
	@Column(name = "DESCRIPCION")
	private String 	descripcion;
	
    @OneToMany(mappedBy = "idDiccionario")
    private List<TblRegistrosDiccionarios> tblRegistrosDiccionarios = new ArrayList<>();

	public DicDiccionarios() {
	}

	public Long getIdDiccionario() {
		return idDiccionario;
	}

	public void setIdDiccionario(Long idDiccionario) {
		this.idDiccionario = idDiccionario;
	}

	public String getDiccionario() {
		return diccionario;
	}

	public void setDiccionario(String diccionario) {
		this.diccionario = diccionario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
