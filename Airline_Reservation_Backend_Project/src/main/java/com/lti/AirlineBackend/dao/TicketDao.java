package com.lti.AirlineBackend.dao;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.lti.AirlineBackend.entity.Ticket;
import com.lti.AirlineBackend.excep.NoFlightFoundException;

public interface TicketDao {

	Ticket createTicket(Ticket ticket);
	Ticket findTicketByTicketId(int ticketId) ;
	Ticket cancelTicket(int ticketId);
	List<Ticket> getTicketDetailsByUserEmail(String userEmail );

}
