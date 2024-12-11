package controller;
import dao.*;
import bean.*;
import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/user_profile")
public class user_profile extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		ArrayList<Flightbookings> fb = profile_booking_history.find_history(session.getAttribute("session_id").toString());
		req.setAttribute("profile_printing", fb);
		RequestDispatcher rd = req.getRequestDispatcher("userprofile.jsp");
		rd.forward(req, res);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}

}
