package dao;
import java.sql.*;
import java.util.ArrayList;

import bean.*;

public class profile_booking_history {
	int check = 0 ; 
    public static ArrayList<Flightbookings> find_history(String id)
    {
    	ArrayList<Flightbookings> result = new ArrayList<>();
 		
    	try {
    		Class.forName("org.sqlite.JDBC");
    		Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Pavan kumar.V\\MySQLiteDB");
   	     String query = "select * from Flight_booking where User_id = ?";
 		PreparedStatement ps = con.prepareStatement(query);
         ps.setString(1,id);
 		ResultSet rs = ps.executeQuery();
 		while(rs.next())
 		{
 			Flightbookings fs = new Flightbookings();
 			fs.setBooking_id(rs.getInt(1));
 			fs.setFlight_id(rs.getInt(2));
 			fs.setNum_of_seats(rs.getInt(4));
 			fs.setDate_of_travel(rs.getString(5));
 			fs.setBooking_status(rs.getString(6));
 			fs.setBooking_Amount(rs.getInt(7));
 			result.add(fs);
 		}
 		
 		ps.close();
 		rs.close();
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error in find_history");
    		
    	}
    	return result;
    	
    }
 }
