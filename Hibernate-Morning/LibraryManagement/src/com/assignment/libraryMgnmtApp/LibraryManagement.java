package com.assignment.libraryMgnmtApp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

public class LibraryManagement {
	private static SessionFactory factory;
	public static void main(String[] args) {
		try{
			factory = new Configuration().configure().buildSessionFactory();
		}catch(Exception e){
			System.err.println(e);
		}
		LibraryManagement libmngmt = new LibraryManagement();
		
		String Collection [][] = {{" Algorithms to Live By: The Computer Science of Human Decisions", "Brian Christian","Computer Engineering"},
				{" Computer Programming and experiments","B.L. Gupta","Computer Engineering"},
				{"GDPR: Privacy e Libertà, Corso di sopravvivenza all'era digitale: La nuova Privacy a difesa della Libertà ","Carlo Tenca","Security and Freedom"},
				{"Hackers: Heroes of the Computer Revolution", "Steven Levy","Computer Security"},
				{"Guide du dessinateur industriel","André Chevalier","Industrial Engineering"},
				{"The Algorithmic Leader: How to Be Smart When Machines Are Smarter Than You","Mike Walsh","Computer Engineering"},
				{"Inorganic Chemistry: Principles of Structure and Reactivity","James Huheey","Chemical Engineering"},
				{"AUTOMATISATION INTELLIGENTE","Pascal Bornet","Computer Engineering"},
				{"Human Anatomy and Physiology","Surbhi Bansal","Biology"}};
		String Language [] = {"English","Hindi","Italian","English","French","English","German","French","Hindi"};
		int published [] = {1989,2013,2001,2006,1978,2000,1991,2011,1960};
		libmngmt.getBooks();
		for (int i=0; i<Language.length; i++) {
			Integer bookId = libmngmt.addBook(Collection[i][0], Collection[i][1],Collection[i][2], Language[i],published[i]);
			System.out.println("Book with id " + bookId.intValue()+" is inserted.");
		}
		libmngmt.getBooks();
		libmngmt.getBookNo(4);
		libmngmt.updateBookNo(7);
		libmngmt.removeBookNo(9);
		libmngmt.getTotalCount();
	}
	
	public Integer addBook(String name, String writer, String type, String language, Integer published) {
		Session session=factory.openSession();
		Transaction tx = null;
		Integer bookId = null;
		try {
			tx = session.beginTransaction();
			LibraryBooks book = new LibraryBooks(name,writer,type,language,published);
			bookId = (Integer) session.save(book);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx !=null)
				tx.rollback();
		}finally {
			session.close();
		}
		return bookId;
	}
	
	private void getBooks() {
		System.out.println("===========Library Books Details :============");	
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List<LibraryBooks> collection = session.createQuery("FROM LibraryBooks").list();
			if(collection.size() == 0) System.out.println("Books Not Available");
			else {
				System.out.println("The books available in library are as follows: ");
				for(LibraryBooks libbk : collection) {
					System.out.println("BookId: "+libbk.getBookId());
					System.out.println("Name: "+libbk.getName());
					System.out.println("Writer: "+libbk.getWriter());
					System.out.println("Type: "+libbk.getType());
					System.out.println("Language: "+libbk.getLanguage());
					System.out.println("PublishedOn: "+libbk.getPublished());
					System.out.println("==================================");
				}
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null) {
				tx.rollback();
			}
		}finally {
			session.close();
		}
	}
	
	private void getBookNo(int bookId) {
		Session session = factory.openSession();
		Transaction tx= null;
		try {
			tx = session.beginTransaction();
			LibraryBooks libbk = session.get(LibraryBooks.class,bookId);
			System.out.println("Get Book with Id "+bookId);
			System.out.println("BookId: "+libbk.getBookId());
			System.out.println("Name: "+libbk.getName());
			System.out.println("Writer: "+libbk.getWriter());
			System.out.println("Type: "+libbk.getType());
			System.out.println("Language: "+libbk.getLanguage());
			System.out.println("PublishedOn: "+libbk.getPublished());
			System.out.println("==================================");
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx !=null)
				tx.rollback();
		}finally {
			session.close();
		}	
	}
	
	private void updateBookNo(int bookId) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			LibraryBooks libbk = session.get(LibraryBooks.class, bookId);
			System.out.println("Updating Book with Id :"+bookId);
			System.out.println("==========Before Updation===========");
			System.out.println("BookId: "+libbk.getBookId());
			System.out.println("Name: "+libbk.getName());
			System.out.println("Writer: "+libbk.getWriter());
			System.out.println("Type: "+libbk.getType());
			System.out.println("Language: "+libbk.getLanguage());
			System.out.println("PublishedOn: "+libbk.getPublished());
			libbk.setType("Artificial Intelligence");
			libbk.setLanguage("Bulgarian");
			libbk.setPublished(2005);
			session.update(libbk);
			System.out.println("===========After Updation===========");
			System.out.println("BookId: "+libbk.getBookId());
			System.out.println("Name: "+libbk.getName());
			System.out.println("Writer: "+libbk.getWriter());
			System.out.println("Type: "+libbk.getType());
			System.out.println("Language: "+libbk.getLanguage());
			System.out.println("PublishedOn: "+libbk.getPublished());
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx !=null)
				tx.rollback();
		}finally {
			session.close();
		}
	}
	
	private void removeBookNo(int bookId) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			LibraryBooks libbk = session.get(LibraryBooks.class, bookId);
			session.remove(libbk);
			System.out.println("Book with Id "+bookId+" has been issued and is not currently available.");
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx !=null)
				tx.rollback();
		}finally {
			session.close();
		}
	}
	
	private void getTotalCount() {
		Session session = factory.openSession();
		Transaction tx = null;
		int count= 0;
		try {
			tx = session.beginTransaction();
			List<LibraryBooks> collection = session.createQuery("FROM LibraryBooks").list();
			count = collection.size();
			System.out.println("Library Has Total "+count+" books.Please do issue the books as required:)");
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null) {
				tx.rollback();
			}
		}finally {
			session.close();
		}
	}
}
