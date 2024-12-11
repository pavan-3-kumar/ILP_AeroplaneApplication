package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class find_price {
      public static String calculate(String id)
      {
    	  String ans = "";
    	  Connection con = null;
  		PreparedStatement ps  = null;
  		
  		try {	

			Class.forName("org.sqlite.JDBC");
			 con =  DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Pavan kumar.V\\MySQLiteDB");
		
		String query = "select Category from User where User_Id = ? ";
		
		ps = con.prepareStatement(query);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        
		while(rs.next())
		{
			ans = rs.getString("Category");
		}
		
			 if(ps!= null)ps.close();
				if(con != null)con.close();
		
		
		}
		catch(Exception e)
		{
			System.out.println("There is an error in the Category page");
		}   	  
    	  return ans;
      }
      
     public static int thirty_advance_booking_disc(int id)
     {
    	 int dis =0;
    	 Connection con = null;
   		PreparedStatement ps  = null;
   		
   		try {	

 			Class.forName("org.sqlite.JDBC");
 			 con =  DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Pavan kumar.V\\MySQLiteDB");
 		
 		String query = "select Discount_Thirty_AdvanceBooking from Carrier where Carrier_id = ? ";
 		
 		ps = con.prepareStatement(query);
         ps.setInt(1, id);
         ResultSet rs = ps.executeQuery();
         while(rs.next())
         {
        	 dis = rs.getInt("Discount_Thirty_AdvanceBooking");
         }
   		}
		catch(Exception e)
		{
			System.out.println("There is an error in the Discount_Thirty_AdvanceBooking page");
		}
    	 
    	 return dis;
    	 
     }
     
     
     public static int sixty_advance_booking_disc(int id)
     {
    	 int dis =0;
    	 Connection con = null;
   		PreparedStatement ps  = null;
   		
   		try {	

 			Class.forName("org.sqlite.JDBC");
 			 con =  DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Pavan kumar.V\\MySQLiteDB");
 		
 		String query = "select Discount_Sixty_AdvanceBooking from Carrier where Carrier_id = ? ";
 		
 		ps = con.prepareStatement(query);
         ps.setInt(1, id);
         ResultSet rs = ps.executeQuery();
         while(rs.next())
         {
        	 dis = rs.getInt("Discount_Sixty_AdvanceBooking");
         }
   		}
		catch(Exception e)
		{
			System.out.println("There is an error in the Discount_Sixty_AdvanceBooking page");
		}
    	 
    	 return dis;
    	
     }
     
     
     public static int Nintey_advance_booking_disc(int id)
     {
    	 
    	 int dis =0;
    	 Connection con = null;
   		PreparedStatement ps  = null;
   		
   		try {	

 			Class.forName("org.sqlite.JDBC");
 			 con =  DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Pavan kumar.V\\MySQLiteDB");
 		
 		String query = "select Discount_Nintey_AdvanceBooking from Carrier where Carrier_id = ? ";
 		
 		ps = con.prepareStatement(query);
         ps.setInt(1, id);
         ResultSet rs = ps.executeQuery();
         while(rs.next())
         {
        	 dis = rs.getInt("Discount_Nintey_AdvanceBooking");
         }
   		}
		catch(Exception e)
		{
			System.out.println("There is an error in the Discount_Nintey_AdvanceBooking page");
		}
    	 
    	 return dis;
    	
     }
     
     public static int bulk_disc(int id)
     {
    	 int dis =0;
    	 Connection con = null;
   		PreparedStatement ps  = null;
   		try {
 			Class.forName("org.sqlite.JDBC");
 			 con =  DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Pavan kumar.V\\MySQLiteDB");
 		
 		String query = "select Bulk_dis from Carrier where Carrier_id = ? ";
 		
 		ps = con.prepareStatement(query);
         ps.setInt(1, id);
         ResultSet rs = ps.executeQuery();
         while(rs.next())
         {
        	 dis = rs.getInt("Bulk_dis");
         }
   		}
		catch(Exception e)
		{
			System.out.println("There is an error in the Bulk_dis page");
		}
    	 
    	 return dis;
     }
     
     public static int silver_disc(int id)
     {
    	 int dis =0;
    	 Connection con = null;
   		PreparedStatement ps  = null;
   		try {
 			Class.forName("org.sqlite.JDBC");
 			 con =  DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Pavan kumar.V\\MySQLiteDB");
 		
 		String query = "select Silver_dis from Carrier where Carrier_id = ? ";
 		
 		ps = con.prepareStatement(query);
         ps.setInt(1, id);
         ResultSet rs = ps.executeQuery();
         while(rs.next())
         {
        	 dis = rs.getInt("Silver_dis");
         }
   		}
		catch(Exception e)
		{
			System.out.println("There is an error in the Silver_dis page");
		}
    	 
    	 return dis;
     }
     
     public static int gold_disc(int id)
     {
    	 int dis =0;
    	 Connection con = null;
   		PreparedStatement ps  = null;
   		try {
 			Class.forName("org.sqlite.JDBC");
 			 con =  DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Pavan kumar.V\\MySQLiteDB");
 		
 		String query = "select Gold_dis from Carrier where Carrier_id = ? ";
 		
 		ps = con.prepareStatement(query);
         ps.setInt(1, id);
         ResultSet rs = ps.executeQuery();
         while(rs.next())
         {
        	 dis = rs.getInt("Gold_dis");
         }
   		}
		catch(Exception e)
		{
			System.out.println("There is an error in the Gold_dis page");
		}
    	 
    	 return dis;
     }
     
     public static int Platinum_disc(int id)
     {
    	 int dis =0;
    	 Connection con = null;
   		PreparedStatement ps  = null;
   		try {
 			Class.forName("org.sqlite.JDBC");
 			 con =  DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Pavan kumar.V\\MySQLiteDB");
 		
 		String query = "select Platinum_dis from Carrier where Carrier_id = ? ";
 		
 		ps = con.prepareStatement(query);
         ps.setInt(1, id);
         ResultSet rs = ps.executeQuery();
         while(rs.next())
         {
        	 dis = rs.getInt("Platinum_dis");
         }
   		}
		catch(Exception e)
		{
			System.out.println("There is an error in the Platinum_dis page");
		}
    	 
    	 return dis;
     }
     
     
     
}
