package web.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.OrderService;
import service.impl.OrderServiceImpl;


@WebServlet("/SendOrderServlet")
public class SendOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int status = Integer.parseInt(request.getParameter("status"));
		String orderId = request.getParameter("id");
		OrderService os=new OrderServiceImpl();
		
		if(0==status) {
			os.sendOrder(orderId, 1);
			response.sendRedirect(request.getHeader("referer"));
		}else if(1==status) {
			os.sendOrder(orderId, 2);
			response.sendRedirect(request.getHeader("referer"));
		}
		
	}

}
