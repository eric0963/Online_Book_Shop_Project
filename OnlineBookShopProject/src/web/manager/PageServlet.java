package web.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.Page;
import service.BookService;
import service.impl.BookServiceImpl;


@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int pageNo = utility.GetNumber.parseInt(request.getParameter("pageNo"), 0);
		int pageSize = utility.GetNumber.parseInt(request.getParameter("pageSize"), 4);
		
		BookService bs=new BookServiceImpl();
		Page<Book> page = bs.page(pageNo, pageSize);
		page.setUrl("PageServlet?");
		request.setAttribute("page", page);
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);		
	}

}
