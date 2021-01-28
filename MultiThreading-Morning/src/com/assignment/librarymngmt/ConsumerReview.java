package com.assignment.librarymngmt;

public class ConsumerReview implements Runnable{
	private GeneralOperations queue;
	private Student student;
	private Book book;
	public ConsumerReview(GeneralOperations queue, Student student, Book book) {
		super();
		this.queue = queue;
		this.student = student;
		this.book = book;
	}
	
	@Override
	public void run(){
			try {
				queue.takereview(student, book);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}
