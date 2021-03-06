package com.a4sys.courier.beans;

public class CourierProcessResponse {
	
	private Long 	folio;
	private Integer responseCode;
	private String 	responseDetail;

	public CourierProcessResponse() {
	}

	public CourierProcessResponse(Long folio, Integer responseCode, String responseDetail) {
		super();
		this.folio = folio;
		this.responseCode = responseCode;
		this.responseDetail = responseDetail;
	}

	public Long getFolio() {
		return folio;
	}

	public void setFolio(Long folio) {
		this.folio = folio;
	}

	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseDetail() {
		return responseDetail;
	}

	public void setResponseDetail(String responseDetail) {
		this.responseDetail = responseDetail;
	}
}
