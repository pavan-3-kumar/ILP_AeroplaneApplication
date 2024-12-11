package bean;

import java.util.Random;

public class combination_user_search {
	
	private String combination_ID;
	
	
	public String getCombination_ID() {
		return combination_ID;
		}
	public void setCombination_ID(String combination_ID) {
		this.combination_ID = ((new Random()).nextInt(900000) + 100000)+"";
;
	}
	private int Flight_id  ;
	
	private int Carrier_id ;
	private String Origin ;
	private String Destination ;
	private int AirFare ;
	private int Seat_cap_Economy ;
	private int Seat_cap_Business ;
	private int Seat_cap_Executive;
	private int FlightScheduleID;
	private String DateOfTravel ;
	private int BusinessClassBookedCount;
	private int EconomyClassBookedCount ;
	private int ExecutiveClassBookedCount;
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
	public int getFlightScheduleID() {
		return FlightScheduleID;
	}
	public void setFlightScheduleID(int flightScheduleID) {
		FlightScheduleID = flightScheduleID;
	}
	public String getDateOfTravel() {
		return DateOfTravel;
	}
	public void setDateOfTravel(String dateOfTravel) {
		DateOfTravel = dateOfTravel;
	}
	public int getBusinessClassBookedCount() {
		return BusinessClassBookedCount;
	}
	public void setBusinessClassBookedCount(int businessClassBookedCount) {
		BusinessClassBookedCount = businessClassBookedCount;
	}
	public int getEconomyClassBookedCount() {
		return EconomyClassBookedCount;
	}
	public void setEconomyClassBookedCount(int economyClassBookedCount) {
		EconomyClassBookedCount = economyClassBookedCount;
	}
	public int getExecutiveClassBookedCount() {
		return ExecutiveClassBookedCount;
	}
	public void setExecutiveClassBookedCount(int executiveClassBookedCount) {
		ExecutiveClassBookedCount = executiveClassBookedCount;
	}
	
}
