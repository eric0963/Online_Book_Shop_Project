package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

//整合login & registu頁面
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String code = request.getParameter("code");		
		
		if("login".equals(action)) {
			
			UserService service=new UserServiceImpl();
			User user = service.login(username, password);
			
			//確認是否管理員
			if("admin".equalsIgnoreCase(username)) {
				if(user!=null) {
					request.getSession().setAttribute("user", user);
					request.getRequestDispatcher("/pages/manager/manager.jsp").forward(request, response);					
				}
			}else {
				if(user!=null) {
					//一般使用者，轉發至使用者畫面
					//透過session保存資料使其能被轉發
					request.getSession().setAttribute("user", user);
					request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);						
				}
			}
			
			//把錯誤訊息回顯至客戶端
			request.setAttribute("msg", "查無此會員資料");
			//並提供客戶輸入錯誤的原值
			request.setAttribute("username", username);
			//頁面跳轉
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
			
		}else if("regist".equals(action)) {
			
			//獲取驗證碼值
			String token = (String) request.getSession().getAttribute("KAPTCHA_SESSION_KEY");
			//獲取後立即取消，以避免一直產生新的
			request.getSession().removeAttribute("KAPTCHA_SESSION_KEY");
			
			UserService service=new UserServiceImpl();
			User user = service.checkUsername(username);
			
			if(token!=null && token.equals(code)) {
				if(user!=null) {
					request.setAttribute("msg", "用戶名已存在");
					request.setAttribute("username", username);
					request.setAttribute("email", email);
					request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
				}else {
					service.add(new User(null,username,password,email));
					request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
				}
				
			}else {
				//把錯誤訊息回顯至客戶端
				request.setAttribute("msg", "驗證碼錯誤");
				request.setAttribute("username", username);
				request.setAttribute("email", email);
				request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
			}
		}
	}

}
