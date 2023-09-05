package com.lti.AirlineBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.AirlineBackend.entity.Ticket;
import com.lti.AirlineBackend.service.TicketService;

@CrossOrigin("*")
@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	TicketService ticketService;
	
	
	//http://localhost:8282/ticket
	
	@PostMapping("/")
	public Ticket createTicket(@RequestBody Ticket ticket )
	{
		Ticket ticket1 = ticketService.createTicket(ticket);
		return ticket1;
	}
	
	
	//http://localhost:8282/ticket/0
	@GetMapping("/{ticketId}")
	public Ticket findTicketByTicketId(@PathVariable("ticketId") int ticketId )
	{
		Ticket payment = ticketService.findTicketByTicketId(ticketId) ;
		return payment;
	}
	
	//http://localhost:8282/ticket/cancelticket/0
	@PutMapping("/cancelticket/{ticketId}")
	public Ticket cancelTicket(@PathVariable("ticketId") int ticketId){
		return ticketService.cancelTicket(ticketId);
		
	}
	
	 //http://localhost:8282/ticket/getTickets/userEmail
    @GetMapping("/getTickets/{userEmail}")
    public List<Ticket> getTicketDetailsByUserEmail(@PathVariable("userEmail") String userEmail )
    {
        //Ticket payment = ticketService.getTicketDetailsByUserEmail(userEmail) ;
        List<Ticket> tickets= ticketService.getTicketDetailsByUserEmail(userEmail);
        
        return tickets;
    }

}
