package com.bit.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {
	
	@RequestMapping(value= { "/main", "/" })
	public String index(
			@RequestParam(value="n", required=true, defaultValue="0") int n,
			Model model) {
		
		model.addAttribute("n",n);
		return "main/index";
	}
	
}
