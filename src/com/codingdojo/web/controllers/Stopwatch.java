package com.codingdojo.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Date;
import java.util.ArrayList;
import com.codingdojo.web.models.Timer;

/**
 * Servlet implementation class Stopwatch
 */
@WebServlet("/Stopwatch")
public class Stopwatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// start session
		HttpSession session = request.getSession();
		
		// new or null session check
		
		// get current time
		
		// start logic
		
		// stop logic
		
		// reset logic
		
		// add times to storage data structure (arrayList or HashMap???)
		
		// 
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/stopwatch.jsp");
        view.forward(request, response);
        

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// not passing any form data so don't need post method
		
		
		doGet(request, response);
	}

}
