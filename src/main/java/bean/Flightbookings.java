package bean;

import java.util.ArrayList;
import java.util.Random;

public class Flightbookings {
	private int Booking_id ;
	private int  Flight_id ;
	private String User_id ;
	private int  Num_of_seats ;
   private int check = 1 ; 
	private String Date_of_travel ;
	private String Booking_status;
	private int Booking_Amount ;  
	

	
	public int getBooking_id() {
		return Booking_id;
	}
	public void setBooking_id(int a ) {
		Booking_id =  a;
	}
	public int getFlight_id() {
		return Flight_id;
	}
	public void setFlight_id(int flight_id) {
		Flight_id = flight_id;
	}
	public String getUser_id() {
		return User_id;
	}
	public void setUser_id(String user_id) {
		User_id = user_id;
	}
	public int getNum_of_seats() {
		return Num_of_seats;
	}
	public void setNum_of_seats(int num_of_seats) {
		Num_of_seats = num_of_seats;
	}
	
	public String getDate_of_travel() {
		return Date_of_travel;
	}
	public void setDate_of_travel(String date_of_travel) {
		Date_of_travel = date_of_travel;
	}
	public String getBooking_status() {
		return Booking_status;
	}
	public void setBooking_status(String booking_status) {
		Booking_status = booking_status;
	}
	public int getBooking_Amount() {
		return Booking_Amount;
	}
	public void setBooking_Amount(int booking_Amount) {
		Booking_Amount = booking_Amount;
	}
	
}