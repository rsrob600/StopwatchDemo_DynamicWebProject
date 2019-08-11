package com.codingdojo.web.models;

import java.util.ArrayList;
import java.util.Date;

//Player JavaBean
public class Timer implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	// Timer member object variables
	private Date start;
	private Date stop;
	private long delta;
	
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
	
	public long getDelta() {
		return delta;
	}
	
	// used to calculate the duration of the timer (start / stop)
	public static long getDelta(Date stop, Date start) {
		return stop.getTime() - start.getTime();
	}
	
	public static ArrayList<Timer> getTimeTable(){
		return timeTable;
	}
	
	public static String arrayToString()
    {
        return timeTable.toString();
    }
	
}
