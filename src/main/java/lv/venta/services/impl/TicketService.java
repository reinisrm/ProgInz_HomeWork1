package lv.venta.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import lv.venta.services.iTicketService;
import lv.venta.models.Cashier;
import lv.venta.models.Ticket;
import lv.venta.models.Trip;

@Service
public class TicketService implements iTicketService {

	private ArrayList<Ticket> allTickets = new ArrayList<>();
	
	@Override
	public ArrayList<Ticket> selectAllChildTickets(boolean isChild) {
		ArrayList<Ticket> allChildTickets = new ArrayList<>();
		
		for(Ticket temp : allTickets) {
			if(temp.isChild() == true) {
				allChildTickets.add(temp);
			}
		} return allChildTickets;
		
	}
	@Override
	public ArrayList<Ticket> selectAllTicketsWherePriceIsLow(float priceLowerFilter) {
		ArrayList<Ticket> allTicketsWherePriceIsLow = new ArrayList<>();
		
		for(Ticket temp : allTickets) {
			if(temp.getPrice() < priceLowerFilter) {
				allTicketsWherePriceIsLow.add(temp);
			}
		}
		return allTicketsWherePriceIsLow;
	}
	@Override
	public ArrayList<Ticket> selectAllTicketsByTripId(int idtr) {
		ArrayList<Ticket> allTicketsByTripId = new ArrayList<>();
		
		for(Ticket temp : allTickets) {
			if(temp.getTrip().getIdtr() == idtr) {
				allTicketsByTripId.add(temp);
			}
		}
		return allTicketsByTripId;
	}
	@Override
	public float calculateIncomeOfTripByTripId(int idtr) {
		float income = 0;
		
		for(Ticket temp : allTickets) {
			if(temp.getTrip().getIdtr() == idtr) {
				income = income + temp.getPrice();
			}
		}
		return income;
	}
	@Override
	public float calculateIncomeOfCashierByCashierId(int idc) {
		float income = 0;	
		
		for(Ticket temp : allTickets) {
			if(temp.getCashier().getIdc() == idc) {
				income = income + temp.getPrice();
			}
		}
		return income;
		
	}
	
	//TODO Pabeigt/Partaisit funkciju
	/*
	public Ticket insertNewTicketByTripId(int idtr) {
	    for (Ticket temp : allTickets) {
	        if (temp.getTrip().getIdtr() == idtr) {
	            return temp;
	        }
	    }

	    
	    Ticket newTicket = new Ticket(purchaseDateTime, price, trip, isChild, cashier);
	    allTickets.add(newTicket);
	    return newTicket;
	} */
	
	
	
	
}
