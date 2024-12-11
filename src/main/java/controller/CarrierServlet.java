package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import com.Carrier.java;
import javax.servlet.http.HttpSession;

import bean.Carrier;
import dao.AdminDao;

@WebServlet("/carrier")
public class CarrierServlet extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        	List<Carrier>li=new ArrayList<>();
        	HttpSession session = request.getSession();
        	li=AdminDao.getCarrierDetails();
            session.setAttribute("carriers", li);
            response.sendRedirect("carrier.jsp");
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        // Set list as request attribute and forward to JSP
    }
}