package com.a4sys.courier.beans;

public class ProductDetail {
	
	private Long 	idProduct;
	private Integer	priority; 
	private Integer	unitys;
	
	public ProductDetail() {
		super();
	}
	public Long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Integer getUnitys() {
		return unitys;
	}
	public void setUnitys(Integer unitys) {
		this.unitys = unitys;
	}
}
