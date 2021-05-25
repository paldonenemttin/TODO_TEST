package com.callor.todo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.todo.model.TodoVO;
import com.callor.todo.service.TodoService;
import com.callor.todo.service.impl.TodoServiceImpl;

@WebServlet("/")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = -3405417004905577242L;

	protected TodoService tdService;
	
	public HomeController() {
		// TODO Auto-generated constructor stub
		tdService = new TodoServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<TodoVO> tdList = tdService.selectAll();
		req.setAttribute("TDLIST" , tdList);
		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
	}
	
	

}
