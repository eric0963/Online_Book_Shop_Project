<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="model.User"%>

<%--  <%
 	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	User user=(User)request.getSession().getAttribute("user");
	if(user==null){
		response.sendRedirect("pages/user/login.jsp");
	}
 %>   --%>    
   

    	<div id="header">
			<img class="logo_img" alt="" src="static/img/bookLogo.jpg" >
			<span class="wel_word">後台管理</span>
			<div>
				<span>管理員-<span class="um_span">${sessionScope.user.username}</span></span>
				<a href="PageServlet">圖書管理</a>
				<a href="ShowAllOrdersServlet">訂單管理</a>
				<a href="LogoutServlet">登出</a>
			</div>
	</div>
	
	
	
	
    