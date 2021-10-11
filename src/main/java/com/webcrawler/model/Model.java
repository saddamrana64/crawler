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
	
	@JsonProperty
	private int innerItems;
	
	@JsonProperty
	private int totalProcessedItems;

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

	public int getInnerItems() {
		return innerItems;
	}

	public void setInnerItems(int innerItems) {
		this.innerItems = innerItems;
	}

	public int getTotalProcessedItems() {
		return totalProcessedItems;
	}

	public void setTotalProcessedItems(int totalProcessedItems) {
		this.totalProcessedItems = totalProcessedItems;
	}
	
	
	
	

}
