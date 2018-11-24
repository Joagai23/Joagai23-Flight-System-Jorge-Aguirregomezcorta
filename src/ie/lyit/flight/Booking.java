package ie.lyit.flight;
import java.util.ArrayList;

public class Booking {

	private Flight outbound;
	private Flight inbound;
	private ArrayList<Passenger> passengers;
	private Double totalPrice;
	private static int count = 0; //booking count starts at 0
	
	public Booking()
	{
		outbound = inbound = new Flight();
		passengers = new ArrayList<Passenger>();
		totalPrice = 0.0;
		count++;
	}
	
	public Booking(Flight oF, Flight iF, ArrayList<Passenger> passArray) 
	{
		outbound = oF;
		inbound = iF;
		passengers = passArray;
		totalPrice = CalculatePrice();
	}
	
	@Override
    public String toString(){
		return "Booking ==>\nOutbound: " + outbound + "\nInbound: " + inbound + 
				"\nNumber of Passengers: " + passengers.size() + "\nTotal price: " + totalPrice + "€";
	}
	
	@Override
	public boolean equals(Object obj){
		Booking bObject;
		if (obj instanceof Booking)
		   bObject = (Booking)obj;
		else
		   return false;
		   
	    return(this.inbound==bObject.inbound
	    		&& this.outbound==bObject.outbound
	    		&& this.passengers==bObject.passengers);
	}
	
	public boolean FindPassenger (Passenger pass)
	{
		return passengers.contains(pass);
	}
	
	public double CalculatePrice()
	{
		return passengers.size() * (inbound.getPrice() + outbound.getPrice());
	}
	
	//get methods
	
	public Flight getOutboundFlight()
	{
		return outbound;
	}
	
	public Flight getInboundFlight()
	{
		return inbound;
	}
	
	public ArrayList<Passenger> getPassengers()
	{
		return passengers;
	}
	
	public double getTotalPrice()
	{
		return totalPrice;
	}
	
	//set methods
	
	public void setOutboundFlight(Flight outFlight)
	{
		outbound = outFlight;
	}
	
	public void setInboundFlight(Flight inFlight)
	{
		inbound = inFlight;
	}
	
	public void setPassengers (ArrayList<Passenger> passArray)
	{
		passengers = passArray;
	}
	
	public void setTotalPrice()
	{
		totalPrice = CalculatePrice();
	}
}
