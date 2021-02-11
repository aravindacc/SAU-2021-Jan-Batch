package com.assignment.librarymngmt;

import java.util.ArrayList;

public class Student {
	private int id;
	private String name;
	private ArrayList<Book> cart;
	private ArrayList<Book> review;
	public Student(int id, String name) {
		super();
		this.id=id;
		this.name=name;
		this.cart=new ArrayList<Book>();
		this.review=new ArrayList<Book>();
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void takeInReview(Book bk) {
		this.review.add(bk);
	}
	public void forcheckout(Book bk) {
		this.cart.add(bk);
	}
	public void alreadyInReview() {
		if(review.size()>0) {
			System.out.println("Student "+this.name+" is currently reviewing following books:");
			for(Book bk:review) {
				bk.getBookDetails();
			}
		}
		else {
			System.out.println("Student "+this.name+" has not yet reviewed any book.");
		}
	}
	public void alreadyInCart() {
		if(cart.size()>0) {
			System.out.println("Student "+this.name+" is currently having following books in cart:");
			for(Book bk:cart) {
				bk.getBookDetails();
			}
		}
		else {
			System.out.println("Student "+this.name+" has not yet checkedout any book.");
		}
	}
	public boolean notAddedCart(Book book) {
		for(Book bk: cart) {
			if(bk.getISBN() == book.getISBN()) {
				return true;
			}
		}
		return false;
	}
	public boolean notAddedReview(Book book) {
		for(Book bk: review) {
			if(bk.getISBN() == book.getISBN()) {
				return true;
			}
		}
		return false;
	}
}
