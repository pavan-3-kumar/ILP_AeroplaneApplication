package controller;

import dao.*;

import java.io.IOException;
import java.text.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/calculate_price")
public class calculate_price extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		System.out.println("this is calculate_price "+session.getAttribute("session_id").toString());
		String category_of_user = find_price.calculate(session.getAttribute("session_id").toString());
		System.out.println(category_of_user);
		session.setAttribute("category_of_user", category_of_user);
		int economyclassseats =Integer.parseInt(req.getParameter("EconomyClass_Seats"));		
		int businessclassseats =Integer.parseInt(req.getParameter("BusinessClass_Seats"));		
		int executiveclassseats =Integer.parseInt(req.getParameter("ExecutiveClass_Seats"));
		System.out.println("after all classes : "+req.getParameter("airfare"));

		ArrayList<Integer> temp = new ArrayList<>();
        temp.add(Integer.parseInt(req.getParameter("flightid")));
        temp.add(economyclassseats);
        temp.add(businessclassseats);
        temp.add(executiveclassseats);
        session.setAttribute("tousein_confirm", temp);
		session.setAttribute("dateoftravel",req.getParameter("DOT").toString());
		int Airfare = Integer.parseInt(req.getParameter("airfare"));
		long price =0 ;
		price  = (economyclassseats * Airfare) + (businessclassseats *2 * Airfare) + (executiveclassseats* 5 * Airfare);
	    long temp_price = price;
	    price =0 ;
		int silver =0  ,gold = 0 , platinum =0 ;
		if(category_of_user.equals("Silver"))
	    {
			silver = find_price.silver_disc(Integer.parseInt(req.getParameter("carrierid")));
	    	price += silver;
	    	
	    }
		else if(category_of_user.equals("Gold"))
	    {
	    	gold = find_price.gold_disc(Integer.parseInt(req.getParameter("carrierid")));
            price += gold;
	    	
	    }
		else {
			platinum = find_price.Platinum_disc(Integer.parseInt(req.getParameter("carrierid")));
            price += platinum;
		}
	    
		System.out.println("this is befor date");
	    String DOT = req.getParameter("DOT");
	    long diffInDays =0 ;
	    SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
        try {
			Date tableDate = dateformat.parse(DOT);
			Date currentdate = new Date();
			
			 // Calculate the difference in milliseconds
            long diffInMillis = tableDate.getTime() - currentdate.getTime();

            // Convert the difference in milliseconds to days
            diffInDays  = TimeUnit.MILLISECONDS.toDays(diffInMillis);

            // Output the difference in days
            System.out.println("Difference in days: " + diffInDays);
          
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("this is error in calculate_price class ");
			e.printStackTrace();
		}
         
        int disc =0 ;
        int thirty =0 , sixty =0 , nintey =0 , bulk =0 ; 
        // Advance booking discount 
         
         try {
        	 if(diffInDays >= 90)
        {
        	 disc = find_price.Nintey_advance_booking_disc(Integer.parseInt(req.getParameter("carrierid")));
        	price += disc;
        	 thirty = disc; 
        }
        else if(diffInDays >= 60)
        {
        	 disc  = find_price.sixty_advance_booking_disc(Integer.parseInt(req.getParameter("carrierid")));
        	 price += disc;
        	 sixty = disc ;
        }
        else if(diffInDays >= 30)
        {
        	 disc = find_price.thirty_advance_booking_disc(Integer.parseInt(req.getParameter("carrierid")));
        	 price += disc;
        	 nintey = disc ;	
        }
        
     
	    
        // bulk_discount if tickets >= 10 
	    if((executiveclassseats+ businessclassseats+ economyclassseats)  >= 10)
	    {
	    	disc = find_price.bulk_disc(Integer.parseInt(req.getParameter("carrierid")));
	       price += disc;
          bulk = disc;
        }
         }
         catch(Exception e)
         {
        	 System.out.println("this is exception in calculate_price");
         }
         System.out.println(price+"--"+temp_price);
	    ArrayList<Integer> price_details = new ArrayList<>();

	     price_details.add((int)(temp_price * (thirty))/100);
	     price_details.add((int)(temp_price * (sixty))/100);
	     price_details.add((int)(temp_price * (nintey))/100);
	     price_details.add((int)(temp_price * (bulk))/100);
	     price_details.add((int)(temp_price * (silver))/100);
	     price_details.add((int)(temp_price * (gold))/100);
	     price_details.add((int)(temp_price * (platinum))/100);
	     price_details.add((int)temp_price);

	     price_details.add((int) (temp_price -((temp_price *price)/100)) );
	     for(Integer i : price_details)
	     {
	    	 System.out.println(i);
	     }
	    session.setAttribute("total_price",price_details);
	    System.out.println(temp_price +"  " +price);
	    
	    
	    res.sendRedirect("book.jsp");
	    
	    
	  
	}

}
