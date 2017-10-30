package com.transport.model;

public class Driver {

	private int driverId;
	private String driverName;
	private int driverContact;
	public Driver(int driverId, String driverName, int driverContact) {
		super();
		this.driverId = driverId;
		this.driverName = driverName;
		this.driverContact = driverContact;
	}
	public Driver() {
		// TODO Auto-generated constructor stub
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public int getDriverContact() {
		return driverContact;
	}
	public void setDriverContact(int driverContact) {
		this.driverContact = driverContact;
	}
	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", driverName=" + driverName
				+ ", driverContact=" + driverContact + "]";
	}
	
	
	
	
	
	
		
}
