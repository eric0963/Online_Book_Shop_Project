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
			<span class="wel_word">購書網</span>
			<div>
				<span>使用者：<span class="um_span">${sessionScope.user.username}</span></span>
				<a href="CheckMyOrdersServlet">我的訂單</a>
				<a href="pages/cart/cart.jsp">購物車</a>
				<a href="LogoutServlet">登出</a>
				<a href="index.jsp">回首頁</a>
			</div>
	</div>