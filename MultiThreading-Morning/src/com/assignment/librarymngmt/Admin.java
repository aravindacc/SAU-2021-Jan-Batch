package com.assignment.librarymngmt;

public class Admin implements Runnable{
	private GeneralOperations queue;
	private String name;
	private int id;
	private String ISBN;
	private Boolean isInReview;
	private Boolean isInCart;
	private Boolean isInCheckout;
	
	public Admin(GeneralOperations queue, String name, int id, String iSBN, Boolean isInReview,Boolean isInCart, Boolean isInCheckout) {
		super();
		this.queue=queue;
		this.name=name;
		this.id=id;
		ISBN=iSBN;
		this.isInReview=isInReview;
		this.isInCart=isInCart;
		this.isInCheckout=isInCheckout;
	}
	
	@Override
	public void run() {
//		for(int i=0;i<id.length;i++) {
//			Book b = new Book(this.name[i], this.id[i], this.ISBN[i],this.isInReview[i], this.isInCart[i], this.isInCheckout[i]);
//			try {
//				queue.newBook(b);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		System.out.println("In admin");
		Book b = new Book(this.name, this.id, this.ISBN,this.isInReview, this.isInCart, this.isInCheckout);
		try {
			queue.newBook(b);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
