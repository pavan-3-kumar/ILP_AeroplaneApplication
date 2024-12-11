package controller;

import java.io.IOException;
import java.sql.SQLException;
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

@WebServlet("/UpdateFlightDetails")
public class UpdateFlightDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Flight f = new Flight();
		f.setFlightId(Integer.parseInt(request.getParameter("flightid")));
		f.setCarrierId(Integer.parseInt(request.getParameter("carrierid")));
		f.setAirfare(Integer.parseInt(request.getParameter("airfare")));
		f.setOrigin((String)request.getParameter("origin"));
		f.setDestination((String)request.getParameter("destination"));
		f.setSeatcapacityeconomyclass(Integer.parseInt(request.getParameter("economyclass")));
		f.setSeatcapacitybusinessclass(Integer.parseInt(request.getParameter("businessclass")));
		f.setSeatcapacityexecuteclass(Integer.parseInt(request.getParameter("executiveclass")));
		HttpSession session = request.getSession();
		int status=AdminDao.updateFlightDetailsById(f,session);
		if(status>0) {
			//List<Carrier> li = new ArrayList<>();
			try {
				response.sendRedirect("flights.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			System.out.println("Status is 0");
		}
	}

}
