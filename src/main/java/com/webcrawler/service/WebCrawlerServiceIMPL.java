package com.webcrawler.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.webcrawler.helper.Node;

@Service
public class WebCrawlerServiceIMPL implements WebCrawlerService {

	private Set<String> links;
	private Node root;
	private int innerItems;
	private int totalProcessedItems;
	private String domain;

	public Node getLinks(String URL, int innerItems, int totalProcessedItems) {
		domain = URL.substring(URL.indexOf('.'));
		domain = domain.substring(1, domain.indexOf('/'));
		Node pointer = null;
		this.innerItems = innerItems > 0 ? innerItems: Integer.MAX_VALUE;
		this.totalProcessedItems = totalProcessedItems > 0 ? totalProcessedItems: Integer.MAX_VALUE;
		links = new HashSet<String>();
		root = new Node(URL);

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {
			pointer = queue.remove();
			List<Node> nodeList = getNestedNodes(pointer);
			queue.addAll(nodeList);
			pointer.setNodeList(nodeList);
			if(links.size() >= this.totalProcessedItems) return root;
		}
		return root;

	}

	private List<Node> getNestedNodes(Node URL) {

		List<Node> nodeList = new ArrayList<Node>();

		if (links.add(URL.getData())) {
			try {

				Document document = Jsoup.connect(URL.getData()).get();
				Set<String> linkSet = new HashSet<String>(document.select("a[href]").eachAttr("abs:href"));
				for (String page : linkSet) {
					if(nodeList.size() > this.innerItems) return nodeList;
					if(!links.contains(page) && page.contains(domain))
					nodeList.add(new Node(page));
				}

			} catch (IOException e) {
				System.err.println("For '" + URL.getData() + "': " + e.getMessage());
			}
		}
		return nodeList;
	}
}
