package com.example.au.couchbasedemo.controller;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

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
import com.example.au.couchbasedemo.repository.BlogRepository;

@RestController
public class BlogController {
    
    @Autowired
    BlogRepository blogRepository;
    
	/*
	 * @RequestMapping("/") public String index() { return
	 * "Welcome to the CRUD application!!"; }
	 */
    
    @PostMapping("/blogs")
    public Blogs addBlogPost(@RequestBody Blogs newBlog) {
        return blogRepository.save(newBlog);
    }
    
    @GetMapping("/blogs/{id}")
    public Optional<Blogs> getBlog(@PathVariable String id) {
        if (blogRepository.existsById(id)) {
            return blogRepository.findById(id);
        } else
            return Optional.empty();
    }
    
    @GetMapping("/blogs/author/{author}")
    public Blogs getBlogByAuthorName(@PathVariable String author) {
        return blogRepository.findByAuthor(author);
    }
    
    @DeleteMapping("/blogs/topic/{topic}/author/{author}")
    public List<Blogs> deleteByAuthorAndTopic(@PathVariable String topic, @PathVariable String author) {
        return blogRepository.deleteBytopicAndAuthor(topic, author);
    }
    
    @DeleteMapping("/blogs/{id}")
    public void deleteById(@PathVariable String id) {
        blogRepository.deleteById(id);
    }
    @GetMapping("/blogs/tagged/{tags}")
    public List<Blogs> getBlogsWithTags(@PathVariable List<String> tags) {
        List<Blogs> blogsWithReqdTags = new ArrayList<>();
        List<Blogs> withTags= (List<Blogs>) blogRepository.findAll();
        for(Blogs blog:withTags) {
        	List<String> tagInEachBlog=blog.getTags();
        	for(String tag:tags) {
        		if(tagInEachBlog.contains(tag)) {
        			blogsWithReqdTags.add(blog);
        			break;
        		}
        	}
        }
        return blogsWithReqdTags;
    }
    
	/*
	 * @PutMapping("/blogs/{idToBeUpdated}") public String updateBlog(@PathVariable
	 * String idToBeUpdated, @RequestBody BlogsUpdateRequest blogsUpdateRequest) {
	 * 
	 * Optional<Blogs> mayBeBlog = blogRepository.findById(idToBeUpdated) .map(blogs
	 * –> blogRepository .save(Blogs .builder() .id(idToBeUpdated)
	 * .topic(blogsUpdateRequest.getTopic()) .tags(blogsUpdateRequest.getTags())
	 * .author(blogs.getAuthor()) .date(blogs.getDate()) .build()) ); if
	 * (mayBeBlog.isPresent()) { return "Blog Updated"; } else { return
	 * "Blog does not exist"; } }
	 */
}