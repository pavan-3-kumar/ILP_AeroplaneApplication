package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Flight_sched;
import bean.Flights_details;
import bean.combination_user_search;
import dao.Search_flights;


@WebServlet("/Searchflight")
public class Searchflight extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String origin = req.getParameter("origin").toString();
    	String destination = req.getParameter("destination").toString();
    	String date =req.getParameter("journey_date").toString();
    	
//    	TreeMap<Flights_details,Flight_sched> flights = Search_flights.search(origin , destination , date) ; 
    	ArrayList<combination_user_search> flights = (ArrayList<combination_user_search>)Search_flights.search(origin , destination , date) ;
		
    	HttpSession session = req.getSession();
		if(session.getAttribute("print_search") != null)
			session.removeAttribute("print_search");
		
         session.setAttribute("print_search", flights);
         
         for(combination_user_search i : (ArrayList<combination_user_search>)session.getAttribute("print_search"))
 		{
 			System.out.println(i.getFlight_id()+" "+i.getCombination_ID());
 		}
//         session.setAttribute("origin", origin);
//         session.setAttribute("destination", destination);
//         session.setAttribute("date", date);
         
         
         
    
        res.sendRedirect("User_page.jsp");
	}

}
