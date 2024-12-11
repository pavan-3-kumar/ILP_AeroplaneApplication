package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/signout")
public class signout extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
         
		HttpSession session = req.getSession();
       session.removeAttribute("session_id");
       session.removeAttribute("print_search");
       session.removeAttribute("category_of_user");
       
       session.removeAttribute("display_search");
       res.sendRedirect("Home.jsp");
	
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}

}