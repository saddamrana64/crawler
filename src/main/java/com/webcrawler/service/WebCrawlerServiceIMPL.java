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

	public Node getLinks(String URL) {
		Node pointer = null;

		links = new HashSet<String>();
		root = new Node(URL);

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {
			pointer = queue.remove();
			List<Node> nodeList = getNestedNodes(pointer);
			queue.addAll(nodeList);
			pointer.setNodeList(nodeList);
		}
		return root;

	}

	private List<Node> getNestedNodes(Node URL) {

		List<Node> nodeList = new ArrayList<Node>(41);

		if (links.add(URL.getData())) {
			try {

				Document document = Jsoup.connect(URL.getData()).get();
				Elements linksOnPage = document.select("a[href]");

				for (Element page : linksOnPage) {

					nodeList.add(new Node(page.attr("abs:href")));
				}

			} catch (IOException e) {
				System.err.println("For '" + URL + "': " + e.getMessage());
			}
		}
		return nodeList;
	}
}
