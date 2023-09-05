package com.lti.AirlineBackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lti.AirlineBackend.entity.Ticket;

public interface TicketService {
	Ticket createTicket(Ticket ticket);
	Ticket findTicketByTicketId(int ticketId);
	Ticket cancelTicket(int ticketId);
	List<Ticket> getTicketDetailsByUserEmail(String userEmail );

}
