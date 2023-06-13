package lv.venta.services;

import java.util.ArrayList;

import lv.venta.models.Buscategory;
import lv.venta.models.Driver;



public interface iDriverCRUDService {

	ArrayList<Driver> selectAllDriver();
	
	Driver selectDriverById(int idd) throws Exception;
	
	void deleteDriverById(int idd) throws Exception;
	
	Driver insertNewDriver(Driver driver);
	
	Driver updateDriverById(int idd) throws Exception;
	
}
