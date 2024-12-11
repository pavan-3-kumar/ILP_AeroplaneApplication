package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Carrier;
import dao.AdminDao;


@WebServlet("/add")
public class AddCarrierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
//			response.sendRedirect("AddCarrier.jsp");
			Carrier c = new Carrier();
			c.setCarrierName(request.getParameter("carrierName"));
			c.setDiscount30Days(Integer.parseInt(request.getParameter("discount30")));
			c.setDiscount60Days(Integer.parseInt(request.getParameter("discount60")));
			c.setDiscount90Days(Integer.parseInt(request.getParameter("discount90")));
			c.setBulkBookingDiscount(Integer.parseInt(request.getParameter("bulkBookingDiscount")));
			c.setRefund2Days(Integer.parseInt(request.getParameter("refund2")));
			c.setRefund10Days(Integer.parseInt(request.getParameter("refund10")));
			c.setRefund20Days(Integer.parseInt(request.getParameter("refund20")));
			c.setSilverUserDiscount(Integer.parseInt(request.getParameter("silverDiscount")));
			c.setGoldUserDiscount(Integer.parseInt(request.getParameter("goldDiscount")));
			c.setPlatinumUserDiscount(Integer.parseInt(request.getParameter("platinumDiscount")));
			HttpSession session = request.getSession();
			int status = AdminDao.SaveCarrierDetails(c,session);
//			RequestDispatcher rd = request.getRequestDispatcher("carrier.jsp");
//			rd.forward(request, response);
			response.sendRedirect("carrier.jsp");
			
		}
		catch(Exception e) {
			System.out.println("error in addcarrierservlet page");
			//e.printStackTrace();
		}
	}

}