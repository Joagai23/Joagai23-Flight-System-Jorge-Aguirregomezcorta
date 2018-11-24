package ie.lyit.flight;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class BookingTest {

	Booking b1;
	Flight in;
	Flight out;
	ArrayList<Passenger> pas;
	Passenger p1;
	
	@Before
	public void setUp() throws Exception {
		in = new Flight();
		out = new Flight();
		pas = new ArrayList<Passenger>();
		b1 = new Booking(in, out, pas);
		p1 = new Passenger("Mr", "Joe", "Doe", 25, 12, 1985, 2, true);
	}

	@Test
	public void testBookingFlightFlightArrayListOfPassenger() {
		assertEquals(b1.getInboundFlight(), new Flight());
		assertEquals(b1.getOutboundFlight(), new Flight());
		assertEquals(b1.getPassengers(), new ArrayList<Passenger>());
	}

	@Test
	public void testToString() {
		assertEquals("Booking ==>\nOutbound: " + b1.getOutboundFlight() + "\nInbound: " + b1.getInboundFlight() + 
				"\nNumber of Passengers: " + b1.getPassengers().size() + "\nTotal price: " + b1.getTotalPrice() + "€", b1.toString());
	}

	@Test
	public void testFindPassenger() {
		pas.add(p1);
		assertTrue(b1.FindPassenger(p1));
	}

	@Test
	public void testCalculatePrice() {
		assertEquals(0.0, b1.CalculatePrice(), 0.01);
	}

	@Test
	public void testSetOutboundFlight() {
		b1.setOutboundFlight(new Flight("1234", "Dublin", "Paris", 23, 02, 2019, 17, 30, 100));
		assertEquals(b1.getOutboundFlight(), new Flight("1234", "Dublin", "Paris", 23, 02, 2019,17, 30, 100));
	}

	@Test
	public void testSetInboundFlight() {
		b1.setInboundFlight(new Flight("4321", "Paris", "Dublin", 01, 03, 2019, 9, 00, 200));
		assertEquals(b1.getInboundFlight(), new Flight("4321", "Paris", "Dublin", 01, 03, 2019, 9, 00, 200));
	}

	@Test
	public void testSetPassengers() {
		ArrayList<Passenger> p2 = new ArrayList<Passenger>();
		p2.add(p1);
		p2.add(new Passenger());
		b1.setPassengers(p2);
		assertEquals(b1.getPassengers(), p2);
	}

	@Test
	public void testSetTotalPrice() {
		b1.setPassengers(pas);
		pas.add(p1);
		b1.setInboundFlight(new Flight("4321", "Paris", "Dublin", 01, 03, 2019, 9, 00, 200));
		b1.setTotalPrice();
		assertEquals(200, b1.getTotalPrice(), 0.1);
	}

}
