package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.User;
import dao.UserDAO;

@WebServlet("/Login")
public class Login extends HttpServlet {
	 
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.sendRedirect("sign_in.jsp");
	

	}

 
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		String name = req.getParameter("name").toString();
		String pass = req.getParameter("pass").toString();
		
		String result="";
		try {
			if(name.equals("admin") && pass.equals("admin"))
			{
				System.out.println("Admin logged in");
				session.setAttribute("session_id","admin");				
				res.sendRedirect("Admin_home.jsp");
				return ; 
			}
			result = UserDAO.Authenticate(name, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result.length() > 0)
		{
			
			session.setAttribute("session_id", result);
//			req.setAttribute(name, pass);
			System.out.println("before res.sendRedirect(\"User_page.jsp\")");
			res.sendRedirect("User_page.jsp");
		}
		else {
			res.sendRedirect("sign_in.jsp");
		}
		
		
	} 

}