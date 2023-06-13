package lv.venta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lv.venta.models.Driver;
import lv.venta.services.iDriverCRUDService;


@Controller
@RequestMapping("/driver")
public class DriverController {

	@Autowired
	 private iDriverCRUDService driverService;
	
	
	@GetMapping("/showAll") // localhost:8080/driver/showAll
	public String showAllDrivers(Model model) {
		model.addAttribute("myDrivers", driverService.selectAllDriver());
		return "driver-all-page"; 
	}
	

	@GetMapping("/showAll/{id}") // localhost:8080/driver/showAll/id
	public String showDriverById(@PathVariable("idd") int idd,Model model) {
		if(idd > -1) {
			try {
		model.addAttribute("MyDrivers", driverService.selectDriverById(idd));
		
		return "driver-one-page"; //"driver-by-id"
			} catch (Exception e) {
				return "error-page"; // paradis error-page.html lapu
			}
		} return "error-page";
	}
	
	@GetMapping("/remove/{id}") // localhost:8080/driver/remove/id
	public String removeById(@PathVariable("idd") int idd, Model model) {
		try {
		driverService.deleteDriverById(idd);
			model.addAttribute("myAllDrivers", driverService.selectAllDriver());
			return "driver-all-page";
		} catch (Exception e) {
			return "error-page";
		}
	}
	@GetMapping("/addNew") // localhost:8080/driver/addNew
	public String addNewDriver(Driver driver) {
		return "driver-add-page";
	}
	//TODO Izlabot funkciju driver service
	
	@PostMapping("/addNew")
	public String addNewDriver(@Valid Driver driver, BindingResult result) {
		if(!result.hasErrors()) {
			driverService.insertNewDriver(driver);
			return "redirect:/driver/showAll";
		} else {
			return "error-page";
		}
	} 
	
	@GetMapping("/update/{id}")
	public String updateDriverById(@PathVariable("idd")int idd, Model model) {
		try {
			model.addAttribute("driver", driverService.updateDriverById(idd));
			return "driver-update-page";
			
		}catch (Exception e) {
			return "error-page";
		}
	}
	//TODO izlabot funkciju
	@PostMapping("/update/{id}")
	public String updateDriverById(@PathVariable("idd")int idd, @Valid Driver driver, BindingResult result) {
		if(!result.hasErrors()) {
			try {
				Driver temp = driverService.updateDriverById(idd);
				return "redirect:/driver/showAll";
			}  catch (Exception e) {
				return "redirect:/error-page"; // tiks izsaukts localhost:8080/error
			} 
			} else {
				return "update-page";
			
		}
	}
	
	
	
}
