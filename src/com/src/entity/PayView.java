package com.src.entity;

public class PayView {
	public String id;
	
	public String date;
	
	public String info;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	public PayView(String id, String date, String info) {
		this.id = id;
		this.date = date;
		this.info = info;
	}

}
