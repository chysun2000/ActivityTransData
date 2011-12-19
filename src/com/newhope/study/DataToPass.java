package com.newhope.study;

import java.io.Serializable;

public class DataToPass implements Serializable {
	private String pair = "";
	private String value = "";
	
	public DataToPass(String p, String v) {
		super();
		this.pair = p;
		this.value = v;
	}
	
	public String getPair() {
		return this.pair;
	}
	
	public String getValue() {
		return this.value;
	}
}
