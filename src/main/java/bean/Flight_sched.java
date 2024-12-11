package bean;

public class Flight_sched {
 
	private int FlightScheduleID;
	private int FlightID ;
	private String DateOfTravel ;
	private int BusinessClassBookedCount;
	public int getFlightScheduleID() {
		return FlightScheduleID;
	}
	public void setFlightScheduleID(int flightScheduleID) {
		FlightScheduleID = flightScheduleID;
	}
	public int getFlightID() {
		return FlightID;
	}
	public void setFlightID(int flightID) {
		FlightID = flightID;
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
	private int EconomyClassBookedCount ;
	private int ExecutiveClassBookedCount;
	
}