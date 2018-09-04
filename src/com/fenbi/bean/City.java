package com.fenbi.bean;

public class City {
	
	private String Id;
	
	private String cname;
	
	private String provinceId;

	@Override
	public String toString() {
		return "City [Id=" + Id + ", cname=" + cname + ", provinceId=" + provinceId + "]";
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public City(String id, String cname, String provinceId) {
		Id = id;
		this.cname = cname;
		this.provinceId = provinceId;
	}

	public City() {
	}
	
	

}
