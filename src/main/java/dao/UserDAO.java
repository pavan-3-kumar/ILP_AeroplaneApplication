package dao;

import java.sql.*;
import java.util.*;
import bean.User;
public class UserDAO {

	public UserDAO()
	{
		
	}
	public static String Authenticate(String name , String pass)throws SQLException
	{
		
		int c =0 ;
		String ans = "";

		try {	
//			Connection con = null;
			System.out.println("this is search 1");
			Connection con = null;
			PreparedStatement ps  = null;
			Class.forName("org.sqlite.JDBC");
			System.out.println("this is search 2");

			con =  DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Pavan kumar.V\\MySQLiteDB");
		
				System.out.println("this is search 3");
     
		
		String query = "select User_Id from User where User_name = ? and Password = ? ";
		
		ps = con.prepareStatement(query);
		ps.setString(1, name);
		ps.setString(2, pass);
		System.out.println("this is search 4");

				ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			c = 1;
			 ans =  rs.getString("User_Id");
		}
		
		System.out.println("this is search 5");

		
		if(ps!= null)ps.close();
		if(con != null)con.close();
		
		}
		catch(Exception e)
		{
			  System.out.println("Error in USERDAO_authenticate class");
		}

		return ans;
	}
	
	public static int add(User user) throws SQLException
	{
		
		Connection con = null;
		int count =0 ; 
//		System.out.println("this is before try");

		try {	
//			Connection con = null;
//			System.out.println("this is after try and before classforname");
			Class.forName("org.sqlite.JDBC");
			
			con =  DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Pavan kumar.V\\MySQLiteDB");
	     
        String na = "pavankumar";
        int age = 10 , year = 2030;
		String a = "insert into User values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement ps = con.prepareStatement(a);
		
//       System.out.println(user.getUser_Id());
        ps.setString(1, user.getUser_Id());
		ps.setString(2,user.getUser_name() );
		ps.setString(3, user.getPassword());
		ps.setString(4, user.getRole());
		ps.setString(5, user.getCategory());
		ps.setString(6,user.getPhone());
		ps.setString(7,user.getEmail_id());
		ps.setString(8, user.getAddress1());
		ps.setString(9, user.getCity());
		ps.setString(10, user.getState());
		ps.setString(11, user.getCountry());
		ps.setString(12, user.getZipcode());
		ps.setString(13, user.getDate());
		
		 count = ps.executeUpdate();
		 ps.close();
		 con.close();
		}
		catch(Exception e){
		  System.out.println("Error in UserDAO class "+ e);
		}
		
		
		
		
		
		return count;
	}
	
	
	
//	check(Role in ('Admin','Customer'))
//	check(CustomerCategory in ('Silver','Gold','Platinum'))
//	
	
}