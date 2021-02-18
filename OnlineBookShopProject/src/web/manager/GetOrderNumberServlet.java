package web.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Order;
import model.OrderItem;
import service.OrderService;
import service.impl.OrderServiceImpl;


@WebServlet("/GetOrderNumberServlet")
public class GetOrderNumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String orderId = request.getParameter("orderNumber");
		OrderService os=new OrderServiceImpl();
		List<Order> orders = os.queryOrdersByOrderId(orderId);
		
		if("".equals(orderId)) {
			request.getRequestDispatcher("/ShowAllOrdersServlet").forward(request, response);
		}
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);
	}

}
