package com.nagarro.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import com.nagarro.model.Book;
import java.util.Arrays;

import org.springframework.http.ResponseEntity;

@Service
public class BookService {

	private String baseUrl = "http://localhost:8083";
	RestTemplate restTemplate = new RestTemplate();

	public List<Book> getBook() {
		String url = baseUrl + "/books";
		ResponseEntity<Book[]> response = restTemplate.getForEntity(url, Book[].class);
		Book[] book = response.getBody();
		List<Book> bookDetails = Arrays.asList(book);

		return bookDetails;
	}

	public String addBook(Book book) {
		String url = baseUrl + "/books";
		ResponseEntity<String> response = restTemplate.postForEntity(url, book, String.class);
		System.out.print(response);
		return response.getBody();

	}
	
	public void deleteBook(int id) {
		String url=baseUrl+"/books/"+id;
		restTemplate.delete(url, id);
		 
	}

	public List<Book> getBookById(int bookCode) {
		String url=baseUrl+"/books/"+bookCode;
		ResponseEntity<Book[]> response = restTemplate.getForEntity(url, Book[].class);
		Book[] book = response.getBody();
		List<Book> bookDetails = Arrays.asList(book);
		return bookDetails;
	}

	public void editBook(Book book,int bookCode) {
		String url=baseUrl+"/books/"+bookCode;
		restTemplate.put(url, book);
		
	}

}
