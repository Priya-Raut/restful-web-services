package com.restfultryout.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.restfultryout.bean.WelcomeMessage;

@RestController
public class WelcomeMessageController {
	
	@GetMapping("/welcome-message/{name}")
	public WelcomeMessage getWelcomeMessage(@PathVariable(name="name") String name) {
		return new WelcomeMessage("Welcome " + name + ", to restful web services!");
	}
}
