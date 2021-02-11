package com.assignment.librarymngmt;

import java.util.ArrayList;

public class LibraryMngmtAppMain {
	private static ArrayList<Student> studentRecord =new ArrayList<Student>();
	private static ArrayList<Book> bookCollection = new ArrayList<Book>();
	private static GeneralOperations queue;
	public static void main(String[] args) {
		queue=new GeneralOperations();
		initialStudents();
		initialbookCollection();
		
		int bookToReview = 8; 
		Thread transcation1 = new Thread(new ConsumerReview(queue,studentRecord.get(2), validatebookCollectionReview(bookToReview)));
		transcation1.run();
		
		int[] booksToCart = new int[] {1};
		Thread transcation3 = new Thread(new ConsumerCart(queue,studentRecord.get(4),validatebookCollectionCart(booksToCart)));
		transcation3.run();
		
		int[] booksToCart1 = new int[] {3,4,6};
		Thread transcation4 = new Thread(new ConsumerCart(queue,studentRecord.get(1),validatebookCollectionCart(booksToCart1)));
		transcation4.run();
		
		addNewBooks();
		
		int bookToReview1 = 10; 
		Thread transcation2 = new Thread(new ConsumerReview(queue,studentRecord.get(6), validatebookCollectionReview(bookToReview1)));
		transcation2.run();
		
		int[] booksToCart11 = new int[] {9,10};
		Thread transcation41 = new Thread(new ConsumerCart(queue,studentRecord.get(1),validatebookCollectionCart(booksToCart11)));
		transcation41.run();
		
	} 
	
		public static void initialStudents() {
			int[] id={ 10001 , 10002 , 10003 , 10004 , 10005 , 10006 , 10007 , 10008 , 10009 , 100010 };
			String[] name={"Ant","Bhavin","Chetan","Dev","Ellora","Fun","Giant","Horse","Isabella","Jackal"};
			for(int i=0;i<name.length;i++) {
				Student stud = new Student(id[i],name[i]);
				studentRecord.add(stud);
				System.out.println("Student with ID: "+id[i]+" added");
			}
		}
		
		public static void initialbookCollection() {
			String[][] nameAndISBN = {{"CapitalBook","10001"},{"AreaBook","10002"},{"LatitudeBook","10001"},{"LongitudeBook","10003"},
					{"CurrencyBook","10004"},{"NationalBook","10004"},{"CodeBook","10001"},{"TimeBook","10002"}};
			int[] id = {1,2,3,4,5,6,7,8};
			Boolean [][] bools = {{false,false,false},{false,false,false},{false,false,false},
									{false,false,false},{false,false,false},{false,false,false},
									{false,false,false},{false,false,false}};
			
			for(int i=0;i<id.length;i++) {
				Thread initializingBookList = new Thread(new Admin(queue,nameAndISBN[i][0],id[i],nameAndISBN[i][1],bools[i][0],bools[i][1],bools[i][2]));
				initializingBookList.run();
				Book bk=new Book(nameAndISBN[i][0],id[i],nameAndISBN[i][1],bools[i][0],bools[i][1],bools[i][2]);
				bookCollection.add(bk);
				System.out.println("Book with ID: "+id[i]+" added");
			}
		}
		
		public static ArrayList<Book> validatebookCollectionCart(int[] ids){
			ArrayList<Book> legit=new ArrayList<Book>();
			for(int id:ids) {
				for(int i=0;i<bookCollection.size();i++) {
					if(bookCollection.get(i).getId() == id && !bookCollection.get(i).getIsInReview() && !bookCollection.get(i).getIsInCart()) {
						legit.add(bookCollection.get(i));
						break;
					}
				}
			}
			return legit;
		}
		
		public static Book validatebookCollectionReview(int id){
			Book legit = null;
				for(int i=0;i<bookCollection.size();i++) {
					if(bookCollection.get(i).getId() == id && !bookCollection.get(i).getIsInReview() && !bookCollection.get(i).getIsInCart()) {
						legit=bookCollection.get(i);
						break;
					}
				}
			return legit;
		}
		
		public static void addNewBooks() {
			String[][] nameAndISBN = {{"NationalBook","10004"},{"CodeBook","10001"}};
			int[] id = {9,10};
			Boolean [][] bools = {{false,false,false},{false,false,false}};
			for(int i=0;i<id.length;i++) {
				Thread initializingBookList = new Thread(new Admin(queue,nameAndISBN[i][0],id[i],nameAndISBN[i][1],bools[i][0],bools[i][1],bools[i][2]));
				initializingBookList.run();
				Book bk=new Book(nameAndISBN[i][0],id[i],nameAndISBN[i][1],bools[i][0],bools[i][1],bools[i][2]);
				bookCollection.add(bk);
				System.out.println("Book with ID: "+id[i]+" added");
			}
		}
		

		
}

//public static void initialbookCollection() {
//String[][] nameAndISBN = {{"CapitalBook","10001"},{"AreaBook","10002"},{"LatitudeBook","10001"},{"LongitudeBook","10003"},
//		{"CurrencyBook","10004"},{"NationalBook","10004"},{"CodeBook","10001"},{"TimeBook","10002"}};
//int[] id = {1,2,3,4,5,6,7,8};
//Boolean [][] bools = {{false,false,false},{false,false,false},{false,false,false},
//						{false,false,false},{false,false,false},{false,false,false},
//						{false,false,false},{false,false,false}};
//
//for(int i=0;i<id.length;i++) {
//	Book bk=new Book(nameAndISBN[i][0],id[i],nameAndISBN[i][1],bools[i][0],bools[i][1],bools[i][2]);
//	bookCollection.add(bk);
//	System.out.println("Book with ID: "+id[i]+" added");
//}
//}
