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

	
	public Commuter getCommuter(int id) throws IOException, SQLException;

	public void getCommuterDetails(Commuter Commuter);

	public Commuter updateCommuter(Commuter commuter);

}// interface CommuterServices

