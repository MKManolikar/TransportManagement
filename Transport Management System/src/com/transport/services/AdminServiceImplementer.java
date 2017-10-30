package com.transport.services;



import java.io.IOException;
import java.sql.SQLException;

import com.transport.dao.CommuterDao;
import com.transport.dao.DriverDao;
import com.transport.dao.LocationDao;
import com.transport.model.Commuter;
import com.transport.model.Driver;
import com.transport.model.Location;

public class AdminServiceImplementer implements AdminServices {

	CommuterDao commuterdao = new CommuterDao();

	@Override
	public Integer addCommuter(Commuter commuter) {
		// TODO Auto-generated method stub
		int status = 0;
		try {
			status = commuterdao.addCommuter(commuter);
			return status;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}


	

	public Commuter getCommuter(int cId) throws SQLException {
		// TODO Auto-generated method stub
		Commuter newp= null;
		try {
			newp=CommuterDao.getCommuter(cId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newp;
	}
		
		
		
		
	

	public Commuter deleteCommuter(int cId) {
		// TODO Auto-generated method stub
		
		try {
			try {
				CommuterDao.deleteCommuter(cId);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}

	@Override
	public void deleteLocation(int loc_id) {
		// TODO Auto-generated method stub
		
		try {
			try {
				LocationDao.deleteLocation(loc_id);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	

	public Commuter getLocation(int loc_id) throws SQLException {
		// TODO Auto-generated method stub
		Commuter newp= null;
		try {
			newp=CommuterDao.getCommuter(loc_id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newp;
	}

	/*public int updateLocation(int loc_id) throws SQLException {
		// TODO Auto-generated method stub
		 
				//Commuter newcommuter= null;
				try {
					loc_id=LocationDao.updateLocation(loc_id);
					return 1;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return 0;
	
	*/
	
	public Driver getDriver(int driverId) throws SQLException, IOException {
		// TODO Auto-generated method stub
		Driver newdr= null;
		newdr=DriverDao.getDriver(driverId);
		return newdr;
	}

	public Driver deleteDriver(int driverId) {
		// TODO Auto-generated method stub
		
				try {
					try {
						DriverDao.deleteDriver(driverId);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			
			}




	@Override
	public Integer addLocation(Location location) {
		// TODO Auto-generated method stub
		int status = 0;
		try {
			status = LocationDao.addLocation(location);
			return status;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}



	@Override
	public Boolean addLocationToRoute() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Integer addDriver(Driver driver) {
		// TODO Auto-generated method stub
		int status = 0;
		try {
			status = DriverDao.addDriver(driver);
			return status;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}




	@Override
	public Commuter getCommuter() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Location getLocation(Location id) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Boolean updateLocation() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Integer getDriverDetails(int Id) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Driver deleteDriverDetails() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Integer addDriverDetails(Driver driver) {
		// TODO Auto-generated method stub
		return null;
	}

}
