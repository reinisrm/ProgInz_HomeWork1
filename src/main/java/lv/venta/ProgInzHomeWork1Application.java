package lv.venta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.models.Buscategory;
import lv.venta.models.Cashier;
import lv.venta.models.City;
import lv.venta.models.Driver;
import lv.venta.models.Person;
import lv.venta.models.Ticket;
import lv.venta.models.Trip;
import lv.venta.repos.iCashierRepo;
import lv.venta.repos.iCityRepo;
import lv.venta.repos.iDriverRepo;
import lv.venta.repos.iTicketRepo;
import lv.venta.repos.iTripRepo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class ProgInzHomeWork1Application {

    public static void main(String[] args) {
        SpringApplication.run(ProgInzHomeWork1Application.class, args);
    }
    
    @Bean
    public CommandLineRunner testModel(iCashierRepo cashierRepo, iCityRepo cityRepo,
        iDriverRepo driverRepo, iTicketRepo ticketRepo,iTripRepo tripRepo) {
    	return new CommandLineRunner( ) {
    		public void run(String... args) throws Exception {
			
				
	
            // Create and save objects in repositories
            Cashier cashier1 = new Cashier("Anna", "Vitola");
            Cashier cashier2 = new Cashier("Zane", "Berzina");
            cashierRepo.save(cashier1);
            cashierRepo.save(cashier2);
            
            City city1 = new City("Riga", "Ventspils iela 42");
            City city2 = new City("Ventspils", "Rigas iela 24");
            cityRepo.save(city1);
            cityRepo.save(city2);
            
            Driver driver1 = new Driver("Alekss", "Braucejs", Buscategory.schoolbus);
            Driver driver2 = new Driver("Uldis", "Smits", Buscategory.largebus);
            driverRepo.save(driver1);
            driverRepo.save(driver2);
            
            Trip trip1 = new Trip(new ArrayList<>(Arrays.asList(city1, city2)), driver1, LocalDateTime.now().plusDays(1), "2 hours");
            tripRepo.save(trip1);
            
            Trip trip2 = new Trip(new ArrayList<>(Arrays.asList(city2, city1)), driver2, LocalDateTime.now().plusHours(5), "3 hours");
            tripRepo.save(trip2);
          
            
            Ticket ticket1 = new Ticket(LocalDateTime.now(), 10.0f, trip1, false, cashier1);
            Ticket ticket2 = new Ticket(LocalDateTime.now(), 15.0f, trip2, true, cashier2);
            ticketRepo.save(ticket1);
            ticketRepo.save(ticket2);
            
       
    		}
		
        };
    }
}
