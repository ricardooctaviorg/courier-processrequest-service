package com.a4sys.courier.domain.cfg;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TBLREGISTROSDICCIONARIOS")
public class TblRegistrosDiccionarios implements Serializable {

	private static final long serialVersionUID = 5437927760674611504L;
	
	@Id
    @Basic(optional = false)
    @Column(name = "IDREGISTRODICCIONARIO")
	@SequenceGenerator(name = "SqRegistroDiccionario", sequenceName = "SEQREGISTRODICCIONARIO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SqRegistroDiccionario")
	private Long 			idRegistroDiccionario;
	@ManyToOne
    @JoinColumn(name = "IDDICCIONARIO")
	private DicDiccionarios idDiccionario;
	@Column(name = "VALOR")
	private String 			valor;
	@Column(name = "ACTIVO")
	private Character		activo;
	
	public TblRegistrosDiccionarios() {
	}

	public Long getIdRegistroDiccionario() {
		return idRegistroDiccionario;
	}

	public void setIdRegistroDiccionario(Long idRegistroDiccionario) {
		this.idRegistroDiccionario = idRegistroDiccionario;
	}

	public DicDiccionarios getIdDiccionario() {
		return idDiccionario;
	}

	public void setIdDiccionario(DicDiccionarios idDiccionario) {
		this.idDiccionario = idDiccionario;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Character getActivo() {
		return activo;
	}

	public void setActivo(Character activo) {
		this.activo = activo;
	}
}
