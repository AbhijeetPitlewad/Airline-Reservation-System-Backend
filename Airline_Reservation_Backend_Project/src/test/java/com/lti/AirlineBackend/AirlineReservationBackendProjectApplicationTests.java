package com.lti.AirlineBackend;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.lti.AirlineBackend.dao.AdminDao;
import com.lti.AirlineBackend.dao.FlightDao;
import com.lti.AirlineBackend.dao.PaymentDao;
import com.lti.AirlineBackend.dao.TicketDao;
import com.lti.AirlineBackend.dao.UserDao;
import com.lti.AirlineBackend.entity.Admin;
import com.lti.AirlineBackend.entity.Flight;
import com.lti.AirlineBackend.entity.Payment;
import com.lti.AirlineBackend.entity.Ticket;
import com.lti.AirlineBackend.entity.User;
import com.lti.AirlineBackend.service.AdminService;
import com.lti.AirlineBackend.service.FlightService;
import com.lti.AirlineBackend.service.PaymentService;
import com.lti.AirlineBackend.service.TicketService;
import com.lti.AirlineBackend.service.UserService;

@SpringBootTest
class AirlineReservationBackendProjectApplicationTests {

	@Autowired
	private FlightService  flightService;
	
	@MockBean
	private FlightDao flightDao;
	
	@Test
	void contextLoads() {
	}

	@Test
	void getFlightByflightNumberTest() { 
		int flightNumber=5000;
		Mockito.when(flightDao.getFlightByflightNumber(flightNumber)).thenReturn(new Flight(5000,"Pune-Mumbai","Pune", "Mumbai", "10AM",
			"11AM", 1, 10, 10, 5000, 10000));
		Assertions.assertEquals(5000, flightService.getFlightByflightNumber(5000).getFlightNumber());
	}
	
	@Test
	void getAllFlightsTest() {
		
		Mockito.when(flightDao.getAllFlights()).thenReturn(Arrays.asList(new Flight(5000,"Pune-Mumbai","Pune", "Mumbai", "10AM",
				"11AM", 1, 10, 10, 5000, 10000),new Flight(5001,"Mumbai-Pune","Mumbai", "Pune", "8AM",
						"10AM", 2, 10, 10, 6000, 12000)));
		Assertions.assertEquals(2, flightService.getAllFlights().size());
	}
	
	
	
	@Test
	void addFlightTest() {
		Flight flight= new Flight(5002,"Mumbai-Pune","Mumbai", "Pune", "8AM","10AM", 2, 10, 10, 6000, 12000);
		Mockito.when(flightDao.addFlight(flight)).thenReturn(flight);
		Assertions.assertEquals(5002, flightService.addFlight(flight).getFlightNumber());
	}
	
	
	//----------------------------------------------------------------
	
	@Autowired
	private AdminService  adminService;
	
	@MockBean
	private AdminDao adminDao;
	
	@Test
	void findAdminByUserNameTest() { 
		String  adminUserName="abhi123";
		Mockito.when(adminDao.findAdminByUserName(adminUserName)).thenReturn(new Admin(adminUserName,"12345","Abhijeet"));
		Assertions.assertEquals(adminUserName, adminService.findAdminByUserName(adminUserName).getAdminUserName());
	}
	
	
	
	//----------------------------------------------------------------
	
		@Autowired
		private UserService  userService;
		
		@MockBean
		private UserDao userDao;
		
		@Test
		void findUserTest() { 
			String  userEmail="abhi@gmail.com";
			Mockito.when(userDao.findUser(userEmail)).thenReturn(new User(userEmail, "Mr.", "Abhijeet", "Pitlewad", "12/05/2000",
					"12345", "1234567890", "favourite Sports Person", "Ronaldo"));
			Assertions.assertEquals(userEmail, userService.findUser(userEmail).getUserEmail());
		}
		
		
		@Test
		void addUserTest() {
			User user= new User("abhi@gmail.com", "Mr.", "Abhijeet", "Pitlewad", "12/05/2000",	"12345", "1234567890", "favourite Sports Person", "Ronaldo");
			Mockito.when(userDao.addUser(user)).thenReturn(user);
			Assertions.assertEquals("abhi@gmail.com", userService.addUser(user).getUserEmail());
		}
		
		//----------------------------------------------------------------
		
			@Autowired
			private PaymentService  paymentService;
			
			@MockBean
			private PaymentDao paymentDao;
	
			@Test
			void createPaymentTest() {
				Payment payment= new Payment(4000, 10000, "03/12/2022");
				Mockito.when(paymentDao.createPayment(payment)).thenReturn(payment);
				Assertions.assertEquals(4000, paymentService.createPayment(payment).getPaymentId());
			}
			
			
			//----------------------------------------------------------------
			
			@Autowired
			private TicketService  ticketService;
			
			@MockBean
			private TicketDao ticketDao;
			
			
			@Test
			void createTicketTest() {
				
				User user=new User("abhi@gmail.com", "Mr.", "Abhijeet", "Pitlewad", "12/05/2000","12345", "1234567890", "favourite Sports Person", "Ronaldo");
				Flight flight=new Flight(5002,"Mumbai-Pune","Mumbai", "Pune", "8AM","10AM", 2, 10, 10, 6000, 12000);
				Payment payment=new Payment(4000, 10000, "03/12/2022");
				Ticket ticket= new Ticket(1001, user,  flight,"Economy", 15 , "Booked" ,"12/12/2022",  payment);
				Mockito.when(ticketDao.createTicket(ticket)).thenReturn(ticket);
				Assertions.assertEquals(1001, ticketService.createTicket(ticket).getTicketNumber());
				Assertions.assertEquals("abhi@gmail.com", ticketService.createTicket(ticket).getUser().getUserEmail());
				Assertions.assertEquals(5002, ticketService.createTicket(ticket).getFlight().getFlightNumber());
				Assertions.assertEquals(4000, ticketService.createTicket(ticket).getPayment().getPaymentId());
			}
		
	
}
