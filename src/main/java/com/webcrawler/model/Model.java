package com.webcrawler.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Model implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty
	private String URL;

	public Model(String uRL) {
		super();
		URL = uRL;
	}

	public Model() {
		super();
	}



	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}
	
	

}
