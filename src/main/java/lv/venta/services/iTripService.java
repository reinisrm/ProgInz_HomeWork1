package lv.venta.services;

import java.util.ArrayList;

import lv.venta.models.Ticket;
import lv.venta.models.Trip;

public interface iTripService {

	ArrayList<Trip> selectAllTripsByCityTitle(String cityTitle);
	
	ArrayList<Trip> selectAllTripsByDriverId(int idd);
	
	ArrayList<Trip> selectAllTripsToday();
	
	void changeTripDriverByDriverId(int idd, int idtr) throws Exception;
	
	
}
