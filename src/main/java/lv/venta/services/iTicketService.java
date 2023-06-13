package lv.venta.services;

import java.util.ArrayList;

import lv.venta.models.Ticket;

public interface iTicketService {

	ArrayList<Ticket> selectAllChildTickets(boolean isChild);
	
	ArrayList<Ticket> selectAllTicketsWherePriceIsLow(float price);
	
	ArrayList<Ticket> selectAllTicketsByTripId(int idtr);
	
	float calculateIncomeOfTripByTripId(int idtr);
	
	float calculateIncomeOfCashierByCashierId(int idc);
}
