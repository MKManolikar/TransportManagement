package com.transport.services;

import com.transport.model.Commuter;
import com.transport.model.Driver;
import com.transport.model.Location;
import com.transport.model.Route;

public interface AdminServices {
	
	
   public Integer addCommuter(Commuter commuter);
	
	public Commuter getCommuter();
	
	public int deleteCommuter(int cId);
	
	public Integer addLocation(Location location);
	
	public void deleteLocation(int Id);
	
	public Location getLocation(Location id);
	
	public Boolean addLocationToRoute();
	
	public Boolean updateLocation();
	
	public Integer addDriverDetails(Driver driver);
	
	public Integer getDriverDetails(int Id);
	
	public Driver deleteDriverDetails();

	public Integer addDriver(Driver driver);
	
}

	
	

