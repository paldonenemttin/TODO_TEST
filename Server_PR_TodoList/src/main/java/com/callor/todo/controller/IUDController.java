package com.callor.todo.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.todo.config.DBInfo;
import com.callor.todo.model.TodoVO;
import com.callor.todo.service.TodoService;
import com.callor.todo.service.impl.TodoServiceImpl;

@WebServlet("/todo/*")
public class IUDController extends HttpServlet {

	private static final long serialVersionUID = 7123367616129166663L;

	protected TodoService tdService;

	public IUDController() {
		// TODO Auto-generated constructor stub
		tdService = new TodoServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String subPath = req.getPathInfo();

		if (subPath.equals("/update")) {
			String strSeq = req.getParameter("td_seq");
			Long td_seq = Long.valueOf(strSeq);

			TodoVO tdVO = tdService.findById(td_seq);
			req.setAttribute("TD", tdVO);
		} else if (subPath.equals("/insert")) {
			TodoVO tdVO = new TodoVO();

			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date(System.currentTimeMillis());

			tdVO.setTd_seq(0L);
			tdVO.setTd_date(sd.format(date));
			req.setAttribute("TD", tdVO);
			ReqforwordContext.forword(req, resp, "insert");

		} else if (subPath.equals("/delete")) {

			String strSeq = req.getParameter("td_seq");
			Long td_seq = Long.valueOf(strSeq);

			System.out.println("SEQ:" + td_seq);
			tdService.delete(td_seq);
			resp.sendRedirect("/todo/");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		String subPath = req.getPathInfo();

		String td_date = req.getParameter(DBInfo.td_date);
		String td_work = req.getParameter(DBInfo.td_work);
		String td_space = req.getParameter(DBInfo.td_space);

		TodoVO tdVO = new TodoVO();
		tdVO.setTd_date(td_date);
		tdVO.setTd_work(td_work);
		tdVO.setTd_space(td_space);

		if (subPath.equals("/insert")) {
			tdService.insert(tdVO);
			resp.sendRedirect("/todo/");
		} else if (subPath.equals("/update/")) {
			String strSeq = req.getParameter("td_seq");
			Long td_seq = Long.valueOf(strSeq);

			tdVO.setTd_seq(td_seq);
			tdService.update(tdVO);
			resp.sendRedirect("/todo/");
		}
	}

}
