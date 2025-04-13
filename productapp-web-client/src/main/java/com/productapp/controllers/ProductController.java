package com.productapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product-app/v1")
public class ProductController {

	@GetMapping("/home")
	public String home() {
		return "home"; // returns the view page name
	}
}
	


