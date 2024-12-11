package controller;
import bean.*;
import dao.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/confirm_booking")
public class confirm_booking extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		ArrayList<Integer> temp = (ArrayList<Integer>)session.getAttribute("tousein_confirm");
		int economyclassseats =temp.get(1);		
		System.out.println("1"+economyclassseats);
		int businessclassseats =temp.get(2);	
		System.out.println("3"+businessclassseats);
		int executiveclassseats =temp.get(3);
		System.out.println("4"+executiveclassseats);
		int flightid = temp.get(0);
		System.out.println("5"+flightid);
		
		String userid = session.getAttribute("session_id").toString();
		System.out.println("6"+userid);
		
	   int num_of_seats = economyclassseats + businessclassseats + executiveclassseats;
	   String date_of_travel  = (session.getAttribute("dateoftravel")).toString();
	   System.out.println("7"+date_of_travel);
	  session.removeAttribute("dateoftravel");
	  
	   System.out.println(req.getParameter("finalamount"));
	   int finalamount = Integer.parseInt(req.getParameter("finalamount"));
	   System.out.println("8"+finalamount);
	  ArrayList<Integer> values = new ArrayList<>();
	  Collections.addAll(values, economyclassseats,businessclassseats,executiveclassseats,flightid,num_of_seats,finalamount);
//	 System.out.println("printing list");
	  for(Integer i : values)
	 {
		 System.out.println(i);
	 }
	  register_booking.register(values , userid , date_of_travel,session);
	  session.removeAttribute("print_search");
	 res.sendRedirect("booking_completed_popup.jsp");
	  
	}

}
