package lv.venta.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lv.venta.models.Ticket;
import lv.venta.services.iTicketService;

@Controller
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private iTicketService ticketService;
	
	
	@GetMapping("/showAll/onlyChild") // localhost:8080/ticket/showAll/onlyChild
	private String showAllOnlyChildTickets(@PathVariable("isChild") boolean isChild, Model model) {
		ArrayList<Ticket> onlyChildTickets = ticketService.selectAllChildTickets(isChild);
		model.addAttribute("onlyChildTicket", onlyChildTickets);
		return "ticket-all-page";
	}
	
	@GetMapping("/showAll/less/{threshold}") // localhost:8080/ticket/showAll/less/3
	private String showTicketsPriceLessThanThreshold(@PathVariable("price") float price, Model model) {
		ArrayList<Ticket> allTicketsWithPriceLess = ticketService.selectAllTicketsWherePriceIsLow(price);
		model.addAttribute("ticketsWithPriceLess", allTicketsWithPriceLess);
		return "ticket-all-page";
	}
	@GetMapping("/showAll/trip/{idtr}") // localhost:8080/ticket/showAll/trip/1
	private String showAllTicketsByTripId(@PathVariable("idtr")int idtr, Model model) {
		ArrayList<Ticket> allTicketsByTripId = ticketService.selectAllTicketsByTripId(idtr);
		model.addAttribute("ticketById", allTicketsByTripId);
		return "ticket-all-page";
	}
	@GetMapping("/calculate/trip/{idtr}") // localhost:8080/ticket/calculate/trip/1
	private String calculateIncomeOfTripByTripId(@PathVariable("idtr")int idtr, Model model) {
		float incomeOfTripByTripId = ticketService.calculateIncomeOfTripByTripId(idtr);
		model.addAttribute("tripIncome", incomeOfTripByTripId);
		return "ticket-income-page";
	}
	
	@GetMapping("/calculate/cashier/{idc}") // localhost:8080/ticket/calculate/cashier/1
	private String calculateIncomeOfCashierByCashierId(@PathVariable("idc")int idc, Model model) {
		float incomeOfCashierByCashierId = ticketService.calculateIncomeOfCashierByCashierId(idc);
		model.addAttribute("tripCashier" , incomeOfCashierByCashierId);
		return "cashier-income-page";
	}
	
	@GetMapping("/add/{idtr}")
	private String addNewTicketByTripId(int idtr) {
		return "ticket-add-page";
	}
	@PostMapping
	private String addNewTicketByTripId(@Valid int idtr, BindingResult result) {
		if(!result.hasErrors()) {
			ticketService.insertNewTicketByTripId(idtr);
			return "redirect:/showAll/trip/{idtr}";
		} else {
			return "error-page";
		}
	}
	
	
	
}
