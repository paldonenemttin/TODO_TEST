package com.callor.todo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReqforwordContext {
	
	private final static String prefix = "/WEB-INF/views/";
	private final static String surfix = ".jsp";
	
	public static void forword(HttpServletRequest req, HttpServletResponse resp, String file) throws ServletException, IOException {
		
		String viewFile = prefix + file + surfix;
		
		req.getRequestDispatcher(viewFile).forward(req, resp);
	}

}
