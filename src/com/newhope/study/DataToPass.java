package com.newhope.study;

import java.io.Serializable;

public class DataToPass implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3887047275111883623L;
	
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
