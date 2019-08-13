package com.codingdojo.web.models;


import java.util.ArrayList;
import java.util.Date;

//Player JavaBean
public class Timer implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	// Timer member object variables
	private Date start;
	private Date stop;
	private String delta;
	
	// List variable
	private static ArrayList<Timer> timeTable = new ArrayList<Timer>();
	
	// Constructors
	public Timer() {
	}
	
	public Timer(Date start, Date stop) {
		this.start = start;
		this.stop = stop;
		this.delta = getDelta(this.stop, this.start);
		this.timeTable.add(this);
	}
	

	
	// getters and setters
	public void setStart(Date start) {
		this.start = start;
	}
	
	public Date getStart() {
		return start;
	}
	
	public void setStop(Date stop) {
		this.stop = stop;
	}
	
	public Date getStop() {
		return stop;
	}
	
	public String getDelta() {
		return delta;
	}
	
	// used to calculate the duration of the timer (start / stop)
	public static String getDelta(Date stop, Date start) {
		
		// get the difference value between start and stop date (in milliseconds)
		long delta = stop.getTime() - start.getTime();
		// break down time from milliseconds into seconds and minutes
		long secondsInMilli = 1000;
		long minutesInMilli = secondsInMilli * 60;
		long hoursInMilli = minutesInMilli * 60;
		
		// get elapsed time in minutes
		long elapsedMinutes = delta / minutesInMilli;
		delta = delta % minutesInMilli;
		
		// get elapsed time in seconds
		long elapsedSeconds = delta / secondsInMilli;
		delta = delta % secondsInMilli;
		
		return elapsedMinutes + "m " + elapsedSeconds + "s";
	}
	
	public static ArrayList<Timer> getTimeTable(){
		return timeTable;
	}
	
	
}
