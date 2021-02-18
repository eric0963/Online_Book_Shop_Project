package web.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.Cart;
import model.CartItem;
import service.BookService;
import service.impl.BookServiceImpl;


@WebServlet("/AddItemServlet")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		BookService bs=new BookServiceImpl();
		Book book = bs.queryById(id);
		//將獲取的參數轉成CartItem
		CartItem cartItem=new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
		//為避免新增一個商品就新增一台購物車
		//在新增購物車時先利用session確定是否已經有新增過了
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(cart==null) {
			cart=new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		cart.addItem(cartItem);
		response.sendRedirect(request.getHeader("referer"));
		
		request.getSession().setAttribute("newBook",cartItem.getName());
	}

}
