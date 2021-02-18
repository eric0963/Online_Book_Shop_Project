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


@WebServlet("/GetBookServlet")
public class GetBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		BookService bs=new BookServiceImpl();
		Book book = bs.queryById(id);
		request.setAttribute("book", book);
		request.setAttribute("pageNo", pageNo);
		request.getRequestDispatcher("/pages/manager/updateBook.jsp?pageNo="+pageNo).forward(request, response);
	}

}
