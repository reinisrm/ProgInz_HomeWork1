package lv.venta.repos;

import org.springframework.data.repository.CrudRepository;

import lv.venta.models.Ticket;

public interface iTicketRepo extends CrudRepository<Ticket, Long> {

}
