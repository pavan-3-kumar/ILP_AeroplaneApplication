package dao;
import bean.Flights_details;
import bean.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Search_flights {

//	TreeMap<Flights_details,Flight_sched>
	public static  ArrayList<combination_user_search> search(String origin , String destination , String date)
	{
		Connection con = null;
		PreparedStatement ps  = null;
		int count =0 ; 
		ArrayList<combination_user_search> ans = new ArrayList<>();
		combination_user_search obj = null;
		
		try {	
//			Connection con = null;
//			System.out.println("this is search before");
			Class.forName("org.sqlite.JDBC");
			 con =  DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Pavan kumar.V\\MySQLiteDB");
		
		
		
		String query = "select * from Flight f JOIN  FlightSchedule fs on f.Flight_id = fs.FlightID where f.Origin = (?) and f.Destination = (?) and fs.DateOfTravel = (?)";
		System.out.println("this is search before");

		ps = con.prepareStatement(query);
		
		ps.setString(1,origin);
		ps.setString(2,destination);
		ps.setString(3,date);
		System.out.println("this is search aafter");

		ResultSet rs = ps.executeQuery();
		
		System.out.println("this is search after");		

		while(rs.next())
		{
//			System.out.println("entered");
			combination_user_search f = new combination_user_search();
			f.setFlight_id(rs.getInt("Flight_id"));
			f.setCarrier_id(rs.getInt("Carrier_id"));
			f.setOrigin(rs.getString("Origin"));
			f.setDestination(rs.getString("Destination"));
			f.setAirFare(rs.getInt("AirFare"));
			
			f.setDateOfTravel(rs.getString("DateOfTravel"));
			f.setEconomyClassBookedCount(rs.getInt("EconomyClassBookedCount"));
			f.setExecutiveClassBookedCount(rs.getInt("ExecutiveClassBookedCount"));
			f.setBusinessClassBookedCount(rs.getInt("BusinessClassBookedCount"));
//            ans.put(f, fs);
			f.setCombination_ID("");
			ans.add(f);
		
//            for(Flights_details i : ans.keySet())
//    		{
//    			System.out.println(i+" "+ans.get(i));
//    		}
		}
		
		if(ps!= null)ps.close();
		if(con != null)con.close();
		
		}
		catch(Exception e)
		{
			  System.out.println("Error in Search_flights_DAO class");
		}
		
		
		
	return ans;
	}
	
}
