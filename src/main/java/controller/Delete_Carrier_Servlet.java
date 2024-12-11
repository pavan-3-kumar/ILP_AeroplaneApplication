package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Carrier;
import bean.Flight;
import dao.AdminDao;


@WebServlet("/DeleteCarrierServlet")
public class Delete_Carrier_Servlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String selected = (String)request.getParameter("deletecarrier");
		
		if(selected!=null) {
			System.out.println(selected);
			
			try {
				Connection con=AdminDao.getConnection();
				String deleteQuery = "delete from Carrier where Carrier_id=?";
				String deleteflight = "delete from Flight where Carrier_id=?;";
				PreparedStatement st = con.prepareStatement(deleteflight);
				st.setString(1,selected);
				st.executeUpdate();
				PreparedStatement statement = con.prepareStatement(deleteQuery);
				statement.setString(1,selected);
				statement.executeUpdate();
				
				HttpSession session = request.getSession();
				List<Flight>list = AdminDao.getFlightDetails();
				session.setAttribute("flights",list);
				//HttpSession session = request.getSession();
				List<Carrier> li = new ArrayList<>();
				li = AdminDao.getCarrierDetails();
				session.setAttribute("carriers", li);
				response.sendRedirect("carrier.jsp");
			}
			catch(Exception e) {
				System.out.println("In delete catch block");
				System.out.println(e);
			}
		}
		else {
			System.out.println("selected is null");
		}
	}

}
