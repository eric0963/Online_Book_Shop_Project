package web.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OrderItem;
import service.OrderService;
import service.impl.OrderServiceImpl;


@WebServlet("/ShowOrderDetailServlet")
public class ShowOrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String orderId = request.getParameter("orderId");
		
		OrderService os=new OrderServiceImpl();
		List<OrderItem> orderDetail = os.showOrderDetail(orderId);
		request.setAttribute("orderDetail", orderDetail);
		request.getRequestDispatcher("/pages/order/orderDetail.jsp").forward(request, response);
	}

}
