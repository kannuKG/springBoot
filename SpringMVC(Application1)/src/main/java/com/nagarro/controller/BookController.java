package com.nagarro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.model.Author;
import com.nagarro.model.Book;
import com.nagarro.service.AuthorService;
import com.nagarro.service.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	@Autowired
	AuthorService authorService;
	
	@RequestMapping("/deleteBook")
	public ModelAndView delete(@RequestParam("param") int id) {
		ModelAndView mv=new ModelAndView();
		bookService.deleteBook(id);
		List<Book> list=bookService.getBook();
		mv.addObject("list",list);
		mv.setViewName("book-list.jsp");
		return mv;
	}
	
	@RequestMapping("/editBook")
	public String bookData(HttpServletRequest request,Model model) {
		//ModelAndView mv = new ModelAndView();

		String id = request.getParameter("parameter");
		int bookCode = Integer.parseInt(id);

		List<Book> list = bookService.getBookById(bookCode);

		List<Author> authorList = authorService.getAuthor();
		        
		 model.addAttribute("list", list);
		 model.addAttribute("authorList", authorList);

        System.out.println(authorList.size());
        

		return("editBooks.jsp");
		
	}

	@RequestMapping("/edit")
	public ModelAndView bookData(@RequestParam("bookCode") int bookCode,@RequestParam("bookName") String bookName,
			@RequestParam("author") String bookAuthor,@RequestParam("date") String date) {
		ModelAndView mv = new ModelAndView();
		
		Book book=new Book();
		Author authorDetails=this.authorService.getAuthorByName(bookAuthor);

		book.setBookCode(bookCode);
		book.setBookName(bookName);
		book.setAuthor(authorDetails);
		book.setDate(date);

		this.bookService.addBook(book);

		bookService.editBook(book, bookCode);
		List<Book> list = this.bookService.getBook();
		mv.addObject("list", list);
		mv.setViewName("book-list.jsp");

		return mv;
	}

	
	@RequestMapping("/add")
	public ModelAndView authorlist(@ModelAttribute Book book) {
		ModelAndView mv = new ModelAndView();
		List<Author> list=this.authorService.getAuthor();
 		mv.addObject("list", list);
 		mv.setViewName("addBooks.jsp");
		return mv;
	}
	@RequestMapping("/addbook")
	public ModelAndView addbookdata(@RequestParam("bookcode") int bookcode,@RequestParam("bookName") String bookName,
			@RequestParam("author") String author,@RequestParam("date") String date) {
		
		ModelAndView mv=new ModelAndView();
		Book b=new Book();
		Author authorName=authorService.getAuthorByName(author);
		b.setBookCode(bookcode);
		b.setBookName(bookName);
		b.setAuthor(authorName);
		b.setDate(date);
		bookService.addBook(b);
		List<Book> list=bookService.getBook();
		mv.addObject("list",list);
		mv.setViewName("book-list.jsp");
		return mv;
		
	}
	
}
