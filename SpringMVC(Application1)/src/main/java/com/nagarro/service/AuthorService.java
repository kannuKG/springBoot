package com.nagarro.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.model.Author;

@Service
public class AuthorService {

	private String baseUrl = "http://localhost:8083";
	RestTemplate restTemplate = new RestTemplate();

	public List<Author> getAuthor() {
		String url = baseUrl + "/authors";
		ResponseEntity<Author[]> response = restTemplate.getForEntity(url, Author[].class);
		Author[] author = response.getBody();
		List<Author> authorDetails = Arrays.asList(author);
		return authorDetails;
	}
	public Author getAuthorByName(String authorName) {
		String url = baseUrl + "/author/"+authorName;
		ResponseEntity<Author> response = restTemplate.getForEntity(url, Author.class);
		return response.getBody();
	}

}
