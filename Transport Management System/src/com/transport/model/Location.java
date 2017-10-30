package com.transport.model;

public class Location {

	
	private int locId;
	private String locName;
	private int cLoc;
	public Location(int locId, String locName, int cLoc) {
		super();
		this.locId = locId;
		this.locName = locName;
		this.cLoc = cLoc;
	}
	public Location() {
		// TODO Auto-generated constructor stub
	}
	public int getLocId() {
		return locId;
	}
	public void setLocId(int locId) {
		this.locId = locId;
	}
	public String getLocName() {
		return locName;
	}
	public void setLocName(String locName) {
		this.locName = locName;
	}
	public int getcLoc() {
		return cLoc;
	}
	public void setcLoc(int cLoc) {
		this.cLoc = cLoc;
	}
	
	
	
	
	
}
