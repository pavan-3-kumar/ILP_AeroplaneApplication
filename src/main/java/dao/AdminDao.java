package dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import bean.Carrier;
import bean.Flight;
public class AdminDao {
      public static Connection getConnection() {
    	  Connection con=null;
    	  try {
    		  Class.forName("org.sqlite.JDBC");
    		  con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Pavan kumar.V\\MySQLiteDB");
    	  }
    	  catch(Exception e) {
    		  System.out.println(e);
    	  }
    	  return con;
      }
      public static List<Carrier> getCarrierDetails() throws SQLException{  
          List<Carrier> list=new ArrayList<>();  
            ResultSet rs = null;
            Connection con = null;
            PreparedStatement ps= null;
            
          try{  
               con=AdminDao.getConnection();  
               ps=con.prepareStatement("select * from Carrier");  
               rs=ps.executeQuery();  
               while(rs.next()){  
            	  Carrier carrier = new Carrier();
                  carrier.setId(rs.getInt("Carrier_id"));
                  carrier.setCarrierName(rs.getString("Carrier_name"));
                  carrier.setDiscount30Days(rs.getInt("Discount_Thirty_AdvanceBooking"));
                  carrier.setDiscount60Days(rs.getInt("Discount_Sixty_AdvanceBooking"));
                  carrier.setDiscount90Days(rs.getInt("Discount_Nintey_AdvanceBooking"));
                  carrier.setBulkBookingDiscount(rs.getInt("Bulk_dis"));
                  carrier.setRefund2Days(rs.getInt("Refund_twodays_TravelDate"));
                  carrier.setRefund10Days(rs.getInt("Refund_tendays_TravelDate"));
                  carrier.setRefund20Days(rs.getInt("Refund_twentydays_TravelDate"));
                  carrier.setSilverUserDiscount(rs.getInt("Silver_dis"));
                  carrier.setGoldUserDiscount(rs.getInt("Gold_dis"));
                  carrier.setPlatinumUserDiscount(rs.getInt("Platinum_dis"));
                  list.add(carrier); 
              }
             
          }
          catch(Exception e){
        	  System.out.println("error in get carrier details method");
        	  e.printStackTrace();
          }  
          rs.close();
          ps.close();
          con.close(); 
        
          return list;  
      }
      
      public static int SaveCarrierDetails(Carrier c,HttpSession session) {
    	  int rows=0;
    	  try {
    		  Carrier carrier = c;
        	  Connection con = AdminDao.getConnection();
        	  PreparedStatement ps = con.prepareStatement("insert into Carrier (Carrier_name,Discount_Thirty_AdvanceBooking,Discount_Sixty_AdvanceBooking,Discount_Nintey_AdvanceBooking,Bulk_dis,Refund_twodays_TravelDate,Refund_tendays_TravelDate,Refund_twentydays_TravelDate,Silver_dis,Gold_dis,Platinum_dis) values(?,?,?,?,?,?,?,?,?,?,?)");
        	  ps.setString(1, carrier.getCarrierName());
        	  ps.setInt(2, carrier.getDiscount30Days());
        	  ps.setInt(3, carrier.getDiscount60Days());
        	  ps.setInt(4, carrier.getDiscount90Days());
        	  ps.setInt(5, carrier.getBulkBookingDiscount());
        	  ps.setInt(6, carrier.getRefund2Days());
        	  ps.setInt(7, carrier.getRefund10Days());
        	  ps.setInt(8, carrier.getRefund20Days());
        	  ps.setInt(9, carrier.getSilverUserDiscount());
        	  ps.setInt(10, carrier.getGoldUserDiscount());
        	  ps.setInt(11, carrier.getPlatinumUserDiscount());
        	  rows = ps.executeUpdate();
        	  List<Carrier>li=new ArrayList<>();
          	li=AdminDao.getCarrierDetails();
//          	HttpSession session = request.getSession();
        	  session.setAttribute("carriers", li);
        	  ps.close();
        	  con.close();
    	  }
    	  catch(Exception e){
    		  System.out.println("error in save carrier details method");
    	  }
    	  return rows;
      }
      
      public static Carrier getCarrierById(int id) {
    	  Carrier c = new Carrier();
    	  try {
    		  Connection con = AdminDao.getConnection();
    		  PreparedStatement st = con.prepareStatement("select * from Carrier where Carrier_id=?;");
    		  System.out.println("in get carrierby id method carrier id value"+id);
    		  st.setInt(1, id);
    		  ResultSet rs=st.executeQuery();
    		  c.setId(rs.getInt(1));
    		  c.setCarrierName(rs.getString(2));
    		  System.out.println("carrier name respected to that id"+c.getCarrierName());
    		  c.setDiscount30Days(rs.getInt(3));
    		  c.setDiscount60Days(rs.getInt(4));
    		  c.setDiscount90Days(rs.getInt(5));
    		  c.setBulkBookingDiscount(rs.getInt(6));
    		  c.setRefund2Days(rs.getInt(7));
    		  c.setRefund10Days(rs.getInt(8));
    		  c.setRefund20Days(rs.getInt(9));
    		  c.setSilverUserDiscount(rs.getInt(10));
    		  c.setGoldUserDiscount(rs.getInt(11));
    		  c.setPlatinumUserDiscount(rs.getInt(12));
    		  st.close();
    		  con.close();
    	  }
    	  catch(Exception e) {
    		  System.out.println("In getcarrier by id catch block");
    	  }
    	  return c;
      }
      
      public static int updateCarrierDetailsById(Carrier carrier,HttpSession session) {
    	  int status=0;
    	  try {
    		  Connection con = AdminDao.getConnection();
    		  if(con==null) {
    			  System.out.println("failed to get connection");
    			  return 0;
    		  }
    		  
    		  PreparedStatement ps = con.prepareStatement("update Carrier set Carrier_name=?,Discount_Thirty_AdvanceBooking=?,Discount_Sixty_AdvanceBooking=?,Discount_Nintey_AdvanceBooking=?,Bulk_dis=?,Refund_twodays_TravelDate=?,Refund_tendays_TravelDate=?,Refund_twentydays_TravelDate=?,Silver_dis=?,Gold_dis=?,Platinum_dis=? where Carrier_id=?");
    		  con.setAutoCommit(true);
    		  ps.setString(1, carrier.getCarrierName());
    		  //System.out.println(carrier.getCarrierName());
    		  //ResultSet s = pt.executeQuery();
    		  //System.out.println(s.getInt(2)+"hi");
        	  ps.setInt(2, carrier.getDiscount30Days());
        	  ps.setInt(3, carrier.getDiscount60Days());
        	  ps.setInt(4, carrier.getDiscount90Days());
        	  ps.setInt(5, carrier.getBulkBookingDiscount());
        	  ps.setInt(6, carrier.getRefund2Days());
        	  ps.setInt(7, carrier.getRefund10Days());
        	  ps.setInt(8, carrier.getRefund20Days());
        	  ps.setInt(9, carrier.getSilverUserDiscount());
        	  ps.setInt(10, carrier.getGoldUserDiscount());
        	  ps.setInt(11, carrier.getPlatinumUserDiscount());
    		  ps.setInt(12,carrier.getId());
    		  status=ps.executeUpdate();
    		  System.out.println("Status: "+status);
    		  List<Carrier>li=new ArrayList<>();
    		  li=AdminDao.getCarrierDetails();
    		  session.setAttribute("carriers", li);
    		  ps.close();
    		  con.close();
    		  
    	  }
    	  catch(Exception e) {
    		  System.out.println(e);
    	  }
    	  return status;
      }
      
      public static List<Flight> getFlightDetails(){
    	  List<Flight> list=new ArrayList<>();  
          ResultSet rs = null;
          Connection con = null;
          PreparedStatement ps= null;
          try {
        	  con=AdminDao.getConnection();  
              ps=con.prepareStatement("select * from Flight order by Carrier_id;");  
              rs=ps.executeQuery();
              while(rs.next()) {
            	  Flight f = new Flight();
            	  f.setFlightId(rs.getInt(1));
            	  f.setCarrierId(rs.getInt(2));
            	  f.setOrigin(rs.getString(3));
            	  f.setDestination(rs.getString(4));
            	  f.setAirfare(rs.getInt(5));
            	  f.setSeatcapacityeconomyclass(rs.getInt(6));
            	  f.setSeatcapacitybusinessclass(rs.getInt(7));
            	  f.setSeatcapacityexecuteclass(rs.getInt(8));
            	  list.add(f);
              }
              rs.close();
              ps.close();
              con.close();
          }
          catch(Exception e) {
        	  System.out.println("error in get all flight details");
          }
                  
          return list; 
      }
      
      public static int saveFlightDetails(Flight f,HttpSession session) {
    	  //ResultSet rs = null;
          Connection con = null;
          PreparedStatement ps= null;
          int rows=0;
          List<Flight>list = new ArrayList<>();
          try {
        	  con =AdminDao.getConnection();
        	  String query = "insert into Flight (Flight_id,Carrier_id,Origin,Destination,AirFare,Seat_cap_Economy,Seat_cap_Business,Seat_cap_Executive) values(?,?,?,?,?,?,?,?);";
        	  ps=con.prepareStatement(query);
        	  ps.setInt(1, f.getFlightId());
        	  ps.setInt(2, f.getCarrierId());
        	  ps.setString(3, f.getOrigin());
        	  ps.setString(4,f.getDestination());
        	  ps.setInt(5, f.getAirfare());
        	  ps.setInt(6, f.getSeatcapacityeconomyclass());
        	  ps.setInt(7, f.getSeatcapacitybusinessclass());
        	  ps.setInt(8, f.getSeatcapacityexecuteclass());
        	  rows=ps.executeUpdate();
        	  list=AdminDao.getFlightDetails();
        	  session.setAttribute("flights", list);
        	  ps.close();
        	  con.close();
          }
          catch(Exception e) {
        	  System.out.println("in save flight details");
          }
          return rows;
      }
      
      public static Flight getFlightById(int id) {
    	  Connection con = AdminDao.getConnection();
    	  PreparedStatement ps = null;
    	  ResultSet rs = null;
    	  Flight f = new Flight();
    	  System.out.println(id);
    	  try {
    		  ps=con.prepareStatement("select * from Flight where Flight_id=?;");
    		  ps.setInt(1, id);
    		  System.out.println(id);
    		  rs=ps.executeQuery();
    		  f.setFlightId(rs.getInt(1));
    		  f.setCarrierId(rs.getInt(2));
    		  f.setOrigin(rs.getString(3));
    		  f.setDestination(rs.getString(4));
    		  f.setAirfare(rs.getInt(5));
    		  f.setSeatcapacityeconomyclass(rs.getInt(6));
    		  f.setSeatcapacitybusinessclass(rs.getInt(7));
    		  f.setSeatcapacityexecuteclass(rs.getInt(8));
    		  rs.close();
    		  ps.close();
    		  con.close();
    	  }
    	  catch(Exception e) {
    		  System.out.println(e);
    	  }
    	  return f;
      }
	public static int updateFlightDetailsById(Flight f, HttpSession session) {
		// TODO Auto-generated method stub
		Connection con =AdminDao.getConnection();
		PreparedStatement ps =null;
		int status=0;
		try {
			ps=con.prepareStatement("update Flight set Origin=?,Destination=?,AirFare=?,Seat_cap_Economy=?,Seat_cap_Business=?,Seat_cap_Executive=? where Flight_id=? and Carrier_id=?;");
			ps.setString(1, f.getOrigin());
			ps.setString(2, f.getDestination());
			ps.setInt(3, f.getAirfare());
			ps.setInt(4, f.getSeatcapacityeconomyclass());
			ps.setInt(5, f.getSeatcapacitybusinessclass());
			ps.setInt(6, f.getSeatcapacityexecuteclass());
			ps.setInt(7, f.getFlightId());
			ps.setInt(8, f.getCarrierId());
			status = ps.executeUpdate();
			List<Flight>list = AdminDao.getFlightDetails();
			session.setAttribute("flights", list);
			ps.close();
			con.close();
		}
		catch(Exception e) {
			System.out.println("in update flight details by id");
			System.out.println(e);
		}
		return status;
	}
      
      
      
      
}