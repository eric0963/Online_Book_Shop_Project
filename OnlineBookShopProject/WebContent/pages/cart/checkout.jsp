<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結算頁面</title>
<%@ include file="/pages/shared/header.jsp" %>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<%@ include file="/pages/shared/login_header.jsp" %>
	
	<div id="main">
		
		<h1>您的訂單已結算，訂單號為${sessionScope.orderId }</h1>
		
	
	</div>
	
<%@ include file="/pages/shared/footer.jsp" %>
</body>
</html>