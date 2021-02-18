package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.JDBCUtility;


@WebFilter(filterName = "/TransactionFilter", urlPatterns = "")
public class TransactionFilter implements Filter {

    public TransactionFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
//		HttpServletRequest req=(HttpServletRequest) request;
//		HttpServletResponse res=(HttpServletResponse) response;
//		
//		try {
//			chain.doFilter(request, response);
//			JDBCUtility.commitAndClose();
//		}catch(Exception e) {
//			JDBCUtility.rollbackAndClose();
//			res.sendRedirect(req.getContextPath()+"/pages/error/error.jsp");
//		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
