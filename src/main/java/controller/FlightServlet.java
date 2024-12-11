package controller;

import java.io.IOException;
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


@WebServlet("/FlightServlet")
public class FlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<Flight>li=new ArrayList<>();
	    	HttpSession session = request.getSession();
	    	li=AdminDao.getFlightDetails();
	        session.setAttribute("flights", li);
	        response.sendRedirect("flights.jsp");
		}
		catch(Exception e) {
			System.out.println("exception in flight servlet");
		}
	}

}
