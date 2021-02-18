package web.book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import service.BookService;
import service.impl.BookServiceImpl;


@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		int sales = Integer.parseInt(request.getParameter("sales"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		int pageNo = utility.GetNumber.parseInt(request.getParameter("pageNo"), 0);
		//使跳轉後的頁面始終都是最新的一頁
		pageNo+=1;
		
		
		
		BookService bs=new BookServiceImpl();
	
		bs.add(new Book(null, name, price, author, sales, stock, null));
		
		response.sendRedirect(request.getContextPath()+"/PageServlet?pageNo="+pageNo);
		
		
		
	}

}
