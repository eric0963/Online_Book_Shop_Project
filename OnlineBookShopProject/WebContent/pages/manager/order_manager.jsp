<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>後台管理</title>
<%@ include file="/pages/shared/header.jsp" %>
<script type="text/javascript">
	$(function(){
		$("a.sendCFM").click(function(){
			return confirm("確定更改[ "+$(this).parent().parent().find("td:first").text()+" ]狀態嗎？")
		});
	});
</script>
</head>
<body>
	
	<%@ include file="/pages/shared/manager_header.jsp" %>
	
	<div id="main">
	
		<div id="searchOrder">
			<form action="GetOrderNumberServlet" method="get" >
				<input type="text" name="orderNumber" value="${param.orderNumber}"
				placeholder="請輸入訂單編號">
				<input type="submit" value="查詢">
			</form>
		</div>
		<table>
			<tr>
				<td>訂單編號</td>
				<td>日期</td>
				<td>金額</td>
				<td>詳情</td>
				<td>發貨</td>
			</tr>	
			
			<c:forEach items="${requestScope.orders }" var="order">
				<tr>
					<td>${order.orderId }</td>
					<td>${order.createTime}</td>
					<td>${order.price }</td>
					
					<c:choose>
						<c:when test="${order.status==0 }">
							<td>未發貨</td>
						</c:when>
						<c:when test="${order.status==1 }">
							<td>已發貨</td>
						</c:when>
						<c:otherwise>
							<td>已簽收</td>
						</c:otherwise>
					</c:choose>
					
					<c:choose>
						<c:when test="${order.status==0 }">
							<td><a class="sendCFM" href="SendOrderServlet?status=${order.status }&id=${order.orderId}">點擊發貨</a></td>
						</c:when>
						<c:when test="${order.status==1 }">
							<td><a class="sendCFM" href="SendOrderServlet?status=${order.status }&id=${order.orderId}">點擊簽收</a></td>
						</c:when>
						<c:otherwise>
							<td>完成的訂單</td>
						</c:otherwise>
					</c:choose>
				</tr>	
			
			</c:forEach> 
		
		</table>
	</div>
	
	<%@ include file="/pages/shared/footer.jsp" %>
</body>
</html>