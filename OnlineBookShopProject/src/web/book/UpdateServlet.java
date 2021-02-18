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


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String img_path = request.getParameter("img_path");
		int id = Integer.parseInt(request.getParameter("id"));
		int price = Integer.parseInt(request.getParameter("price"));
		int sales = Integer.parseInt(request.getParameter("sales"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		
		
		BookService bs=new BookServiceImpl();
		bs.update(new Book(id, name, price, author, sales, stock, img_path ));
		response.sendRedirect(request.getContextPath()+"/PageServlet?pageNo="+pageNo);
	}

}
