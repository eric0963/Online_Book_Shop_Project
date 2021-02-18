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


@WebServlet("/PageByPriceServlet")
public class PageByPriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pageNo = utility.GetNumber.parseInt(request.getParameter("pageNo"), 0);
		int pageSize = utility.GetNumber.parseInt(request.getParameter("pageSize"), 4);
		int min = utility.GetNumber.parseInt(request.getParameter("min"), 0);
		int max = utility.GetNumber.parseInt(request.getParameter("max"), Integer.MAX_VALUE);
		
		BookService bs=new BookServiceImpl();
		Page<Book> page = bs.pageByPrice(pageNo, pageSize, min, max);
		
		StringBuilder sb=new StringBuilder("PageByPriceServlet");
		if(request.getParameter("min")!=null) {
			sb.append("?min=").append(request.getParameter("min"));
		}
		if(request.getParameter("max")!=null) {
			sb.append("&max=").append(request.getParameter("max"));
		}
		
		page.setUrl(sb.toString());
		
		request.setAttribute("page", page);
		request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
	}

}
