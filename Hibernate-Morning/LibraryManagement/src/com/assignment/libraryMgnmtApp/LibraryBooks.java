package com.assignment.libraryMgnmtApp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LibraryBooks")
public class LibraryBooks {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer bookId;
	
	@Column
	private String Name;
	@Column
	private String Writer;
	@Column
	private String Type;
	@Column
	private String Language;
	@Column
	private Integer Published;
	
	public LibraryBooks() {
		super();
	}

	public LibraryBooks(String name, String writer, String type, String language, Integer published) {
		super();
		this.Name = name;
		this.Writer = writer;
		this.Type = type;
		this.Language = language;
		this.Published = published;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getWriter() {
		return Writer;
	}

	public void setWriter(String writer) {
		Writer = writer;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public Integer getPublished() {
		return Published;
	}

	public void setPublished(Integer published) {
		Published = published;
	}
	
	
}
