package com.webcrawler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webcrawler.helper.Node;
import com.webcrawler.model.Model;
import com.webcrawler.service.WebCrawlerService;

@RestController
public class WebCrawlerController {

	@Autowired
	WebCrawlerService service;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Node get(@RequestBody Model model) {
		return service.getLinks(model.getURL());
	}

}
