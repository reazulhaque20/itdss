package com.web.bl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String root(Model model) {
		System.out.println("Root Page Requested");
		return "index";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(Model model) {
		System.out.println("User Page Requested");
		return "user";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		System.out.println("Index Page Requested");
		return "index";
	}
}
