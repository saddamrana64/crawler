package com.webcrawler.helper;

import java.util.LinkedList;
import java.util.List;

public class Node {
	
	private String data;
	private List<Node> nodeList = new LinkedList<Node>(); 
	
	public Node(String data, List<Node> nodeList){
		this.data = data;
		this.nodeList = nodeList;
	}
	
	public Node(String data){
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<Node> getNodeList() {
		return nodeList;
	}

	public void setNodeList(List<Node> nodeList) {
		this.nodeList = nodeList;
	}

	
	
	
	
}
