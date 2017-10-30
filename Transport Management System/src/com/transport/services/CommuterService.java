package com.transport.services;

import java.io.IOException;
import java.sql.SQLException;

import com.transport.model.Cab;
import com.transport.model.Commuter;
/**
 * 
 * @author User
 * @interface CommuterService
 * 
 */
public interface CommuterService {

	
	public Cab myCabDetails(int cId) throws IOException, SQLException;

	public void viewCabmates(int cId);

	public int updatePickupLocation(int cId,int locId);

}// interface CommuterServices

