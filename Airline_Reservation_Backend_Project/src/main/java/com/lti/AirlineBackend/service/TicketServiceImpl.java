package com.lti.AirlineBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.AirlineBackend.dao.TicketDao;
import com.lti.AirlineBackend.entity.Ticket;

@Service("ticketService")
public class TicketServiceImpl implements TicketService {

		
	@Autowired
	TicketDao ticketDao;
	@Override
	public Ticket createTicket(Ticket ticket) {
		Ticket ticket1 = ticketDao.createTicket(ticket);
		return ticket1;
	}

	@Override
	public Ticket findTicketByTicketId(int ticketId) {
		Ticket ticket=ticketDao.findTicketByTicketId(ticketId);
		return ticket;
	}

	@Override
	public Ticket cancelTicket(int ticketId) {
		Ticket ticket=ticketDao.cancelTicket(ticketId);
		return ticket;
	}
	
	@Override
    public List<Ticket> getTicketDetailsByUserEmail(String userEmail) {
        List<Ticket> ticketList=ticketDao.getTicketDetailsByUserEmail(userEmail);
        return ticketList;
    }

}
