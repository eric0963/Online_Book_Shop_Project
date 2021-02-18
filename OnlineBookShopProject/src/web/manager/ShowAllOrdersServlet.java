package web.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Order;
import service.OrderService;
import service.impl.OrderServiceImpl;


@WebServlet("/ShowAllOrdersServlet")
public class ShowAllOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OrderService os=new OrderServiceImpl();
		List<Order> allOrders = os.showAllOrders();
		request.setAttribute("orders", allOrders);
		request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);
	}

}
