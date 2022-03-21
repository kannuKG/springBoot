package com.nagarro.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.model.Book;
import com.nagarro.service.BookService;
import com.nagarro.service.UserService;


@Controller
public class LoginController {
	@Autowired
	UserService loginService;
	@Autowired
	BookService bookservice;
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("username") String userName, @RequestParam("password") String password,HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		loginService.save();
		
		if (loginService.validation(userName, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", userName);
			List<Book> list=this.bookservice.getBook();
	 		 mv.addObject("list", list);
			mv.setViewName("book-list.jsp");
		} else {
			System.out.print("invalid!!!!!!!");
			mv.setViewName("login.jsp");
		}

		return mv;
	}
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.invalidate();
		mv.setViewName("login.jsp");
		return mv;
		
	}

}
