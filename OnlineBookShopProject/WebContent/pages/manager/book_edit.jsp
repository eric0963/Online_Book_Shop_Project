<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編輯書籍</title>
<%@ include file="/pages/shared/header.jsp" %>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>
	<%@ include file="/pages/shared/manager_header.jsp" %>
		
		<div id="main">
			<form action="AddServlet" method="post">
			<input type="hidden" name="pageNo" value="${param.pageNo }">
				<table>
					<tr>
						<td>書名</td>
						<td>價格</td>
						<td>作者</td>
						<td>銷量</td>
						<td>庫存</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<td><input name="name" type="text" value="PS I love you"/></td>
						<td><input name="price" type="text" value="300"/></td>
						<td><input name="author" type="text" value="Eric"/></td>
						<td><input name="sales" type="text" value="200"/></td>
						<td><input name="stock" type="text" value="300"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>
		
<%@ include file="/pages/shared/footer.jsp" %>
</body>
</html>