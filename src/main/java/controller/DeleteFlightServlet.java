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

/**
 * Servlet implementation class DeleteFlightServlet
 */
@WebServlet("/DeleteFlightServlet")
public class DeleteFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("deleteflight"));
		try {
			Connection con=AdminDao.getConnection();
			String deleteQuery = "delete from Flight where Flight_id=?";
			
				PreparedStatement statement = con.prepareStatement(deleteQuery);
				statement.setInt(1,id);
				statement.executeUpdate();
			
			HttpSession session = request.getSession();
			List<Flight> li = new ArrayList<>();
			li = AdminDao.getFlightDetails();
			session.setAttribute("flights", li);
			response.sendRedirect("flights.jsp");
		}
		catch(Exception e) {
			System.out.println("in delete flight servlet");
			System.out.println(e);
		}
	}

}
