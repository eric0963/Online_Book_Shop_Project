package web.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cart;
import model.User;
import service.OrderService;
import service.impl.OrderServiceImpl;
import utility.JDBCUtility;


@WebServlet("/CreateOrderServlet")
public class CreateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OrderService os=new OrderServiceImpl();
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		User user = (User) request.getSession().getAttribute("user");
		
		Integer id = user.getId();
		
		
		
		String orderId = os.createOrder(cart, id);
		
		request.getSession().setAttribute("orderId", orderId);
		response.sendRedirect(request.getContextPath()+"/pages/cart/checkout.jsp");
	}

}
