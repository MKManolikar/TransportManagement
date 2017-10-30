package com.transport.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.transport.dao.CabDao;
import com.transport.dao.CabDetailsDao;
import com.transport.dao.CommuterDao;
import com.transport.model.Commuter;

/**
 * @author User
 * @class CommuterServiceImp
 * @implements CommuterService
 *
 */
public class CommuterServiceImp implements CommuterService

{

	
	@Override
	public int updatePickupLocation(int cLoc, int cId) {
		// TODO Auto-generated method stub

		// Commuter newcommuter= null;
		try {
			cLoc = CommuterDao.updateCommuter(cId,cLoc);
			return 1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	@Override
	public Commuter myCabDetails(int cId) throws IOException, SQLException {
		// TODO Auto-generated method stub
		
		CabDetailsDao cdDao = new CabDetailsDao();
		
		cdDao.getCabDetails(cId)
		
		
		return null;
	}

	@Override
	public void viewCabmates(int cId) {
		// TODO Auto-generated method stub
		
	}

	
}
