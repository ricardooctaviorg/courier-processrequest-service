package com.a4sys.courier.domain.dic;
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
@Table(name = "DICAMPANAS")
public class DicCampanas implements Serializable {

	private static final long serialVersionUID = -8392450208734038924L;
	
	@Id
    @Basic(optional = false)//no es opcional 
    @Column(name = "IDCAMPANA")
	@SequenceGenerator(name = "secIdCampana", sequenceName = "SECIDCAMPANA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="secIdCampana")
	private Long 	idCampana;
	
	@Column(name = "IDEXTERNO")
	private String 	idExterno;

	public Long getIdCampana() {
		return idCampana;
	}

	public void setIdCampana(Long idCampana) {
		this.idCampana = idCampana;
	}

	public String getIdExterno() {
		return idExterno;
	}

	public void setIdExterno(String idExterno) {
		this.idExterno = idExterno;
	}
	
		
	
	
}
