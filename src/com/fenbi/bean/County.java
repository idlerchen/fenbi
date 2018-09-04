package com.fenbi.bean;

public class County {
	
	private String countyId;
	private String ctname;
	private String cityId;
	public String getCountyId() {
		return countyId;
	}
	public void setCountyId(String countyId) {
		this.countyId = countyId;
	}
	public String getCtname() {
		return ctname;
	}
	public void setCtname(String ctname) {
		this.ctname = ctname;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	@Override
	public String toString() {
		return "County [countyId=" + countyId + ", ctname=" + ctname + ", cityId=" + cityId + "]";
	}
	

}
