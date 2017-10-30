package com.transport.model;

public class Cab {

	private int cabNo;
	private int driverId;
	private int routeNo;
	public Cab(int cabNo, int driverId, int routeNo) {
		super();
		this.cabNo = cabNo;
		this.driverId = driverId;
		this.routeNo = routeNo;
	}
	public Cab() {
		// TODO Auto-generated constructor stub
	}
	public int getCabNo() {
		return cabNo;
	}
	public void setCabNo(int cabNo) {
		this.cabNo = cabNo;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public int getRouteNo() {
		return routeNo;
	}
	public void setRouteNo(int routeNo) {
		this.routeNo = routeNo;
	}
	@Override
	public String toString() {
		return "Cab [cabNo=" + cabNo + ", driverId=" + driverId + ", routeNo="
				+ routeNo + "]";
	}
	
	
	
	
	
	
	
}//class
