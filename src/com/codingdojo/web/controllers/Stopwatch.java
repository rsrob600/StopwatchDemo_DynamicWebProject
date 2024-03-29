package com.codingdojo.web.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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


		// start session tracking
		HttpSession session = request.getSession();
		
		// get, format and set current time
		Date currentTime = new Date();
		DateFormat formatValue = new SimpleDateFormat("hh:mm:ss a");
		session.setAttribute("currentTime", formatValue.format(currentTime));
		
		// Setup to receive the action state from the start/stop/reset html links
		String linkState = request.getParameter("action");
		
		// declare and initialize array table (get arraytable from Timer model)
		ArrayList<Timer> timeTable = (ArrayList<Timer>) Timer.getTimeTable();
		// set array to pass over to the jsp
		request.setAttribute("timeTable", timeTable);

		
		// check if clock has been started
		if(linkState != null) {
			// if started
			if(linkState.equalsIgnoreCase("start")) {
				// get start variable and check if it is empty
				if(session.getAttribute("start") == null) {
					// get and set new start date
					Date start = new Date();
					session.setAttribute("start", start);
				}
			// 	if stopped
			} else if (linkState.equalsIgnoreCase("stop")) {
				// check if there is a start date
				if(session.getAttribute("start") != null) {
					// get and set new stop date
					Date stop = new Date();
					session.setAttribute("stop",stop);
					// Create new Timer model (Date) cast to the session object for Start/Stop times
					Timer newTR = new Timer((Date)session.getAttribute("start"), (Date)session.getAttribute("stop"));
			
					// reset start and stop times in order to interrupt the logic loop above and prevent reset from a refresh
					session.setAttribute("start", null);
					session.setAttribute("stop", null);
					
					// for testing only
					request.setAttribute("newTR",  newTR);
					System.out.println(newTR);
					System.out.println(newTR.getStart());
					System.out.println(newTR.getStop());
					System.out.println(newTR.getDelta());
					System.out.println(Timer.getTimeTable());
					
				}
			}
		}
		// get the delta (running time)
		if(session.getAttribute("start")!= null) {
			// use currentTime to get delta if there isn't a stop time yet
			if(session.getAttribute("stop") == null) {
				
				// get the difference value between start and stop date (in milliseconds)
				long delta = currentTime.getTime() - ((Date) session.getAttribute("start")).getTime();
				
				// break down time from milliseconds into seconds and minutes
				long secondsInMilli = 1000;
				long minutesInMilli = secondsInMilli * 60;
				long hoursInMilli = minutesInMilli * 60;
				
				// get elapsed time in minutes
				long elapsedMinutes = delta / minutesInMilli;
				// reset the minute counter interval
				delta = delta % minutesInMilli;
				
				// get elapsed time in seconds
				long elapsedSeconds = delta / secondsInMilli;
				// reset the second counter interval
				delta = delta % secondsInMilli;
				
				// declare new elapsed time string
				String deltaTime = elapsedMinutes + "m " + elapsedSeconds + "s";
				
				// set the newly declared elapsed delta time string to be rendered in jsp
				session.setAttribute("deltaTime", deltaTime);
				
			} else {
				// use stop time to get delta if it exist
				long delta = ((Date) session.getAttribute("stop")).getTime() - ((Date) session.getAttribute("start")).getTime();
				session.setAttribute("delta", delta);
			}
			
		}
		
		// reset logic
		if(linkState != null) {
			if(linkState.equalsIgnoreCase("reset")) {
				// clear array table
				timeTable.clear();
				// remove the httpsession tracking
				request.getSession().invalidate();
			}
		}
		
		// set view
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
