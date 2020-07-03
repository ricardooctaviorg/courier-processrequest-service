package com.a4sys.courier.beans;

public class InfoToken {
	
	private String idExternal;
	private String expiration;
	
	public InfoToken() {
	}
	public InfoToken(String idExternal, String expiration) {
		super();
		this.idExternal = idExternal;
		this.expiration = expiration;
	}
	public String getIdExternal() {
		return idExternal;
	}
	public void setIdExternal(String idExternal) {
		this.idExternal = idExternal;
	}
	public String getExpiration() {
		return expiration;
	}
	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}
	
 
}