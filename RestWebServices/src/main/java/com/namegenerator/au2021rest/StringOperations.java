package com.namegenerator.au2021rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/string")
public class StringOperations {
	@GetMapping("/generate/{string1}/{string2}")
	public String generate(@PathVariable("string1") String string1,@PathVariable("string2") String string2) {
		return string1+" "+string2;
	}
	
	@GetMapping("split/{firstName}/{lastName}")
	public String split(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
		return firstName.split(lastName)[0];
	}
	
	@GetMapping("charAt/{string1}/{num}")
	public String getCharacterByIndex(@PathVariable("string1") String text, @PathVariable("num") int index) {
	    return "Character at "+index+" is : "+text.charAt(index);
	}
	
	@GetMapping("upper/{string}")
	public String toUpper(@PathVariable String string) {
	    return string+" in uppercase is : "+string.toUpperCase();
	}
	
	@GetMapping("lower/{string}")
	public String toLower(@PathVariable String string) {
	    return string+" in lowercase is : "+string.toLowerCase();
	}
	
	@GetMapping("indexOf/{string}/{char1}")
	public Integer getIndex(@PathVariable String string, @PathVariable String char1) {
		return string.indexOf(char1);
	}
}

