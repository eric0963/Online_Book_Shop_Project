<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>圖書管理</title>
<%@ include file="/pages/shared/header.jsp" %>
<style type="text/css">
	#main table{
		margin-top:30px;
	}
</style>
<script type="text/javascript">
	$(function(){
		
		$("#jump").click(function(){
			var pageNo=$("#pn_input").val();
			location.href="http://localhost:8080/BookTest3/PageServlet?pageNo="+pageNo;
		});
		$("a.deleteItem").click(function(){
			return confirm("確定要刪除[ "+$(this).parent().parent().find("td:first").text()+ " ]嗎？")
		});
	});
</script>
</head>
<body>
	
	<%@ include file="/pages/shared/manager_header.jsp" %>
	
	<div id="main">
		<table>
			<tr>
				<td>書名</td>
				<td>價格</td>
				<td>作者</td>
				<td>銷量</td>
				<td>庫存</td>
				<td colspan="2">操作</td>
			</tr>	
			
			<c:forEach items="${requestScope.page.items}" var="book">
				<tr>
					<td>${book.name }</td>
					<td>${book.price }</td>
					<td>${book.author }</td>
					<td>${book.sales }</td>
					<td>${book.stock }</td>
					<td><a href="GetBookServlet?id=${book.id }&pageNo=${requestScope.page.pageNo}">修改</a></td>
					<td><a class="deleteItem" href="DeleteServlet?id=${book.id }&pageNo=${requestScope.page.pageNo}">刪除</a></td>
				</tr>	
			
			</c:forEach>	
			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp?pageNo=${requestScope.page.pageTotal}">添加書籍</a></td>
			</tr>	
		</table>
	<%@ include file="/pages/shared/page_jump.jsp" %>	
	</div>
	
	<%@ include file="/pages/shared/footer.jsp" %>
</body>
</html>