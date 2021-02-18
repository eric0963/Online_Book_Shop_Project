package web.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import service.BookService;
import service.impl.BookServiceImpl;


@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		BookService book =new BookServiceImpl();
		//通過BookService查詢所有資料
		List<Book> list = book.queryBooks();
		//把資料保存到資料庫
		request.setAttribute("book", list);
		//轉發頁面
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);			
	}

}
