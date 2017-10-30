package com.transport.services;

import java.io.IOException;
import java.sql.SQLException;

import com.transport.model.Commuter;
/**
 * 
 * @author User
 * @interface CommuterService
 * 
 */
public interface CommuterService {

	
	public Commuter myCabDetails(int cId) throws IOException, SQLException;

	public void viewCabmates(int cId);

	public int updatePickupLocation(int cId,int locId);

}// interface CommuterServices

