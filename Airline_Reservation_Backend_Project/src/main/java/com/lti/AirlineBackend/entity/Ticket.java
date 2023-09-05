package com.lti.AirlineBackend.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Tickets")
public class Ticket {
	
	@Id
	@SequenceGenerator(name = "ticket_id_generator", 
    sequenceName = "ticket_sequence", 
    initialValue = 1000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_id_generator")
	private int ticketNumber;
	
	
	
	
	@Column(length=20)
	private String classType;
	private int seatNumber;
	@Column(length=20)
	private String status;
	@Column(length=20)
	private String flightDate;
	@ManyToOne
	@JoinColumn(name="userEmail")
	private User user;
	@ManyToOne
	@JoinColumn(name="flightNumber")
	private Flight flight;
	@OneToOne
	@JoinColumn(name="paymentId")
	private Payment payment;
	
	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	
	@Override
	public String toString() {
		return "Ticket [ticketNumber=" + ticketNumber + ", user=" + user + ", flight=" + flight + ", classType="
				+ classType + ", seatNumber=" + seatNumber + ", status=" + status + ", flightDate=" + flightDate
				+ ", payment=" + payment + "]";
	}

	public Ticket(int ticketNumber, User user, Flight flight, String classType, int seatNumber, String status,
			String flightDate, Payment payment) {
		super();
		this.ticketNumber = ticketNumber;
		this.user = user;
		this.flight = flight;
		this.classType = classType;
		this.seatNumber = seatNumber;
		this.status = status;
		this.flightDate = flightDate;
		this.payment = payment;
	}

	public Ticket() {
		super();
	}


	
	
	
}
