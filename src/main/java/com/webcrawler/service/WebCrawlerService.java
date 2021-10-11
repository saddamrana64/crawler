package com.webcrawler.service;

import com.webcrawler.helper.Node;

public interface WebCrawlerService {
	
	public Node getLinks(String URL, int innerItems, int totalProcessedItems);

}
