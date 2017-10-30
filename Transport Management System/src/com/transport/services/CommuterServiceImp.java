package com.transport.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
	public Commuter getCommuter(int id) throws IOException, SQLException {

		// TODO Auto-generated method stub
		Commuter newcommuter = null;
		newcommuter = CommuterDao.getCommuter(id);
		return newcommuter;
	}

	public List<Commuter> getCommuterDetails() {

		List<Commuter> newp = null;
		try {
			try {
				newp = CommuterDao.getCommuterDetails();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newp;
	}//getCommuterDetails method

	public int updateCommuter(int cLoc, int cId) throws SQLException {
		// TODO Auto-generated method stub

		// Commuter newcommuter= null;
		try {
			cLoc = CommuterDao.updateCommuter(cLoc);
			return 1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	@Override
	public void getCommuterDetails(Commuter Commuter) {
		// TODO Auto-generated method stub

	}

	@Override
	public Commuter updateCommuter(Commuter commuter) {
		// TODO Auto-generated method stub
		return null;
	}// class ends here

}
