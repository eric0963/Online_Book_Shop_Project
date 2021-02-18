<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書城首頁</title>
<%@ include file="/pages/shared/header.jsp" %>
<style type="text/css">
	.logo_img{
		height:80px;
		width:150px;
	}
	#header div{
		margin-left:250px;
	}
</style>
<script type="text/javascript">
	$(function(){
		$("button.addToCart").click(function(){
			var bookId=$(this).attr("bookId");
			location.href="AddItemServlet?id="+bookId;
		});
	});
</script>
</head>
<body>
	
	<%@ include file="/pages/shared/login_index_header.jsp" %>	
	
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="PageByPriceServlet" method=get>
					價格：<input id="min" type="text" name="min" value="${param.min }"> 元 -
						<input id="max" type="text" name="max" value="${param.max }"> 元
						<input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align:center">
				<c:if test="${empty sessionScope.cart.items }">
					購物車目前是空的
				</c:if>
				
				<c:if test="${not empty sessionScope.cart.items }">
					<div style="text-align: center">
						<span>購物車中有${sessionScope.cart.totalCount }本書</span>
						<div>
							您剛剛將<span style="color: red">${sessionScope.newBook }</span>加入購物車中
						</div>
					</div>
				</c:if>
			</div>
			
			
			<c:forEach items="${requestScope.page.items }" var="page">
				<div class="b_list">
					<div class="img_div">
						<img class="book_img" alt="" src="${page.img_path}" />
					</div>
					<div class="book_info">
						<div class="book_name">
							<span class="sp1">書名</span>
							<span class="sp2">${page.name }</span>
						</div>
						<div class="book_author">
							<span class="sp1">作者</span>
							<span class="sp2">${page.author}</span>
						</div>
						<div class="book_price">
							<span class="sp1">價格</span>
							<span class="sp2">${page.price }</span>
						</div>
						<div class="book_sales">
							<span class="sp1">銷量</span>
							<span class="sp2">${page.sales }</span>
						</div>
						<div class="book_amount">
							<span class="sp1">庫存</span>
							<span class="sp2">${page.stock }</span>
						</div>
						<div class="book_add">
							<button bookId="${page.id}" class="addToCart">加入購物車</button>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		
	<%@ include file="/pages/shared/page_jump.jsp" %>	
	
	</div>
	
	<%@ include file="/pages/shared/footer.jsp" %>
</body>
</html>