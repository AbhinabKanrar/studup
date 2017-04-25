package com.studup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticRouter {

	@GetMapping("/login")
	public String login() {
		return "login";
	}

}
