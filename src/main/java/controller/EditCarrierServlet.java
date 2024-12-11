package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Carrier;
import dao.AdminDao;


@WebServlet("/EditCarrierServlet")
public class EditCarrierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.println("in edit carrier servlet");
		int id = Integer.parseInt(request.getParameter("editcarrier"));
//		System.out.println(id);
		Carrier c = AdminDao.getCarrierById(id);
//		System.out.println("In edit carrier servlet the carrier id is"+c.getId());
//		System.out.println("In edit carrier servlet the carrier 30days is"+c.getDiscount30Days());

		request.setAttribute("carrier", c);
		RequestDispatcher rs = request.getRequestDispatcher("EditCarrier.jsp");
		rs.forward(request, response);
	}

}
