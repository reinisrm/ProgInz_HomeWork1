package lv.venta.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.models.Trip;
import lv.venta.services.iTripService;


@Controller
@RequestMapping("/trip")
public class TripController {

	@Autowired
	private iTripService tripService;

	@GetMapping("/showAll/city/{cityTitle}")
	public String showAllTripsByCityTitle(@PathVariable String cityTitle, Model model) {
		if (cityTitle != null) {
			try {
				model.addAttribute("CityTrips", tripService.selectAllTripsByCityTitle(cityTitle));
				return "tripByCity-page";
			} catch (Exception e) {
				return "error-page"; // paradis error-page.html lapu
			}
		} return "error-page";
	}
	
	@GetMapping("/showAll/driver/{idd}")
	public String showAllTripsByDriverId(@PathVariable int idd, Model model) {
		if (idd > -1) {
			try {
				model.addAttribute("DriverTrips", tripService.selectAllTripsByDriverId(idd));
				return "trip-all-page";
			} catch (Exception e) {
				return "error-page"; // paradis error-page.html lapu
		    }
		} return "error-page";
	}
	
	@GetMapping("/showAll/today")
	public ArrayList<Trip> showAllTripsToday() {
		return tripService.selectAllTripsToday();
	}
	@GetMapping("/changeDriver/{idtr}/{idd}")
	private String changeTripDriverByDriverId(@PathVariable int idd, @PathVariable int idtr) {
	    try {
	        tripService.changeTripDriverByDriverId(idtr, idd);
	        return "trip-all-page"; 
	    } catch (Exception e) {
	        return "error-page"; 
	    }
	}
	
	
	
	
	
}
