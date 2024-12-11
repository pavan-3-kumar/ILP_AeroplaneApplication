package controller;
import bean.*;
import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/bookingpage")
public class bookingpage extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		combination_user_search com = new combination_user_search();
		HttpSession session = req.getSession();
//		 com = (combination_user_search)session.getAttribute("display_search");

		 String combinationid =  req.getParameter("combinationid").toString();
		 System.out.println(combinationid+"before");
		 ArrayList<combination_user_search>  temp  = (ArrayList<combination_user_search>)session.getAttribute("print_search");
		 for(combination_user_search i : temp)
		 {
			 
			 System.out.println(i.getCombination_ID()+"inside");

			 if(i.getCombination_ID().equals(combinationid))
			 {
				 session.setAttribute("display_search", i);
				 System.out.println("encountered");
				 break;
			 }
		 }
		 //		System.out.println(com.getFlight_id());
//		System.out.println(com.getCarrier_id());
//		System.out.println(com.getOrigin());
//		System.out.println(com.getDestination());
//		System.out.println(com.getAirFare() );
//		System.out.println(com.getDateOfTravel());
//		System.out.println(com.getEconomyClassBookedCount() );
//		System.out.println(com.getExecutiveClassBookedCount());
//		System.out.println(com.getBusinessClassBookedCount() ); 
		 if(session.getAttribute("total_price") != null)
		 session.removeAttribute("total_price");
		res.sendRedirect("book.jsp");
	    
	}

	
	

}