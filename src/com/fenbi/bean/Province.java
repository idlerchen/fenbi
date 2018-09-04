package com.fenbi.bean;

public class Province {

	private String Id;
	
	private String pname;
	
	
	public Province() {
	}

	public Province(String id, String pname) {
		Id = id;
		this.pname = pname;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	@Override
	public String toString() {
		return "Province [Id=" + Id + ", pname=" + pname + "]";
	}
	
	
	
}
