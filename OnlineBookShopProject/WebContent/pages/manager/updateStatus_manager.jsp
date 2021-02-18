<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>後台管理</title>
<%@ include file="/pages/shared/header.jsp" %>
</head>
<body>
	
	<%@ include file="/pages/shared/manager_header.jsp" %>
	
	<div id="main">
	
		<table>
			<tr>
				<td>訂單編號</td>
				<td>日期</td>
				<td>金額</td>
				<td>詳情</td>
				<td>確認</td>
			</tr>	
			
			<c:forEach items="${requestScope.orders }" var="order">
				<tr>
					<td>${order.orderId }</td>
					<td>${order.createTime}</td>
					<td>${order.price }</td>
					
					<td><select name="status">
						<option>請選擇狀態</option>
						<option value="0">未發貨</option>
						<option value="1">已發貨</option>
						<option value="2">已簽收</option>
					</select></td>
					
					<td><a href="#">點擊更改</a></td>
				</tr>	
			
			</c:forEach> 
		
		</table>
	</div>
	
	<%@ include file="/pages/shared/footer.jsp" %>
</body>
</html>