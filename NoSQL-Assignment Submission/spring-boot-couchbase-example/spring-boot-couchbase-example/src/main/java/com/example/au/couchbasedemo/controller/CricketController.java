package com.example.au.couchbasedemo.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.au.couchbasedemo.model.Blogs;
import com.example.au.couchbasedemo.model.Cricket;
import com.example.au.couchbasedemo.repository.CricketRepository;

@RestController
public class CricketController {
    
    @Autowired
    CricketRepository cricketRepository;
    
	/*
	 * @RequestMapping("/") public String index() { return
	 * "Welcome to the CRUD application!!"; }
	 */
    
    @PostMapping("/cricket")
    public Cricket addCricketer(@RequestBody Cricket newCricketer) {
        return cricketRepository.save(newCricketer);
    }
    @GetMapping("/cricket/{id}")
    public Optional<Cricket> getCricketer(@PathVariable String id) {
        if (cricketRepository.existsById(id)) {
            return cricketRepository.findById(id);
        } else
            return Optional.empty();
    }
    @DeleteMapping("/cricket/{id}")
    public void deleteCricketerById(@PathVariable String id) {
        cricketRepository.deleteById(id);
    }
    @GetMapping("/cricket/cricketerWithGreaterRuns/{runs}")
    public List<Cricket> getCricketWithGreaterRuns(@PathVariable int runs) {
        List<Cricket> cricketers=new ArrayList<>();
        cricketRepository.findAll().forEach(cricketer->{
            if(cricketer.getNoOfRuns()>runs)
            {
                cricketers.add(cricketer);
            }
        });
        return cricketers;
    }

}