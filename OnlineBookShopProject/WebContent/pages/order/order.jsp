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
				<td>日期</td>
				<td>金額</td>
				<td>狀態</td>
				<td>詳情</td>
			</tr>
			
				<c:if test="${empty requestScope.order }">
					<tr>
						<td colspan="4"><h2>目前您沒有訂單</h2></td>
					</tr>
				</c:if>
				
			<c:if test="${not empty requestScope.order }">
				<c:forEach items="${requestScope.order }" var="order">
				
					<tr>
						<td>${order.createTime }</td>
						<td>${order.price }</td>
						
						<c:if test="${order.status==0 }">
							<td>未發貨</td>
						</c:if>
						<c:if test="${order.status==1 }">
							<td>已發貨</td>
						</c:if>
						<c:if test="${order.status==2 }">
							<td>已簽收</td>
						</c:if>
						
						<td><a href="ShowOrderDetailServlet?&orderId=${order.orderId }">查看詳情</a></td> 
					</tr>	
				</c:forEach>		
			</c:if>
		</table>
	</div>
	
	<%@ include file="/pages/shared/footer.jsp" %>
</body>
</html>