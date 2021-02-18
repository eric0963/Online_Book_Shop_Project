<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購物車</title>
<%@ include file="/pages/shared/header.jsp" %>
<script type="text/javascript">
	$(function(){
		$("input.updateBtn").change(function(){
			var bookName=$(this).parent().parent().find("td:first").text();
			var count=this.value;
			var bookId=$(this).attr("bookId");
			if(confirm("確定要修改["+bookName+"]數量為"+count+"嗎?")){
				location.href="UpdateItemServlet?id="+bookId+"&count="+count;
			}else{
				this.value=this.defaultValue;
			}
		});
		$("#clearCart").click(function(){
			return confirm("清空後將不可回復，確定要清空嗎？");
		});
		$("a.deleteItem").click(function(){
			return confirm("確定要刪除["+$(this).parent().parent().find("td:first").text()+"]嗎？");
		});
	});
</script>
	
</head>
<body>
	
	<%@ include file="/pages/shared/login_header.jsp" %>
	
	<div id="main">
	
		<table>
			<tr>
				<td>書名</td>
				<td>數量</td>
				<td>單價</td>
				<td>金額</td>
				<td>操作</td>
			</tr>	
			
			<c:if test="${empty sessionScope.cart.items }">
				<tr>
					<td colspan="5">購物車目前是空的!!<br>
					<a href="index.jsp" style="color:blue">購物去</a></td>
				</tr>
			</c:if>
			
			<c:if test="${not empty sessionScope.cart.items }">
				<c:forEach items="${sessionScope.cart.items }" var="cart">
					<tr>
						<td>${cart.value.name }</td>
						<td>
							<input type="text" value="${cart.value.count }" 
							style="width:30px; height:20px;text-align:center"
							class="updateBtn" bookId="${cart.value.id }">
						</td>
						<td>${cart.value.price }</td>
						<td>${cart.value.totalPrice }</td>
						<td><a class="deleteItem" href="DeleteItemServlet?id=${cart.value.id}">刪除</a></td>
					</tr>	
				</c:forEach>	
			</c:if>
		</table>
		
		<c:if test="${not empty sessionScope.cart.items }">
			<div class="cart_info">
				<span class="cart_span">購物車中共有<span class="b_count">${sessionScope.cart.totalCount }</span>本書</span>
				<span class="cart_span">總金額<span class="b_price">${sessionScope.cart.totalPrice }</span>元</span>
				<span class="cart_span"><a id="clearCart" href="ClearItemServlet">清空購物車</a></span>
				<span class="cart_span"><a href="CreateOrderServlet">結帳去</a></span>
			</div>
		</c:if>
	</div>
	
	<%@ include file="/pages/shared/footer.jsp" %>
</body>
</html>