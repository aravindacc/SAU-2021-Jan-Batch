package com.assignment.librarymngmt;

public class ConsumerCheckout implements Runnable{
	private GeneralOperations queue;
	private Student student;
	private Book book;
	public ConsumerCheckout(GeneralOperations queue, Student student, Book book) {
		super();
		this.queue = queue;
		this.student = student;
		this.book = book;
	}
	
	@Override
	public void run(){
			try {
				queue.takecheckout(student, book);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}
