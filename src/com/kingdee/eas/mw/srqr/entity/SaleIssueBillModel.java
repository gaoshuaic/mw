package com.kingdee.eas.mw.srqr.entity;

import java.sql.Timestamp;

public class SaleIssueBillModel {
	private String number ;
	private Timestamp time;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
}
