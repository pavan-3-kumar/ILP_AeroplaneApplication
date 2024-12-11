package dao;
import bean.*;
import java.util.*;

import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.combination_user_search;

public class register_booking {
    public static void register(ArrayList<Integer> values , String userid , String DOT , HttpSession session)
    {
    	Connection con = null;
		PreparedStatement ps  = null;
		int count =0 ,rows =0 , rows_updated= 0 ; 
		ArrayList<combination_user_search> ans = new ArrayList<>();
		combination_user_search obj = null;
		
		try {	

			Class.forName("org.sqlite.JDBC");
			 con =  DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Pavan kumar.V\\MySQLiteDB");
			 Flightbookings fb =new Flightbookings();
			 int numofseats = values.get(0)  + values.get(1)  + values.get(2)  ;
			fb.setNum_of_seats(numofseats  );
			fb.setFlight_id(values.get(3));
			fb.setBooking_Amount(values.get(5));
			fb.setBooking_id(((new Random()).nextInt(90000) + 10000));
			fb.setUser_id(userid);
			fb.setDate_of_travel(DOT);
			fb.setBooking_status("Booked");
		String query = "insert into Flight_booking values(?,?,?,?,?,?,?,?,?,?)";
		ps = con.prepareStatement(query);
		ps.setInt(1,fb.getBooking_id() );
		System.out.println(fb.getBooking_id());
		ps.setInt(2, fb.getFlight_id());
		System.out.println(fb.getFlight_id());
		ps.setString(3,fb.getUser_id() );
		System.out.println(fb.getUser_id());
		ps.setInt(4, fb.getNum_of_seats());
		System.out.println(fb.getNum_of_seats());
		ps.setString(5,fb.getDate_of_travel() );		
		System.out.println(fb.getDate_of_travel());
		ps.setString(6,fb.getBooking_status() );
		System.out.println(fb.getBooking_status());
		ps.setInt(7, fb.getBooking_Amount());
		System.out.println(fb.getBooking_Amount());
		ArrayList<Integer> temp = (ArrayList<Integer> )session.getAttribute("tousein_confirm");
		ps.setInt(8, temp.get(1));
		ps.setInt(9,temp.get(2));
		ps.setInt(10,temp.get(3));
		
		

		 rows_updated = ps.executeUpdate();
		String query2="";
		System.out.println("after inserting");
 String retrive="select EconomyClassBookedCount , BusinessClassBookedCount,ExecutiveClassBookedCount from FlightSchedule where  FlightID = ? and DateOfTravel = ?";
 ps =con.prepareStatement(retrive);
 ps.setInt(1,fb.getFlight_id());
 ps.setString(2,fb.getDate_of_travel());
 
 ResultSet ra = ps.executeQuery();
int ec = ra.getInt(1) , bc = ra.getInt(2) ,exc = ra.getInt(3);
	    query2 = "update  FlightSchedule set BusinessClassBookedCount= ? ,EconomyClassBookedCount= ? , ExecutiveClassBookedCount=?   where FlightID = ? and DateOfTravel = ? ";
	    ps =con.prepareStatement(query2);
	    ps.setInt(1, values.get(1)+ bc);
	    ps.setInt(2, values.get(0) + ec); 
	    ps.setInt(3, values.get(2) + exc);
	    ps.setInt(4,fb.getFlight_id());
	    ps.setString(5,fb.getDate_of_travel());
	     rows = ps.executeUpdate();
	     
	     
//	     ArrayList<combination_user_search> flights = (ArrayList<combination_user_search>) session.getAttribute("print_search");
//	    flights = (ArrayList<combination_user_search>)Search_flights.search(origin , destination , date) ;
			
			 if(ps!= null)ps.close();
				if(con != null)con.close();
		
		
		}
		catch(Exception e)
		{
			System.out.println("There is an error in the Register_Booking page"+e);
		}
		System.out.println("inserted into Fligth_booking table"+rows_updated);
		System.out.println("inserted into FligthSchedule table"+rows);
		return ; 
    }
    
    
    public static void delete_booking(int flightid , String dot , int bookingid)
    {
    	Connection con = null;
		PreparedStatement ps  = null;
        int rows =0,rows_up=0 ;
        System.out.println("this is delete_booking page : " + bookingid);
		try {	

			Class.forName("org.sqlite.JDBC");
			 con =  DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Pavan kumar.V\\MySQLiteDB");
		  String query = "update Flight_booking set Booking_status = ? where Booking_id = ?";
			ps = con.prepareStatement(query);
			
			ps.setString(1,"Cancelled");
			ps.setInt(2,bookingid );
//			ps.setString(3, dot);
			
			 rows = ps.executeUpdate();
			
			 String query2 = "select economyclassseats , businessclassseats ,executiveclassseats from Flight_booking where Booking_id = ?";
			 ps = con.prepareStatement(query2);
			 ps.setInt(1, bookingid);
//				ps.setString(2, dot);

			
			 
			 ResultSet rs = ps.executeQuery();
			 int ec = rs.getInt(1) , bc = rs.getInt(2) , exc = rs.getInt(3);
			 System.out.println("printing : "+ec+" "+ bc+" "+exc);
	
			 String query4 = "select EconomyClassBookedCount,BusinessClassBookedCount,ExecutiveClassBookedCount from FlightSchedule where FlightID = ? and DateOfTravel = ?";
			 ps = con.prepareStatement(query4);
			 ps.setInt(1, flightid);
				ps.setString(2, dot);

			 ResultSet  rs1 = ps.executeQuery();
			 if(rs1.next())
			 {
				 System.out.println("NO error");
			 }
			 int f_ec = rs1.getInt(1),f_bc=rs1.getInt(2),f_exc=rs1.getInt(3);
			
//			 System.out.println(f_ec+" "+ f_bc+" "+f_exc);
			 
			 String query3 = "update FlightSchedule set EconomyClassBookedCount= ? ,BusinessClassBookedCount = ? , ExecutiveClassBookedCount = ? where FlightID = ? and DateOfTravel = ?";
			 ps = con.prepareStatement(query3);
			 ps.setInt(1, f_ec-ec);
			 ps.setInt(2, f_bc-bc);
			 ps.setInt(3, f_exc-exc);

			 
			 ps.setInt(4, flightid);
				ps.setString(5, dot);

			  rows_up = ps.executeUpdate();
			 
			
			 
			 
			 
			 
			ps.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("Error in deleting the booking "+e);
		}
		
		System.out.println("rows updated"+ rows);
		System.out.println("rows updated"+ rows_up);

		return;
    }
    
    
    
       
}
