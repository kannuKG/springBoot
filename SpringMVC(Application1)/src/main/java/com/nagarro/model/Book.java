package com.nagarro.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Book {

	@Id
	private int bookCode;
	private String bookName;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Author author;
	
	private String date;
	

	public Book() {
		super();

	}

	public Book(int bookCode, String bookName, Author author, String date) {
		super();
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.author = author;
		this.date = date;
	}

	public int getBookCode() {
		return bookCode;
	}

	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
