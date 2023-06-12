package lv.venta.services.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import lv.venta.models.Driver;
import lv.venta.services.iDriverCRUDService;

@Service
public class DriverCRUDService implements iDriverCRUDService{
	
	
	public ArrayList<Driver> allDrivers = new ArrayList();
	
	@Override
	public ArrayList<Driver> selectAllDriver() {
		return allDrivers;
	}
	
	@Override
	public Driver selectDriverById(int idd) throws Exception {
		for (Driver temp : allDrivers) {
			if (temp.getIdd() == idd) {
				return temp;
			}
		}
		throw new Exception("Wrong id");
		
	}
	public void deleteDriverById(int idd) throws Exception {
		boolean isFound = false;
		for (Driver temp : allDrivers) {
			if (temp.getIdd() == idd) {
				allDrivers.remove(temp);
				isFound = true;
				break;
			}
		}
		if(!isFound) {		
			throw new Exception("Wrong id");
			}
	}
	public Driver insertNewDriver(Driver driver) {
		for (Driver temp : allDrivers) {
			if(temp.getName().equals(driver.getName()) && temp.getSurname().equals(driver.getSurname())
					&& temp.getBusCategory().equals(driver.getBusCategory())) {
				return temp;
			}
		}
		Driver newDriver = new Driver(driver.getName(), driver.getSurname(), driver.getBusCategory());
		allDrivers.add(newDriver);
		return newDriver;
	}
	public Driver updateDriverById(int idd) throws Exception {
		for(Driver temp : allDrivers) {
			if(temp.getIdd() == idd) {
				return temp;
			}
		}
		throw new Exception("Wrong id");
	}
	
}
