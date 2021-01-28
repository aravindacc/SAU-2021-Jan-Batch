package com.assignment.librarymngmt;

import java.util.ArrayList;

//import java.util.ArrayList;

public class ConsumerCart implements Runnable{
//	private ArrayList<Book> bookList;
	private GeneralOperations queue;
	private Student student;
	private ArrayList<Book> booklt;

	public ConsumerCart(GeneralOperations queue, Student student, ArrayList<Book> booklt) {
		super();
		this.queue = queue;
		this.student = student;
		this.booklt = booklt;
	}
	
	@Override
	public void run() {
			try {
				for(Book book : booklt) {
					queue.takeToCart(student, book);	
				}
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}

