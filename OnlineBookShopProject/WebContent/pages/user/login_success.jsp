<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入頁面</title>
<%@ include file="/pages/shared/header.jsp" %>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
</style>
</head>
<body>
	<%@ include file="/pages/shared/login_header.jsp" %>
		
		<div id="main">
		
			<h1>歡迎回來！ <a href="pages/cart/cart.jsp" style="color:blue">購物車</a></h1>
	
		</div>
		
	<%@ include file="/pages/shared/footer.jsp" %>
</body>
</html>