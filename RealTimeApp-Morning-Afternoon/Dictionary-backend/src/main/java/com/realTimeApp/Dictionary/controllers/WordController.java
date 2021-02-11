package com.realTimeApp.Dictionary.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.realTimeApp.Dictionary.Crud.Services.IWordService;
import com.realTimeApp.Dictionary.Entities.Word;

@RestController
@RequestMapping("word")
public class WordController {
	@Autowired(required=true)
	IWordService iWordService;
	
	@PostMapping("/save")
	public Word save(@RequestBody Word word) {
		word.setCreationTm(new Date(System.currentTimeMillis()));
		word.setLastModifiedTm(new Date(System.currentTimeMillis()));
		return iWordService.save(word);
	}
	
//	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	public String test() {
//		return "Success from wordController";
//	}
	
	@GetMapping("/test")
	public String text() {
		return "Success";
	}
	
	@GetMapping("/getAll")
//	@CrossOrigin(origins = "http://localhost:4200")
	public List<Word> getAll(){
		return iWordService.getAll();
	}
	
	@GetMapping("/delete/{id}")
	public boolean getAll(@PathVariable int id) {
		return iWordService.delete(id);
	}
	
	@PostMapping("/update")
	public boolean update(@RequestBody Word word) {
		return iWordService.update(word);
	}
	
    @GetMapping("/getSearch/{pattern}")
    public List<Word> getPattern(@PathVariable String pattern){
        return iWordService.searchPattern(pattern);
    }
}
