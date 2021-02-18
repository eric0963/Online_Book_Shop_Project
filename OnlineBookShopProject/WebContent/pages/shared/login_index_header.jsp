<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <div id="header">
			<img class="logo_img" alt="" src="static/img/bookLogo.jpg" >
			<span class="wel_word">購書網</span>
			<div>
				<c:if test="${empty sessionScope.user }">
					<a href="pages/user/login.jsp">登入</a> | 
					<a href="pages/user/regist.jsp">註冊</a> 
				</c:if>
				<c:if test="${not empty sessionScope.user }">
					<span>使用者：<span class="um_span">${sessionScope.user.username}</span></span>
					<a href="CheckMyOrdersServlet">我的訂單</a>
					<a href="pages/cart/cart.jsp">購物車</a>					
					<a href="LogoutServlet">登出</a>
					<a href="index.jsp">回首頁</a>
				</c:if>
			</div>
	</div>