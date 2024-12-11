package bean;

public class Flight {
	private int flightId;
	private int carrierId;
	private String origin;
	private String destination;
	private int airfare;
	private int seatcapacityeconomyclass;
	private int seatcapacitybusinessclass;
	private int seatcapacityexecuteclass;
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public int getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(int carrierId) {
		this.carrierId = carrierId;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getAirfare() {
		return airfare;
	}
	public void setAirfare(int airfare) {
		this.airfare = airfare;
	}
	public int getSeatcapacityeconomyclass() {
		return seatcapacityeconomyclass;
	}
	public void setSeatcapacityeconomyclass(int seatcapacityeconomyclass) {
		this.seatcapacityeconomyclass = seatcapacityeconomyclass;
	}
	public int getSeatcapacitybusinessclass() {
		return seatcapacitybusinessclass;
	}
	public void setSeatcapacitybusinessclass(int seatcapacitybusinessclass) {
		this.seatcapacitybusinessclass = seatcapacitybusinessclass;
	}
	public int getSeatcapacityexecuteclass() {
		return seatcapacityexecuteclass;
	}
	public void setSeatcapacityexecuteclass(int seatcapacityexecuteclass) {
		this.seatcapacityexecuteclass = seatcapacityexecuteclass;
	}
}
