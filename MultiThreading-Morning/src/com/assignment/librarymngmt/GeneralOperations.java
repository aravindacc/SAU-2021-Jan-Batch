package com.assignment.librarymngmt;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GeneralOperations {
	private Lock lock = new ReentrantLock();
	private Condition producerCondition=lock.newCondition();
	private Condition consumerCondition=lock.newCondition();
	private ArrayList<Book> listOfBooks=new ArrayList<Book>();
	int count=0;
	
	public void newBook(Book book) throws InterruptedException{
		lock.lock();
		System.out.println("In newBook");
		try {
			listOfBooks.add(book);
			count++;
			consumerCondition.signalAll();
		} catch (Exception e) {
		}finally {
			lock.unlock();
		}
	}
	
	public void takeToCart(Student student, Book book) throws InterruptedException{
		lock.lock();
		try {
			inTime(student);
			if(!student.notAddedCart(book)) {
				for(int i = 0 ; i < listOfBooks.size() ; i++ ) {
					if(listOfBooks.get(i).getId() == book.getId() && listOfBooks.get(i).getISBN() == book.getISBN() && !listOfBooks.get(i).getIsInReview() && !listOfBooks.get(i).getIsInCart()) {
						listOfBooks.get(i).setIsInCart(true);
						listOfBooks.get(i).setIsInReview(true);
						System.out.println("Book added to cart having Id: "+listOfBooks.get(i).getId()+" by student with Id: "+student.getId());
						break;
					}
				}
				producerCondition.signalAll();
			}
			else {
				System.out.println("Book already in cart");
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		finally {
			lock.unlock();
		}
	}
	
	public void takecheckout(Student student, Book book) throws InterruptedException{
		lock.lock();
		try {
			inTime(student);
			if(!student.notAddedCart(book)) {
				for(int i = 0 ; i < listOfBooks.size() ; i++ ) {
					if(listOfBooks.get(i).getId()==(book.getId()) && listOfBooks.get(i).getISBN() == book.getISBN()) {
						listOfBooks.get(i).setIsInReview(true);
						student.forcheckout(listOfBooks.get(i));
						System.out.println("Book checkedout having Id: "+listOfBooks.get(i).getId()+" by student with Id: "+student.getId());
						listOfBooks.remove(i);
						break;
					}
				}
				producerCondition.signalAll();
			}
		} finally {
			
		}
	}
	
	public void takereview(Student student, Book book) throws InterruptedException{
		lock.lock();
		if(book == null)
			System.out.println("Book has alredy purchased");
		if(!student.notAddedReview(book)) {
				for(int i = 0 ; i < listOfBooks.size() ; i++ ) {
					if(listOfBooks.get(i).getId() == book.getId() && listOfBooks.get(i).getISBN() == book.getISBN() && !listOfBooks.get(i).getIsInReview() && !listOfBooks.get(i).getIsInCart()) {
						listOfBooks.get(i).setIsInReview(true);
						student.takeInReview(listOfBooks.get(i));
						System.out.println("Book is being reviewed having Id: "+listOfBooks.get(i).getId()+" by student with Id: "+student.getId());
						break;
					}
				}
				producerCondition.signalAll();
			}
		lock.unlock();
	}
	
	public void inTime(Student student) {
		for(Book book:listOfBooks) {
			if (book.checkTimerEnds(System.currentTimeMillis())) {
				book.setIsInCart(false);
				book.setIsInReview(false);
				book.resetTimer();
			}
		}
	}
}
