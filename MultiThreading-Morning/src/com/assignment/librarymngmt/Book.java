package com.assignment.librarymngmt;

public class Book {
	private String name;
	private int id;
	private String ISBN;
	private Boolean isInReview;
	private Boolean isInCart;
	private volatile Boolean ischeckOut;
	private long timer;
	int limit=50000;

	public Book(String name, int id, String iSBN, Boolean isInReview, Boolean isInCart, Boolean ischeckOut) {
		super();
		this.name = name;
		this.id = id;
		ISBN = iSBN;
		this.isInReview = isInReview;
		this.isInCart = isInCart;
		this.ischeckOut = ischeckOut;
		this.timer=0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public Boolean getIsInReview() {
		return isInReview;
	}
	public void setIsInReview(Boolean isInReview) {
		this.isInReview = isInReview;
	}
	public Boolean getIsInCart() {
		return isInCart;
	}
	public void setIsInCart(Boolean isInCart) {
		this.isInCart = isInCart;
	}
	public Boolean getIscheckOut() {
		return ischeckOut;
	}
	public void setIscheckOut(Boolean ischeckOut) {
		this.ischeckOut = ischeckOut;
	}
	public void getBookDetails() {
		
		System.out.println("=======================");
		System.out.println("Book Id: "+this.getId());
		System.out.println("Book Name: "+this.getName());
		System.out.println("Book ISBN: "+this.getISBN());
	}
	public void startTimer() {
		 timer = System.currentTimeMillis();
	}

	public void resetTimer() {
		 timer = 0;
	}

	public Boolean checkTimerEnds(long currentTimer) {
		 if((timer + limit)<currentTimer)
			 return true;
		 else return false;

}




}
