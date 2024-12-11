package bean;

public class Flights_details {

	private int Flight_id  ;
	private int Carrier_id ;
	private String Origin ;
	private String Destination ;
	private int AirFare ;
	private int Seat_cap_Economy ;
	private int Seat_cap_Business ;
	private int Seat_cap_Executive;
	public int getFlight_id() {
		return Flight_id;
	}
	public void setFlight_id(int flight_id) {
		Flight_id = flight_id;
	}
	public int getCarrier_id() {
		return Carrier_id;
	}
	public void setCarrier_id(int carrier_id) {
		Carrier_id = carrier_id;
	}
	public String getOrigin() {
		return Origin;
	}
	public void setOrigin(String origin) {
		Origin = origin;
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}
	public int getAirFare() {
		return AirFare;
	}
	public void setAirFare(int airFare) {
		AirFare = airFare;
	}
	public int getSeat_cap_Economy() {
		return Seat_cap_Economy;
	}
	public void setSeat_cap_Economy(int seat_cap_Economy) {
		Seat_cap_Economy = seat_cap_Economy;
	}
	public int getSeat_cap_Business() {
		return Seat_cap_Business;
	}
	public void setSeat_cap_Business(int seat_cap_Business) {
		Seat_cap_Business = seat_cap_Business;
	}
	public int getSeat_cap_Executive() {
		return Seat_cap_Executive;
	}
	public void setSeat_cap_Executive(int seat_cap_Executive) {
		Seat_cap_Executive = seat_cap_Executive;
	}
	
	
}