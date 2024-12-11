package controller;
import dao.UserDAO;
import bean.User;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet  {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	    	User user = new User();
	    	user.setRole(req.getParameter("Role").toString());
	    	user.setCategory(req.getParameter("Category").toString());
			user.setUser_name(req.getParameter("name").toString());
			user.setPassword(req.getParameter("pass").toString());
			user.setPhone(req.getParameter("phone").toString());
			user.setEmail_id(req.getParameter("emailid").toString());
			user.setAddress1(req.getParameter("address1").toString());
			user.setCity(req.getParameter("city").toString());
			user.setState(req.getParameter("state").toString());
			user.setCountry(req.getParameter("country").toString());
		    user.setZipcode(req.getParameter("zipcode").toString());
		    user.setDate(req.getParameter("DOB").toString());
		    
//		    System.out.println("before"+user.toString());
		    int rows_added = 0 ;
		    try {
//				System.out.println("this is Register before servlet");
		    	rows_added= UserDAO.add(user);
//				System.out.println("this is Register after servlet");


			
		} 
	    catch (SQLException e) {	
			e.printStackTrace();
		}
	    
		    if(rows_added > 0)
			{
				res.getWriter().println("updated rows "+rows_added);
			  				
				res.sendRedirect("sign_in.jsp");
			}
			else {
				res.sendRedirect("sign_up.jsp");
			}
	    
	    
	}

}
