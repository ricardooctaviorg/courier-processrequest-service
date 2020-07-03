package com.a4sys.courier.beans;

public class CourierProcessRequest {

	private String token;
	private String idRequest;
	private String idCampaign;
	private CustomerBasics customerBasics;
	private CustomerLocation customerLocation;
	private ProductDetail productDetail;

	public String getIdRequest() {
		return idRequest;
	}

	public void setIdRequest(String idRequest) {
		this.idRequest = idRequest;
	}

	public String getIdCampaign() {
		return idCampaign;
	}

	public void setIdCampaign(String idCampaign) {
		this.idCampaign = idCampaign;
	}

	public CourierProcessRequest() {
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public CustomerBasics getCustomerBasics() {
		return customerBasics;
	}

	public void setCustomerBasics(CustomerBasics customerBasics) {
		this.customerBasics = customerBasics;
	}

	public CustomerLocation getCustomerLocation() {
		return customerLocation;
	}

	public void setCustomerLocation(CustomerLocation customerLocation) {
		this.customerLocation = customerLocation;
	}

	public ProductDetail getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}

}
