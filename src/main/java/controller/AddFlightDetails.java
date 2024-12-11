package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Flight;
import dao.AdminDao;


@WebServlet("/AddFlightDetails")
public class AddFlightDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in original add flight details servlet");
		int id = (Integer.parseInt(request.getParameter("carrierId")));
		System.out.println("Carrier id selection is"+id);
		Flight f = new Flight();
		f.setFlightId(Integer.parseInt(request.getParameter("flightid")));
		
		f.setCarrierId(id);
		f.setAirfare(Integer.parseInt(request.getParameter("airfare")));
		f.setOrigin((String)request.getParameter("origin"));
		f.setDestination((String)request.getParameter("destination"));
		f.setSeatcapacityeconomyclass(Integer.parseInt(request.getParameter("economyclass")));
		f.setSeatcapacitybusinessclass(Integer.parseInt(request.getParameter("businessclass")));
		f.setSeatcapacityexecuteclass(Integer.parseInt(request.getParameter("executiveclass")));
		HttpSession session = request.getSession();
		int status = AdminDao.saveFlightDetails(f,session);
		
		if(status>0) {
			response.sendRedirect("flights.jsp");
		}
		else {
			System.out.println("No update in flight details");
		}
		
	}


}
