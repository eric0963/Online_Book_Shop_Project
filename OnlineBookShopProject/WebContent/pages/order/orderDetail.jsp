<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的訂單</title>
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
		
		<table>
			<tr>
				<td>書名</td>
				<td>數量</td>
				<td>價錢</td>
				<td>單項總價</td>
			</tr>
		
				<c:forEach items="${requestScope.orderDetail }" var="order">
					<tr>
						<td>${order.name }</td>
						<td>${order.count }</td>
						<td>${order.price }</td>
						<td>${order.totalPrice }</td>
					</tr>
				</c:forEach>	
		</table>
	</div>
	
	<%@ include file="/pages/shared/footer.jsp" %>
</body>
</html>