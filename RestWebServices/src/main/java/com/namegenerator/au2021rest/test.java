package com.namegenerator.au2021rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
	
	@RequestMapping("/")
	public String home() {
		return "It's home page";
	}
}
