package com.vm.api.model;

public class Event {

	private String title;

	private String start;
	
	private String hour;

	private String end;

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getStart() {
		return start;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getEnd() {
		return end;
	}
	
	public void setHour(String hour) {
		this.hour = hour;
	}
	
	public String getHour() {
		return hour;
	}

}
