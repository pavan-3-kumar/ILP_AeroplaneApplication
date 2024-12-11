package controller;
import dao.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Flightbookings;


@WebServlet("/delete_booking")
public class delete_booking extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int flightid = Integer.parseInt(req.getParameter("flightid"));
		String DOT = req.getParameter("DOT").toString();
		int bookingid = Integer.parseInt(req.getParameter("bookingid"));
		
		register_booking.delete_booking(flightid, DOT,bookingid);
//		System.out.print
		
		HttpSession session = req.getSession();
		ArrayList<Flightbookings> fb = profile_booking_history.find_history(session.getAttribute("session_id").toString());
		req.setAttribute("profile_printing", fb);
		RequestDispatcher rd = req.getRequestDispatcher("userprofile.jsp");
		rd.forward(req, res);
		
		
	}

}
