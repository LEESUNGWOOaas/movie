package com.movie.util.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movie.util.service.MovieService;

@Controller
public class MovieController {
	@Autowired
	MovieService movieService;
	
	@RequestMapping("")
	public String list(HttpServletRequest request,HttpServletResponse response,Model model)throws Exception{
		return "";
	}
}
