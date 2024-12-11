package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Carrier;
import dao.AdminDao;


@WebServlet("/UpdateCarrierServlet")
public class UpdateCarrierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Carrier c = new Carrier();
		System.out.println("in update servlet");
		c.setId(Integer.parseInt(request.getParameter("carrierId")));
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
		int status=AdminDao.updateCarrierDetailsById(c,session);
		if(status>0) {
			List<Carrier> li = new ArrayList<>();
			try {
				li = AdminDao.getCarrierDetails();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//session.setAttribute("carriers", li);
			response.sendRedirect("carrier.jsp");
		}
		else {
			System.out.println("Status is 0");
		}
			
		}
}

