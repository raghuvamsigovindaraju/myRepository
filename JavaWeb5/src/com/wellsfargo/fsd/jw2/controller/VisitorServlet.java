package com.wellsfargo.fsd.jw2.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsfargo.fsd.jw2.model.VisitorModel;
import com.wellsfargo.fsd.jw2.service.VisitorService;

/**
 * Servlet implementation class VisitorServlet
 */
@WebServlet("/vs")
public class VisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	VisitorModel visitorModel=new VisitorModel();
	visitorModel.setTitle(request.getParameter("title"));
	visitorModel.setFullName(request.getParameter("fullName"));
	visitorModel.setDateOfBirth(LocalDate.parse(request.getParameter("dataOfBirth")));
	
	VisitorService visitorService =new VisitorService();
	visitorService.computeAge(visitorModel);
	String greeting=visitorService.getGreeting();	
	
	request.setAttribute("message",greeting+visitorModel.getTitle()+visitorModel.getFullName());
	request.setAttribute("age","You are "+visitorModel.getAge()+ " years old.");
	
	RequestDispatcher rd=request.getRequestDispatcher("VisitorPage.jsp");
	
	rd.forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
