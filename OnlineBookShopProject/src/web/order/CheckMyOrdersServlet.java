package web.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Order;
import model.User;
import service.OrderService;
import service.impl.OrderServiceImpl;


@WebServlet("/CheckMyOrdersServlet")
public class CheckMyOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = (User) request.getSession().getAttribute("user");
		Integer id = user.getId();
		OrderService os=new OrderServiceImpl();
		List<Order> myOrders = os.showMyOrder(id);
		
		if(myOrders!=null) {
			request.setAttribute("order", myOrders);
			request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
			return;
		}
		
	}

}
