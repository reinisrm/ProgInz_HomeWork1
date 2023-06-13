package lv.venta.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;

import lv.venta.models.City;
import lv.venta.models.Driver;
import lv.venta.models.Trip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lv.venta.services.iTripService;
import lv.venta.services.impl.DriverCRUDService;


@Service
public class TripService implements iTripService{
	
	 public ArrayList<Trip> allTrips = new ArrayList<>();

	 @Autowired
	 private DriverCRUDService driverService;
	    @Override
	    public ArrayList<Trip> selectAllTripsByCityTitle(String cityTitle) {
	        ArrayList<Trip> tripsByCity = new ArrayList<>();

	        for (Trip temp : allTrips) {
	            for (City tempCity : temp.getCities()) {
	                if (tempCity.getTitle().equals(cityTitle)) {
	                    tripsByCity.add(temp);
	                    break;
	                }
	            }
	           
	        }
	        return tripsByCity; 
	    }
	    
	    @Override
	    public ArrayList<Trip> selectAllTripsByDriverId(int idd) {
	    	
	    	ArrayList<Trip> allTripsByDriverId = new ArrayList<>();
	    	for(Trip temp : allTrips) {
	    		if(temp.getDriver().getIdd() == idd) {
	    			allTripsByDriverId.add(temp);
	    		} 
	    	}
	    	return allTripsByDriverId;
	   }
	   
	    @Override
	    public ArrayList<Trip> selectAllTripsToday() {
	        LocalDateTime now = LocalDateTime.now();
	        ArrayList<Trip> tripsToday = new ArrayList<>();

	        for (Trip temp : allTrips) {
	            if (temp.getStartDateTime().toLocalDate().isEqual(now.toLocalDate())) {
	                tripsToday.add(temp);
	            }
	        }

	        return tripsToday;
	    }
	    
	    //TODO changeTripDriverByDriverId
	    public void changeTripDriverByDriverId(int idd, int idtr) throws Exception {
	        Driver tempDriver = null; 
	        Trip tempTrip = null; 

	        // Atrast trip ar atbilstoso idtr
	        for (Trip trip : allTrips) {
	            if (trip.getIdtr() == idtr) {
	                tempTrip = trip;
	                break;
	            }
	        }

	        // Ja trip nav atrasts ar atbilstoso idtr, met exception
	        if (tempTrip == null) {
	            throw new Exception("Nav atrasts ceļojums!");
	        }

	        // Atrast driver ar atbilstoso idd
	        for (Driver driver : driverService.selectAllDriver()) {
	            if (driver.getIdd() == idd) {
	                tempDriver = driver;
	                break;
	            }
	        }

	        // Ja driver nav atrasts ar atbilstoso idd, met exception
	        if (tempDriver == null) {
	            throw new Exception("Nav atrasts vadītājs!");
	        }

	        // Update trip driver
	        tempTrip.setDriver(tempDriver);
	    }
	    
	    
	}


